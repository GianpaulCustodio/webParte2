package pe.edu.upc.service.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.SparePart;
import pe.edu.upc.repository.ISparePartRepository;
import pe.edu.upc.service.ISparePartService;

@Service
public class SparePartServiceImpl implements ISparePartService {
	
	@Autowired
	private ISparePartRepository spR;

	@Override
	public Integer insert(SparePart sparepart) {
		int rpta = spR.findNameSparePart(sparepart.getN_SparePart());
		if (rpta == 0) {
			spR.save(sparepart);
		}
		return rpta;
	}


	@Transactional
	@Override
	public List<SparePart> list() {
		// TODO Auto-generated method stub
		return spR.findAll(Sort.by(Sort.Direction.ASC, "n_SparePart"));
	}

	@Override
	public void delete(int id_SparePart) {
		// TODO Auto-generated method stub
		spR.deleteById(id_SparePart);
	}

}
