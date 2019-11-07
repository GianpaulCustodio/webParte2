package pe.edu.upc.repository;

import java.util.Date;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import pe.edu.upc.entity.Inspection;

@Repository
public interface IInspectionRepository extends JpaRepository<Inspection,Integer> {

}
