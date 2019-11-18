package pe.edu.upc.controller;

import java.util.Map;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.service.IBrandService;

@Controller
@RequestMapping("/brands")
public class BrandController {
	@Autowired
	private IBrandService bService;

	@RequestMapping("/index")
	public String welcome() {
		return "index";
	}

	@GetMapping("/new")
	public String newBrand(Model model) {
		model.addAttribute("brand", new Brand());
		return "/brand/brand";
	}

	@PostMapping("/save")
	public String saveBrand(@Valid Brand brand, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "/brand/brand";
		} else {
			int rpta = bService.insert(brand);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/brand/brand";
			} else {
				model.addAttribute("mensaje", "Se guardo correctamente");
				status.setComplete();
			}
			model.addAttribute("listBrands", bService.list());
		}
		return "/brand/brand";
	}
	
	

	@GetMapping("/list")
	public String listBrands(Model model) {
		try {
			model.addAttribute("brand", new Brand());
			model.addAttribute("listBrands", bService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/brand/listBrands";
	}

	@RequestMapping("/update/{id}")
	public String updateBrand(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Brand> brand = bService.listId(id);

		if (brand == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/brand/listBrands";
		} else {
			model.addAttribute("brand", brand);
			return "/brand/brand";
		}
	}

	@RequestMapping("/delete")
	public String deleteBrand(Map<String, Object> model, @RequestParam(value = "id_Brand") Integer id) {
		try {
			if (id != null && id > 0) {

				bService.delete(id);
				model.put("listBrands", bService.list());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar");
			model.put("listBrands", bService.list());

		}
		return "/brand/listBrands";
	}
	@GetMapping("/reportb")
	public String Reportsp(Map<String, Object> model) {
		model.put("listReportb", bService.Reportb());
		return "/report/reportb";
	}
}
