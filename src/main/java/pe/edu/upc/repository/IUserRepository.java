package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Users;
@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
	@Query("select count(u.nUser) from Users u where u.nUser =:nUser")
	public int findbyN_User(@Param("nUser") String n_User);
}
