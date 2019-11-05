package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Brand;
import pe.edu.upc.repository.IBrandRepository;
import pe.edu.upc.service.IBrandService;


@Service
public class BrandServiceImpl implements IBrandService {

	@Autowired
	private IBrandRepository bR;

	@Override
	public Integer insert(Brand brand) {
		int aux = bR.findByN_Brand(brand.getN_Brand());
		if (aux == 0) {
			bR.save(brand);
		}
		return aux;
	}

	@Override
	public List<Brand> list() {
		return bR.findAll();
	}

	@Override
	public Optional<Brand> listId(int id_Brand) {
		return bR.findById(id_Brand);
	}

	@Override
	public void delete(int id_Brand) {
		bR.deleteById(id_Brand);		
	}


}
