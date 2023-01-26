package ec.gob.cj.pesnot.notaria.repositorio;

import org.springframework.stereotype.Repository;

import ec.gob.cj.pesnot.notaria.modelo.TablaAdministracionNotaria;

import org.springframework.data.jpa.repository.Query;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface TablaAdministracionNotariaRepository extends JpaRepository<TablaAdministracionNotaria, Long> {
	@Query(value = "SELECT NOTARIA.IDNOTARIA AS idNotaria,\r\n"
			+ "					NOTARIA.[ACRONIMONOTARIA] AS acronimoNotaria,\r\n"
			+ "					CATALOGOPROVINCIA.[NOMBREPROVINCIA] AS nombreProvincia,\r\n"
			+ "					CATALOGOCANTON.[NOMBRECANTON] AS nombreCanton,\r\n"
			+ "					NOTARIA.[NUMERONOTARIA] AS numeroNotaria,\r\n"
			+ "					DIRECCION.CALLEPRINCIPALDIRECCION AS callePrincipal,\r\n"
			+ "					DIRECCION.CALLESECUNDARIADIRECCION AS calleSecundaria,\r\n"
			+ "					NOTARIA.[ESTADONOTARIA] AS estadoNotaria\r\n"
			+ "			FROM NOTARIA\r\n"
			+ "			INNER JOIN DIRECCION\r\n"
			+ "				ON NOTARIA.IDDIRECCION = DIRECCION.IDDIRECCION\r\n"
			+ "			INNER JOIN CATALOGOPARROQUIA\r\n"
			+ "				ON CATALOGOPARROQUIA.IDPARROQUIA = DIRECCION.IDPARROQUIA\r\n"
			+ "			INNER JOIN CATALOGOCANTON\r\n"
			+ "				ON CATALOGOCANTON.IDCANTON = CATALOGOPARROQUIA.IDCANTON\r\n"
			+ "			INNER JOIN CATALOGOPROVINCIA\r\n"
			+ "				ON CATALOGOPROVINCIA.IDPROVINCIA = CATALOGOCANTON.IDPROVINCIA\r\n"
			+ "			WHERE NOTARIA.ESTADONOTARIA = 1", nativeQuery = true)
	@Override
	List<TablaAdministracionNotaria> findAll();
}
