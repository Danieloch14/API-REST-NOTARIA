package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.Notario;
import ec.gob.cj.pesnot.notaria.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	//Busca notario por ID
	@Query( value = "SELECT * FROM PERSONA  WHERE (IDPERSONA = ?)",  nativeQuery = true)
	List<Persona> findByIdPersona(@Param("IDPERSONA") Long IDPERSONA); 
	
	@Query(value = "SELECT *\r\n"
			+ "FROM PERSONA\r\n"
			+ "WHERE CEDULAPERSONA like %?%",  nativeQuery = true)
	List<Persona> findByCedulaPersona(String cedula);
}
