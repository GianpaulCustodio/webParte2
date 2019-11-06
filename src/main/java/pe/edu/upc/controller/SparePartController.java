package pe.edu.upc.controller;

import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.support.SessionStatus;

import pe.edu.upc.entity.SparePart;
import pe.edu.upc.service.IBrandService;
import pe.edu.upc.service.ISparePartService;

@Controller
@RequestMapping("/spareparts")
public class SparePartController {

	@Autowired
	private ISparePartService spService;
	
	@Autowired
	private IBrandService bService;

	@RequestMapping("/index")
	public String irWelcome() {
		return "welcome";
	}

	@GetMapping("/new")
	public String newComputadora(Model model) {
		model.addAttribute("sparepart", new SparePart());
		model.addAttribute("listBrand", bService.list());
		return "/sparepart/sparepart";
	}

	@PostMapping("/save")
	public String saveBrand(@Valid SparePart sparepart, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "/sparepart/sparepart";
		} else {
			int rpta = spService.insert(sparepart);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/sparepart/sparepart";
			} else {
				model.addAttribute("mensaje", "Se guardo correctamente");
				status.setComplete();
			}
			model.addAttribute("listSpareParts", spService.list());
		}
		return "/sparepart/sparepart";
	}


	@GetMapping("/list")
	public String listComputadora(Model model) {
		try {
			model.addAttribute("sparepart", new SparePart());
			model.addAttribute("listSpareParts", spService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}

		return "spareparts/listSpareParts";
	}

	@RequestMapping("/delete")
	public String deleteComputadora(Map<String, Object> model, @RequestParam(value = "id_SparePart") Integer id) {
		try {
			if (id != null && id > 0) {
				spService.delete(id);
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar un producto");
		}
		model.put("listSpareParts", spService.list());

//		return "redirect:/categories/list";
		return "/sparepart/listSparePart";
	}

}
