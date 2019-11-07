package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Areamachine;

@Repository
public interface IAreamachineRepository extends JpaRepository<Areamachine, Integer> {

	@Query("select count(b.n_Areamachine) from Areamachine b where b.n_Areamachine=:n_Areamachine")
	public int findByN_Areamachine(@Param("n_Areamachine") String n_Areamachine);
}
