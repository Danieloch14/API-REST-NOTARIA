package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoCanton;

public interface CatalogoCantonRepository extends JpaRepository<CatalogoCanton, Long>{
	//Busca cantones por ID
	@Query( value = "SELECT * FROM CATALOGOCANTON WHERE (IDCANTON = ?)",  nativeQuery = true)
	List<CatalogoCanton> findByIdCanton(@Param("IDCANTON") Long IDCANTON); 
}
