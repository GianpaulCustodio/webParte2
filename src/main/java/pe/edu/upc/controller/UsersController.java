package pe.edu.upc.controller;

import java.util.Optional;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.support.SessionStatus;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import pe.edu.upc.entity.Users;
import pe.edu.upc.service.IRoleService;
import pe.edu.upc.service.IUserService;

@Controller
@RequestMapping("/users")
public class UsersController {
	@Autowired
	private IUserService uService;
	@Autowired
	private IRoleService rService;
	private int valid=0;
	@GetMapping("/new")
	public String newSparePart(Model model) {
		model.addAttribute("users", new Users());
		model.addAttribute("listRoles", rService.list());
		return "user/user";
	}

	@PostMapping("/save")
	public String saveSparePart( Users user, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			model.addAttribute("listRoles", rService.list());
			return "user/user";
		} else {
			int rpta = uService.insert(user, valid);
			valid=0;
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				model.addAttribute("listRoles", rService.list());
				return "/user/modifuser";
			} else {
				model.addAttribute("mensaje", "Se guardó correctamente");
				status.setComplete();
			}
		}
		model.addAttribute("listUsers", uService.list());

		return "/user/listUser";
	}

	@GetMapping("/list")
	public String listSparePart(Model model) {
		try {
			model.addAttribute("users", new Users());
			model.addAttribute("listUsers", uService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/user/listUser";
	}

	
	@RequestMapping("/estado/{id}")
	public String EstadoSparePart(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Users> user = uService.listId(id);
		
		
		if (user == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/user/listUsers";
		} else {
			user.get().setF_Estado(!(user.get().getF_Estado()));
			uService.status_change(user.get());
			model.addAttribute("listUsers", uService.list());
			return "/user/listUser";
		}
	}
	@RequestMapping("/update/{id}")
	public String updateSparePart(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Users> user = uService.listId(id);

		if (user == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/user/listUsers";
		} else {
			valid=1;
			model.addAttribute("users", user);
			model.addAttribute("listRoles", rService.list());
			return "/user/modifuser";
		}
	}
	
}
