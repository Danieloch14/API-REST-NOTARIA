package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.modelo.Notario;
import ec.gob.cj.pesnot.notaria.modelo.Persona;

public interface PersonaRepository extends JpaRepository<Persona, Long>{
	//Busca notario por ID
	@Query( value = "SELECT * FROM Persona  WHERE (idPersona = ?)",  nativeQuery = true)
	List<Persona> findByIdPersona(@Param("idPersona") Long idPersona); 
	
	@Query(value = "SELECT *\r\n"
			+ "FROM PERSONA\r\n"
			+ "WHERE cedulaPersona like %?%",  nativeQuery = true)
	List<Persona> findByCedulaPersona(String cedula);
	
	@Query( value = "SELECT N.[NOMBRESPERSONA],N.[APELLIDOSPERSONA],N.[CEDULAPERSONA],N.[RUCPERSONA],N.[EMAILPERSONA],N.[TELEFONOPERSONA],N.[CELULARPERSONA],N.[ESTADOACTIVO]\r\n"
			+ "	FROM PERSONA N\r\n"
			+ "	LEFT JOIN NOTARIO O ON O.IDPERSONA = N.IDPERSONA \r\n"
			+ "	INNER JOIN ACCIONPERSONAL A ON A.IDNOTARIO = O.IDNOTARIO \r\n"
			+ "	INNER JOIN TIPOACCIONPERSONAL T ON T.IDTIPOACCIONPERSONAL = A.IDTIPOACCIONPERSONAL\r\n"
			+ "	WHERE T.NOMBRETIPOACCIONPERSONAL LIKE 'Titular' AND N.CEDULAPERSONA LIKE %?%;\r\n"
			+ ""
			,  nativeQuery = true)
	List<Persona> findAllPersonaNotarioTitularByCedula(String cedula);
}
