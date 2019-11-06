package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Machine;


@Repository
public interface IMachineRepository extends JpaRepository<Machine, Integer>{
	@Query("select count(s.c_Machine) from Machine s where s.c_Machine =:c_Machine")
	public int findbyC_Machine(@Param("c_Machine") String c_Machine);

}
