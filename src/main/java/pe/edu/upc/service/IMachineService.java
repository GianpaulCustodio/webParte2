package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Machine;

public interface IMachineService {
	public Integer insert(Machine machine);
	public void insertm(Machine machine);
	public void delete(int id_Machine);

	List<Machine> list();
	Optional<Machine> listId(int id_Machine);
	List<String[]>Reportm();
}
