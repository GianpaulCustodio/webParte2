package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;

import pe.edu.upc.entity.Areamachine;

public interface IAreamachineService {
	public Integer insert(Areamachine areamachine);

	public List<Areamachine> list();

	Optional<Areamachine> listId(int id_Areamachine);

	public void delete(int id_Areamachine);
}
