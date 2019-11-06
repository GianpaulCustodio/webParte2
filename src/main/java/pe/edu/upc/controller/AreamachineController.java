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

import pe.edu.upc.entity.Areamachine;
import pe.edu.upc.service.IAreamachineService;

@Controller
@RequestMapping("/areamachines")
public class AreamachineController {
	@Autowired
	private IAreamachineService amService;

	@RequestMapping("/index")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/new")
	public String newAreamachine(Model model) {
		model.addAttribute("areamachine", new Areamachine());
		return "/areamachine/areamachine";
	}

	@PostMapping("/save")
	public String saveAreamachine(@Valid Areamachine areamachine, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "/areamachine/areamachine";
		} else {
			int rpta = amService.insert(areamachine);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/areamachine/areamachine";
			} else {
				model.addAttribute("mensaje", "Se guardo correctamente");
				status.setComplete();
			}
			model.addAttribute("listAreamachines", amService.list());
		}
		return "/areamachine/listAreamachines";
	}

	@GetMapping("/list")
	public String listAreamachines(Model model) {
		try {
			model.addAttribute("areamachine", new Areamachine());
			model.addAttribute("listAreamachines", amService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/areamachine/listAreamachines";
	}

	@RequestMapping("/update/{id}")
	public String updateAreamachine(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Areamachine> areamachine = amService.listId(id);

		if (areamachine == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/areamachine/listAreamachines";
		} else {
			model.addAttribute("areamachine", areamachine);
			return "/areamachine/areamachine";
		}
	}

	@RequestMapping("/delete")
	public String deleteAreamachines(Map<String, Object> model, @RequestParam(value = "id_Areamachine") Integer id) {
		try {
			if (id != null && id > 0) {

				amService.delete(id);
				model.put("listAreamachines", amService.list());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar");
			model.put("listAreamachines", amService.list());

		}
		return "/areamachine/listAreamachines";
	}
}
