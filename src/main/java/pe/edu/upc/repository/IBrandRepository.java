package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {

	@Query("select count(b.n_Brand) from Brand b where b.n_Brand=:n_Brand")
	public int findByN_Brand(@Param("n_Brand") String n_Brand);
	
	@Query(value="SELECT * FROM (SELECT b.id_Brand,b.n_Brand,count(m.id_Maintenance) as quantity\r\n" + 
			"					FROM Brand b\r\n" + 
			"					join SparePart s on s.id_Brand = b.id_Brand\r\n" + 
			"					join Maintenance m on m.id_SparePart = s.id_SparePart\r\n" + 
			"					group by b.id_Brand,b.n_Brand\r\n" + 
			"	 ) AS T1\r\n" + 
			"WHERE quantity IN (SELECT MAX(quantity)\r\n" + 
			"				   FROM (\r\n" + 
			"					 	SELECT count(m.id_Maintenance) as quantity,b.id_Brand,b.n_Brand\r\n" + 
			"						FROM Brand b\r\n" + 
			"						join SparePart s on s.id_Brand = b.id_Brand\r\n" + 
			"						join Maintenance m on m.id_SparePart = s.id_SparePart\r\n" + 
			"						group by b.id_Brand,b.n_Brand\r\n" + 
			"				   ) AS T2\r\n" + 
			"			 )",nativeQuery=true)
	List<String[]>Reportb();
}
