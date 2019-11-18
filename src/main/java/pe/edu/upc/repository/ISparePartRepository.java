package pe.edu.upc.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Sparepart;
@Repository
public interface ISparePartRepository extends JpaRepository<Sparepart, Integer>{
	@Query("select count(s.nSparepart) from Sparepart s where s.nSparepart =:nSparepart")
	public int findbyN_SparePart(@Param("nSparepart") String nSparepart);

	@Query(value="SELECT * FROM (SELECT s.id_SparePart,s.n_SparePart,count(m.id_Maintenance) as quantity FROM SparePart s join Maintenance m on m.id_SparePart = s.id_SparePart group by s.id_SparePart,s.n_SparePart) AS T1\r\n" + 
			"WHERE quantity IN (SELECT MAX(quantity) FROM ( SELECT count(m.id_Maintenance) as quantity,s.id_SparePart,s.n_SparePart FROM SparePart s join Maintenance m on m.id_SparePart = s.id_SparePart\r\n" + 
			" group by s.id_SparePart,s.n_SparePart) AS T2)",nativeQuery=true)
	List<String[]>Reportsp();
}
