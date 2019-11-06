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

import pe.edu.upc.entity.Sparepart;
import pe.edu.upc.service.IBrandService;
import pe.edu.upc.service.ISparePartService;



@Controller
@RequestMapping("/spareparts")
public class SparePartController {
	@Autowired
	private ISparePartService sService;
	@Autowired
	private IBrandService bService;

	@GetMapping("/new")
	public String newSparePart(Model model) {
		model.addAttribute("sparepart", new Sparepart());
		model.addAttribute("listBrands", bService.list());
		return "sparepart/sparepart";
	}

	@PostMapping("/save")
	public String saveSparePart(@Valid Sparepart sparepart, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listBrands", bService.list());
			return "sparepart/sparepart";
		} else {
			int rpta = sService.insert(sparepart);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listBrands", bService.list());
				return "/sparepart/sparepart";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listSpareParts", sService.list());

		return "/sparepart/listSparePart";
	}

	@GetMapping("/list")
	public String listSparePart(Model model) {
		try {
			model.addAttribute("sparepart", new Sparepart());
			model.addAttribute("listSpareParts", sService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/sparepart/listSparePart";
	}
	@RequestMapping("/delete")
	public String deleteSparePart(Map<String, Object> model, @RequestParam(value = "id_Sparepart") Integer id) {
		try {
			if (id != null && id > 0) {
				sService.delete(id);
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar un producto");
		}
		model.put("listProducts", sService.list());

//		return "redirect:/categories/list";
		return "/sparepart/listSparePart";
	}
}
