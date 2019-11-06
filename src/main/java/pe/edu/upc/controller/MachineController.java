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


import pe.edu.upc.entity.Machine;
import pe.edu.upc.service.IAreamachineService;
import pe.edu.upc.service.IBrandService;
import pe.edu.upc.service.IMachineService;



@Controller
@RequestMapping("/machines")
public class MachineController {
	@Autowired
	private IMachineService mService;
	@Autowired
	private IBrandService bService;
	@Autowired
	private IAreamachineService amService;

	@GetMapping("/new")
	public String newMachine(Model model) {
		model.addAttribute("machine", new Machine());
		model.addAttribute("listBrands", bService.list());
		model.addAttribute("listAreamachines", amService.list());
		return "machine/machine";
	}

	@PostMapping("/save")
	public String saveMachine(@Valid Machine machine, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listBrands", bService.list());
			model.addAttribute("listAreamachines", amService.list());
			return "machine/machine";
		} else {
			int rpta = mService.insert(machine);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listBrands", bService.list());
				model.addAttribute("listAreamachines", amService.list());
				return "/machine/machine";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listMachines", mService.list());

		return "/machine/listMachine";
	}

	@GetMapping("/list")
	public String listMachine(Model model) {
		try {
			model.addAttribute("machine", new Machine());
			model.addAttribute("listMachines", mService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/machine/listMachine";
	}
	
	
	@RequestMapping("/update/{id}")
	public String updateMachine(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Machine> machine = mService.listId(id);

		if (machine == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/machine/listMachines";
		} else {
			model.addAttribute("machine", machine);
			model.addAttribute("listBrands", bService.list());
			model.addAttribute("listAreamachines", amService.list());
			return "/machine/machine";
		}
	}
	
	@RequestMapping("/delete")
	public String deleteMachine(Map<String, Object> model, @RequestParam(value = "id_Machine") Integer id) {
		try {
			if (id != null && id > 0) {
				mService.delete(id);
				model.put("mensaje", "Se eliminó correctamente");

			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar el machine");
		}
		model.put("listMachines", mService.list());
		return "/machine/listMachine";
	}
}
