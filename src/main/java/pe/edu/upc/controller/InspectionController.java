package pe.edu.upc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import pe.edu.upc.entity.Inspection;
import pe.edu.upc.service.IInspectionService;
import pe.edu.upc.service.IMachineService;

@Controller
@RequestMapping("/inspection")
public class InspectionController {

	@Autowired
	private IInspectionService iService;
	
	@Autowired
	private IMachineService bService;
	
	//private IUserService uService;
	
	
	@GetMapping("/new")
	public String newInspection(Model model) {
		model.addAttribute("inspection",new Inspection());
		model.addAttribute("listMachine", bService.list());
		//model.addAttribute("listUser", uService.list());
		return "inspection/inspection";
	}
	
	
	
}
