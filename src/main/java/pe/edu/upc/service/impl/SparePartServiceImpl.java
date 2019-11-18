package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Sparepart;
import pe.edu.upc.repository.ISparePartRepository;
import pe.edu.upc.service.ISparePartService;
@Service
public class SparePartServiceImpl implements ISparePartService {
	@Autowired
	private ISparePartRepository sP;

	@Override
	@Transactional
	public Integer insert(Sparepart sparepart) {
		int rpta = sP.findbyN_SparePart(sparepart.getnSparepart());
		if (rpta == 0) {
			sP.save(sparepart);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(int id_Sparepart) {
		sP.deleteById(id_Sparepart);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Sparepart> list() {
		// TODO Auto-generated method stub
		return sP.findAll(Sort.by(Sort.Direction.ASC, "nSparepart"));
	}
	
	@Override
	public Optional<Sparepart> listId(int id_Sparepart) {
		return sP.findById(id_Sparepart);
	}

	@Override
	public List<String[]> Reportsp() {
		return sP.Reportsp();
	}
}
