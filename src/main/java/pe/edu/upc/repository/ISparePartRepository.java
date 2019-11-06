package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.SparePart;
@Repository
public interface ISparePartRepository extends JpaRepository<SparePart, Integer> {
	@Query("select count(c.n_SparePart) from SparePart c where c.n_SparePart =:n_SparePart")
	public int findNameSparePart(@Param("n_SparePart") String n_SparePart);
}
