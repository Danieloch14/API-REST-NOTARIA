package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.modelo.TipoAccionPersonal;

public interface TipoAccionPersonalRepository extends JpaRepository<TipoAccionPersonal, Long>{
	//Busca notarias por id de notarias
	@Query( value = "SELECT * FROM TIPOACCIONPERSONAL  WHERE (IDTIPOACCIONPERSONAL = ?)",  nativeQuery = true)
	List<TipoAccionPersonal> findByIdTipoAccionPersonal(@Param("IDTIPOACCIONPERSONAL ") Long IDTIPOACCIONPERSONAL );
	
	//Busca id's tipos de acciones de personal por nombre
	@Query( value = "SELECT IDTIPOACCIONPERSONAL FROM TIPOACCIONPERSONAL WHERE NOMBRETIPOACCIONPERSONAL like %?%",  nativeQuery = true)
	List<Long> busquedaPorNombre(String NOMBRETIPOACCIONPERSONAL);
	
	
}
