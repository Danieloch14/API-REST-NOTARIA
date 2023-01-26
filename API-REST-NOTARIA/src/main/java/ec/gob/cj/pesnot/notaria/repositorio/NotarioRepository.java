package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.Notario;

public interface NotarioRepository extends JpaRepository<Notario, Long>{
	//Busca notario por ID
	@Query( value = "SELECT * FROM NOTARIO  WHERE (IDNOTARIO = ?)",  nativeQuery = true)
	List<Notario> findByIdNotario(@Param("IDNOTARIO") Long IDNOTARIO); 
	
}
