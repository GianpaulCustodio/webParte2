package pe.edu.upc.service;

import java.util.List;

import java.util.Optional;

import pe.edu.upc.entity.Brand;

public interface IBrandService {
	public Integer insert(Brand brand);

	public List<Brand> list();

	Optional<Brand> listId(int id_Brand);

	public void delete(int id_Brand);
	
	List<String[]>Reportb();
}
