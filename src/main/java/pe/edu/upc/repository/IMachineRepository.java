package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Machine;


@Repository
public interface IMachineRepository extends JpaRepository<Machine, Integer>{
	
	@Query("select count(s.cMachine) from Machine s where s.cMachine =:cMachine")
	public int findbyCMachine(@Param("cMachine") String cMachine);
	
	
	

}
