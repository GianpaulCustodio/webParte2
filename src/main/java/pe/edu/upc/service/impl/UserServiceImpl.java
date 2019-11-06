package pe.edu.upc.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import pe.edu.upc.entity.Users;
import pe.edu.upc.repository.IUserRepository;
import pe.edu.upc.service.IUserService;

@Service
public class UserServiceImpl implements IUserService {
	@Autowired
	private IUserRepository uR;

	@Override
	@Transactional
	public Integer insert(Users user) {
		int rpta = uR.findbyN_SparePart(user.getN_User());
		if (rpta == 0) {
			uR.save(user);
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(int id_user) {
		uR.deleteById(id_user);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Users> list() {
		// TODO Auto-generated method stub
		return uR.findAll(Sort.by(Sort.Direction.ASC, "n_User"));
	}
	
	@Override
	public Optional<Users> listId(int id_user) {
		return uR.findById(id_user);
	}
}
