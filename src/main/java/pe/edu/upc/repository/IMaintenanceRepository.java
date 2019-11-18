package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Maintenance;


@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer>{
	
	@Query(value="SELECT * FROM (select date_trunc('month', d_maintenance) as mes,COUNT(id_maintenance) as quantity\r\n" + 
			"from Maintenance \r\n" + 
			"group by date_trunc('month', d_maintenance)\r\n" + 
			"	 ) AS T1\r\n" + 
			"WHERE quantity IN (SELECT MAX(quantity)\r\n" + 
			"				   FROM (\r\n" + 
			"					 	select COUNT(id_maintenance) as quantity, date_trunc('month', d_maintenance) as mes\r\n" + 
			"from Maintenance \r\n" + 
			"group by date_trunc('month', d_maintenance)\r\n" + 
			"				   ) AS T2\r\n" + 
			"			 )",nativeQuery=true)
	List<String[]>Reportmes();
}
