package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entity.Inspection;

public interface IInspectionService {
	public Integer insert(Inspection inspection);

	public List<Inspection> list();

	Optional<Inspection> listId(int id_Inspection);

	public void delete(int id_Inspection);
}
