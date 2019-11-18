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

import pe.edu.upc.entity.Inspection;
import pe.edu.upc.service.IInspectionService;
import pe.edu.upc.service.IMachineService;
import pe.edu.upc.service.IUserService;

@Controller
@RequestMapping("/inspections")
public class InspectionController {
	
	@Autowired
	private IMachineService mService;
	@Autowired
	private IUserService uService;
	@Autowired
	private IInspectionService iService;

	@GetMapping("/new")
	public String newInspection(Model model) {
		model.addAttribute("inspection", new Inspection());
		model.addAttribute("listMachines", mService.list());
		model.addAttribute("listUsers", uService.list());
		return "inspection/inspection";
	}

	@PostMapping("/save")
	public String saveInspection(@Valid Inspection inspection, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listMachines", mService.list());
			model.addAttribute("listUsers", uService.list());
			return "inspection/inspection";
		} else {
			iService.insert(inspection);
			
		}
		model.addAttribute("listInspections",iService.list());

		return "/inspection/listInspection";
	}

	@GetMapping("/list")
	public String listInspection(Model model) {
		try {
			model.addAttribute("inspection", new Inspection());
			model.addAttribute("listInspections", iService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/inspection/listInspection";
	}
	
	
	@RequestMapping("/update/{id}")
	public String updateInspection(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Inspection> inspection = iService.listId(id);
		if (inspection == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/inspection/listInspections";
		} else {
			model.addAttribute("inspection", inspection);
			model.addAttribute("listMachines", mService.list());
			model.addAttribute("listUsers", uService.list());
			return "/inspection/inspection";
		}
	}
	
	@RequestMapping("/delete")
	public String deleteInspection(Map<String, Object> model, @RequestParam(value = "idInspection") Integer id) {
		try {
			if (id != null && id > 0) {
				iService.delete(id);
				
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "Necesita eliminar el registro dependiente primero.");
		}
		model.put("listInspections", iService.list());
		return "/inspection/listInspection";
	}
}
	
