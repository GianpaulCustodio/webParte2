package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Inspection;
import pe.edu.upc.repository.IInspectionRepository;
import pe.edu.upc.service.IInspectionService;

@Service
public class InspectionServiceImpl implements IInspectionService {

	
	@Autowired
	private IInspectionRepository iR;
	
	
	@Override
	@Transactional
	public void insert(Inspection inspection) {
		
			iR.save(inspection);
		
	}

	@Override
	public List<Inspection> list() {
		return iR.findAll(Sort.by(Sort.Direction.ASC,"idInspection"));
	}

	@Override
	public Optional<Inspection> listId(int idInspection) {
		// TODO Auto-generated method stub
		return iR.findById(idInspection);
	}

	@Override
	public void delete(int idInspection) {
		iR.deleteById(idInspection);
		
	}

}
