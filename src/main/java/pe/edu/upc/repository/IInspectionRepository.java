package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Inspection;

@Repository
public interface IInspectionRepository extends JpaRepository<Inspection,Integer> {
	@Query("select count(i.id_Inspection) from Inspection i where i.id_Inspection =:id_Inspection")
	public int findbyID_Inspection(@Param("id_Inspection") int id_Inspection);
	
}
