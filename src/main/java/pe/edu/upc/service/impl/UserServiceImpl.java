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
	public void status_change(Users user) {

		uR.save(user);
	}
	@Override
	@Transactional
	public Integer insert(Users user, int valid) {
		user.setF_Estado(true);
		int rpta = uR.findbyN_User(user.getD_user());
		if (valid == 0) {
			if (rpta == 0) {
				uR.save(user);
				return rpta;
			}
		}
		if(valid==1)
		{
			uR.save(user);
			rpta=0;
			return rpta;
		}
		return rpta;
	}

	@Override
	@Transactional
	public void delete(int id_User) {
		uR.deleteById(id_User);
	}

	@Override
	@Transactional(readOnly = true)
	public List<Users> list() {
		// TODO Auto-generated method stub
		return uR.findAll(Sort.by(Sort.Direction.ASC, "nUser"));
	}

	@Override
	public Optional<Users> listId(int id_User) {
		return uR.findById(id_User);
	}

	@Override
	@Transactional
	public Users change_status(Users user) {
		user.setF_Estado(!user.getF_Estado());
		return user;
	}
}
