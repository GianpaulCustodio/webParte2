package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Users;
@Repository
public interface IUserRepository extends JpaRepository<Users, Integer> {
	@Query("select count(u.d_user) from Users u where u.d_user =:d_user")
	public int findbyN_User(@Param("d_user") String d_user);
}
