package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;

public interface AccionPersonalRepository extends JpaRepository<AccionPersonal, Long>{
	//Busca accion de personal por ID
	@Query( value = "SELECT * FROM ACCIONPERSONAL  WHERE (IDACCIONPERSONAL = ?)",  nativeQuery = true)
	List<AccionPersonal> findByIdAccionPersonal(@Param("IDACCIONPERSONAL") Long IDACCIONPERSONAL); 
	
}
