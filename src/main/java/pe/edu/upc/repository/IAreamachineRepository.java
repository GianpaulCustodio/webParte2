package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Areamachine;

@Repository
public interface IAreamachineRepository extends JpaRepository<Areamachine, Integer> {

	@Query("select count(b.n_Areamachine) from Areamachine b where b.n_Areamachine=:n_Areamachine")
	public int findByN_Areamachine(@Param("n_Areamachine") String n_Areamachine);
	
	@Query(value="SELECT * FROM (SELECT a.id_AreaMachine,a.n_AreaMachine,count(i.id_Inspection) as quantity\r\n" + 
			"FROM AreaMachine a\r\n" + 
			"join Machine m on m.id_AreaMachine=a.id_AreaMachine\r\n" + 
			"join Inspection i on i.id_Machine = m.id_Machine\r\n" + 
			"group by a.id_AreaMachine,a.n_AreaMachine\r\n" + 
			"	 ) AS T1\r\n" + 
			"WHERE quantity IN (SELECT MAX(quantity)\r\n" + 
			"				   FROM (\r\n" + 
			"					 	SELECT count(i.id_Inspection) as quantity,a.id_AreaMachine,a.n_AreaMachine\r\n" + 
			"FROM AreaMachine a\r\n" + 
			"join Machine m on m.id_AreaMachine=a.id_AreaMachine\r\n" + 
			"join Inspection i on i.id_Machine = m.id_Machine\r\n" + 
			"group by a.id_AreaMachine,a.n_AreaMachine\r\n" + 
			"				   ) AS T2\r\n" + 
			"			 )",nativeQuery=true)
	List<String[]>Reporta();
}
