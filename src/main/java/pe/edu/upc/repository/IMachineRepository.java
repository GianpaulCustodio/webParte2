package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Machine;


@Repository
public interface IMachineRepository extends JpaRepository<Machine, Integer>{
	
	@Query("select count(s.cMachine) from Machine s where s.cMachine =:cMachine")
	public int findbyCMachine(@Param("cMachine") String cMachine);
	
	@Query(value="SELECT * FROM (SELECT m.id_Machine,m.c_Machine,count(i.id_Inspection) as quantity\r\n" + 
			"FROM Machine m\r\n" + 
			"join Inspection i on i.id_Machine = m.id_Machine\r\n" + 
			"group by m.id_Machine, m.c_Machine\r\n" + 
			"	 ) AS T1\r\n" + 
			"WHERE quantity IN (SELECT MAX(quantity)\r\n" + 
			"				   FROM (\r\n" + 
			"					 	SELECT count(i.id_Inspection) as quantity,m.id_Machine,m.c_Machine\r\n" + 
			"FROM Machine m\r\n" + 
			"join Inspection i on i.id_Machine = m.id_Machine\r\n" + 
			"group by m.id_Machine, m.c_Machine\r\n" + 
			"				   ) AS T2\r\n" + 
			"			 )",nativeQuery=true)
	List<String[]>Reportm();
}