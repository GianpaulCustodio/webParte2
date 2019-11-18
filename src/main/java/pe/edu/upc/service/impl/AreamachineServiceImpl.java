package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import pe.edu.upc.entity.Areamachine;
import pe.edu.upc.repository.IAreamachineRepository;
import pe.edu.upc.service.IAreamachineService;


@Service
public class AreamachineServiceImpl implements IAreamachineService {

	@Autowired
	private IAreamachineRepository amR;

	@Override
	public Integer insert(Areamachine areamachine) {
		int aux = amR.findByN_Areamachine(areamachine.getN_Areamachine());
		if (aux == 0) {
			amR.save(areamachine);
		}
		return aux;
	}

	@Override
	public List<Areamachine> list() {
		return amR.findAll();
	}

	@Override
	public Optional<Areamachine> listId(int id_Areamachine) {
		return amR.findById(id_Areamachine);
	}

	@Override
	public void delete(int id_Areamachine) {
		amR.deleteById(id_Areamachine);		
	}

	@Override
	public List<String[]> Reporta() {
		return amR.Reporta();
	}


}
