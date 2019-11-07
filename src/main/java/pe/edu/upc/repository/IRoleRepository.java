package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import pe.edu.upc.entity.Role;

public interface IRoleRepository  extends JpaRepository<Role, Integer> {
	@Query("select count(r.n_Rol) from Role r where r.n_Rol=:n_Rol")
	public int findByN_Rol(@Param("n_Rol") String n_Rol);
}
