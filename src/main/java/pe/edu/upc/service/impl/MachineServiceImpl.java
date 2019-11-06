package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Machine;
import pe.edu.upc.repository.IMachineRepository;
import pe.edu.upc.service.IMachineService;


@Service
public class MachineServiceImpl implements IMachineService {
	@Autowired
	private IMachineRepository sP;

	@Override
	@Transactional
	public Integer insert(Machine machine) {
		int rpta = sP.findbyCMachine(machine.getcMachine());
		if (rpta == 0) {
			sP.save(machine);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(int id_Machine) {
		sP.deleteById(id_Machine);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Machine> list() {
		// TODO Auto-generated method stub
		return sP.findAll(Sort.by(Sort.Direction.ASC, "cMachine"));
	}

	@Override
	public Optional<Machine> listId(int id_Machine) {
		// TODO Auto-generated method stub
		return sP.findById(id_Machine);
	}

}
