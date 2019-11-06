package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Role;

public interface IRoleService {
	public Integer insert(Role role);

	public List<Role> list();

	Optional<Role> listId(int id_Role);

	public void delete(int id_Role);
}
