package pe.edu.upc.service;

import java.util.List;
import java.util.Optional;


import pe.edu.upc.entity.Sparepart;

public interface ISparePartService {
	public Integer insert(Sparepart sparepart);
	public void insertm(Sparepart sparepart);
	public void delete(int id_SparePart);

	List<Sparepart> list();
	Optional<Sparepart> listId(int id_Sparepart);
	List<String[]>Reportsp();
}
