package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.Direccion;

public interface DireccionRepository extends JpaRepository<Direccion, Long>{
	//Busca direccion por ID
	@Query( value = "SELECT * FROM Direccion  WHERE (idDireccion = ?)",  nativeQuery = true)
	List<Direccion> findByIdDirecciones(@Param("idDireccion") Long idDireccion); 

}
