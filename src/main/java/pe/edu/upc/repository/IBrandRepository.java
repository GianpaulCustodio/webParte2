package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Brand;

@Repository
public interface IBrandRepository extends JpaRepository<Brand, Integer> {

	@Query("select count(b.n_Brand) from Brand b where b.n_Brand=:n_Brand")
	public int findByN_Brand(@Param("n_Brand") String n_Brand);
}
