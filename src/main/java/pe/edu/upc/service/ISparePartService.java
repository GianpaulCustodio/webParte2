package pe.edu.upc.service;

import java.util.List;

import pe.edu.upc.entity.SparePart;

public interface ISparePartService {
	public Integer insert(SparePart sparepart);


	List<SparePart> list();

	public void delete(int id_SparePart);
}
