package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;

public interface CatalogoParroquiaRepository extends JpaRepository<CatalogoParroquia, Long>{
	
	//Busca parroquia por ID
		@Query( value = "SELECT * FROM CATALOGOPARROQUIA WHERE (IDPARROQUIA = ?)",  nativeQuery = true)
		List<CatalogoParroquia> findByIdParroquias(@Param("IDPARROQUIA") Long IDPARROQUIA); 
}
