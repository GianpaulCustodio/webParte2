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

import pe.edu.upc.entity.Role;
import pe.edu.upc.service.IRoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
	@Autowired
	private IRoleService rService;

	@RequestMapping("/index")
	public String welcome() {
		return "welcome";
	}

	@GetMapping("/new")
	public String newRole(Model model) {
		model.addAttribute("role", new Role());
		return "/role/role";
	}

	@PostMapping("/save")
	public String saveRole(@Valid Role role, BindingResult result, Model model, SessionStatus status)
			throws Exception {
		if (result.hasErrors()) {
			return "/role/role";
		} else {
			int rpta = rService.insert(role);
			if (rpta > 0) {
				model.addAttribute("mensaje", "Ya existe");
				return "/role/role";
			} else {
				model.addAttribute("mensaje", "Se guardo correctamente");
				status.setComplete();
			}
			model.addAttribute("listRoles", rService.list());
		}
		return "/role/listRoles";
	}

	@GetMapping("/list")
	public String listRoles(Model model) {
		try {
			model.addAttribute("role", new Role());
			model.addAttribute("listRoles", rService.list());
		} catch (Exception e) {
			model.addAttribute("error", e.getMessage());
		}
		return "/role/listRoles";
	}

	@RequestMapping("/update/{id}")
	public String updateRole(@PathVariable int id, Model model, RedirectAttributes objRedir) {
		Optional<Role> role = rService.listId(id);

		if (role == null) {
			objRedir.addFlashAttribute("mensaje", "Ocurrio un error");
			return "redirect:/role/listRoles";
		} else {
			model.addAttribute("role", role);
			return "/role/role";
		}
	}

	@RequestMapping("/delete")
	public String deleteRole(Map<String, Object> model, @RequestParam(value = "id") Integer id) {
		try {
			if (id != null && id > 0) {

				rService.delete(id);
				model.put("listRoles", rService.list());
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
			model.put("mensaje", "No se puede eliminar");
			model.put("listRoles", rService.list());

		}
		return "/role/listRoles";
	}
}
