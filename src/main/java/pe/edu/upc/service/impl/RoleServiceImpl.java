package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Role;
import pe.edu.upc.repository.IRoleRepository;
import pe.edu.upc.service.IRoleService;

@Service
public class RoleServiceImpl implements IRoleService {
	
	@Autowired
	private IRoleRepository rR;

	@Override
	public Integer insert(Role role) {
		int aux = rR.findByN_Rol(role.getN_Rol());
		if (aux == 0) {
			rR.save(role);
		}
		return aux;
	}

	@Override
	public List<Role> list() {
		return rR.findAll();
	}

	@Override
	public Optional<Role> listId(int id_Role) {
		return rR.findById(id_Role);
	}

	@Override
	public void delete(int id_Role) {
		rR.deleteById(id_Role);		
	}

}
