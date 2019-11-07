package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Users;

public interface IUserService {
	public Integer insert(Users user);

	public void delete(int id_User);

	List<Users> list();
	Optional<Users> listId(int id_User);
	public Users change_status(Users user);
	public void status_change(Users user);
	
	
}
