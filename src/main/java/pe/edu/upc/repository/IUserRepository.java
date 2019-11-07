package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entity.Users;

public interface IUserRepository extends JpaRepository<Users, Integer> {
	@Query("select count(u.n_User) from Users u where u.n_User =:n_User")
	public int findbyN_SparePart(@Param("n_User") String n_User);
}
