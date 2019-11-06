package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Sparepart;
@Repository
public interface ISparePartRepository extends JpaRepository<Sparepart, Integer>{
	@Query("select count(s.nSparepart) from Sparepart s where s.nSparepart =:nSparepart")
	public int findbyN_SparePart(@Param("nSparepart") String nSparepart);

}
