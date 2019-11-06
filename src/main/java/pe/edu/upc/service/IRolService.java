package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Role;

public interface IRolService {
	public Integer insert(Role role);

	public List<Role> list();

	Optional<Role> listId(int id_Rol);

	public void delete(int id_Rol);
}
