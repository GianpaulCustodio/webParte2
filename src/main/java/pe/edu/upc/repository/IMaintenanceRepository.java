package pe.edu.upc.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Maintenance;


@Repository
public interface IMaintenanceRepository extends JpaRepository<Maintenance, Integer>{
	

}
