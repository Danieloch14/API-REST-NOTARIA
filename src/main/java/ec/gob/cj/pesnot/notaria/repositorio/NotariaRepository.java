package ec.gob.cj.pesnot.notaria.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ec.gob.cj.pesnot.notaria.modelo.Notaria;

public interface NotariaRepository extends JpaRepository<Notaria, Long>{
//
//	@Query( value = "SELECT N.[IDNOTARIA],N.[IDACCIONPERSONAL],N.[IDPROGRAMACIONPE],D.[IDDIRECCION],\r\n"
//			+ "	   N.[CODIGO_ESTABLECIMIENTONOTARIA],N.[ACRONIMONOTARIA],\r\n"
//			+ "	   N.[NUMERONOTARIA],N.[NOMBRENOTARIA],N.[TIPONOTARIA],N.[EMAILNOTARIA],N.[TELEFONO1NOTARIA],N.[TELEFONO2NOTARIA], \r\n"
//			+ "	   N.[CELULARNOTARIA],N.[RUCNOTARIA],N.[COORDENADALONGITUDNOTARIA],N.[COORDENADALATITUDNOTARIA],N.[LOGO_NOTARIA],N.[ESTADOOBLIGADOCONTABILIDAD_NOTARIA],\r\n"
//			+ "	   N.[FECHACREACIONNOTARIA],N.[RESOLUCIONCREACION_NOTARIA],N.[DESCRIPCIONNOTARIA],N.[CREADOPORNOTARIA],N.[ESTADONOTARIA],\r\n"
//			+ "	   O.[NOMBREPROVINCIA],C.[NOMBRECANTON],[NOMBRESPERSONA],[APELLIDOSPERSONA]\r\n"
//			+ "FROM NOTARIA N\r\n"
//			+ "INNER JOIN DIRECCION D ON N.IDDIRECCION = D.IDDIRECCION\r\n"
//			+ "INNER JOIN CATALOGOPARROQUIA P ON P.IDPARROQUIA = D.IDPARROQUIA\r\n"
//			+ "INNER JOIN CATALOGOCANTON C ON C.IDCANTON = P.IDCANTON\r\n"
//			+ "INNER JOIN CATALOGOPROVINCIA O ON O.IDPROVINCIA = C.IDPROVINCIA\r\n"
//			+ "INNER JOIN ACCIONPERSONAL A ON N.IDACCIONPERSONAL = A.IDACCIONPERSONAL\r\n"
//			+ "INNER JOIN NOTARIO T ON A.IDNOTARIO = T.IDNOTARIO\r\n"
//			+ "INNER JOIN PERSONA R ON T.IDPERSONA = R.IDPERSONA",  nativeQuery = true)
//	List<Notaria> findAllNotarias();
	
	//Busca notarias por id de notarias
	@Query( value = "SELECT * FROM Notaria  WHERE (idNotaria = ?)",  nativeQuery = true)
	List<Notaria> findByIdNotaria(@Param("idNotaria") Long idNotaria);
			
	//Busca notarias por acrónimo de notaría
	@Query( value = "SELECT idNotaria FROM Notaria WHERE acronimoNotaria like %?%",  nativeQuery = true)
	List<Long> busquedaPorAcronimo(String acronimoNotaria);
	
	//Busca la clave de la firma lectrónica por id de notaria
	@Query( value = "SELECT saltNotaria FROM Notaria WHERE (idNotaria = ?)",  nativeQuery = true)
	List<String> findSalFirmaElectronica(@Param("idNotaria") Long idNotaria);
	
	//Busca la clave salt del hash por id de notaria
	@Query( value = "SELECT claveFirmaElectronicaNotaria FROM Notaria WHERE (idNotaria = ?)",  nativeQuery = true)
	List<String> findFirmaElectronica(@Param("idNotaria") Long idNotaria);
	
	
	
	
	
	
}
