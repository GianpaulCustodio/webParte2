package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Role;

@Repository
public interface IRoleRepository extends JpaRepository<Role, Integer> {

	@Query("select count(b.n_Role) from Role b where b.n_Role=:n_Role")
	public int findByN_Role(@Param("n_Role") String n_Role);
}
