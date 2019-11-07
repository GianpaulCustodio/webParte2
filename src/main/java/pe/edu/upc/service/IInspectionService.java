package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entity.Inspection;

public interface IInspectionService {
	
	
	public void insert(Inspection inspection);

	public List<Inspection> list();

	Optional<Inspection> listId(int idInspection);

	public void delete(int idInspection);
}
