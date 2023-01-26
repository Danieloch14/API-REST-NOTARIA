package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoCanton;

public interface CatalogoCantonRepository extends JpaRepository<CatalogoCanton, Long>{
	//Busca cantones por ID
	@Query( value = "SELECT * FROM CatalogoCanton WHERE (idCanton = ?)",  nativeQuery = true)
	List<CatalogoCanton> findByIdCanton(@Param("idCanton") Long idCanton);
	
	//Busca cantones por ID de Provincia 
	@Query( value = "SELECT * FROM CatalogoCanton WHERE (idProvincia = ?)",  nativeQuery = true)
	List<CatalogoCanton> findByIdProvincia(@Param("idProvincia") Long idProvincia);
}
