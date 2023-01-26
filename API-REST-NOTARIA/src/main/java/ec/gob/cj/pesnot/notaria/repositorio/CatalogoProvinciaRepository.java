package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoProvincia;

public interface CatalogoProvinciaRepository extends JpaRepository<CatalogoProvincia, Long>{
	//Busca provincia por ID
	@Query( value = "SELECT * FROM CATALOGOPROVINCIA WHERE (IDPROVINCIA = ?)",  nativeQuery = true)
		List<CatalogoProvincia> findByIdProvincia(@Param("IDPROVINCIA") Long IDPROVINCIA); 
}
