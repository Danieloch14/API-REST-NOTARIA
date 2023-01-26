package ec.gob.cj.pesnot.notaria.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Convert;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import ec.gob.cj.pesnot.notaria.config.PIIAttributeConverter;

@Entity
@Table(name = "Notaria")
@EntityListeners(AuditingEntityListener.class)
public class Notaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idNotaria")
	private Long IDNOTARIA;

//////	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "idProgramacionPe")
//////	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDPROGRAMACIONPE;

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "idDireccion")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDDIRECCION;

	@Column(name = "codigoEstablecimientoNotaria")
	private String CODIGOESTABLECIMIENTONOTARIA;

	@Column(name = "acronimoNotaria")
	private String ACRONIMONOTARIA;

	@Column(name = "numeroNotaria")
	private String NUMERONOTARIA;

	@Column(name = "tipoNotaria")
	private String TIPONOTARIA;

	@Column(name = "estadoNotaria")
	private boolean ESTADONOTARIA;

	@Column(name = "nombreNotaria")
	private String NOMBRENOTARIA;

	@Column(name = "rucNotaria")
	private String RUCNOTARIA;

	@Column(name = "coordenadaLongitudNotaria")
	private String COORDENADALONGITUDNOTARIA;

	@Column(name = "coordenadaLatitudNotaria")
	private String COORDENADALATITUDNOTARIA;

//	@Column(name = "CODIGOINSTITUCIONALUAF_NOTARIA")
//	private String CODIGOINSTITUCIONALUAF_NOTARIA;

	@Column(name = "logoNotaria")
	private String LOGONOTARIA;

//	@Column(name = "obligadoContabilidadNotaria")
//	private boolean ESTADOOBLIGADOCONTABILIDADNOTARIA;

	@Column(name = "fechaCreacionNotaria")
	private Date FECHACREACIONNOTARIA;

	@Column(name = "resolucionCreacionNotaria")
	private String RESOLUCIONCREACIONNOTARIA;

	@Column(name = "descripcionNotaria")
	private String DESCRIPCIONNOTARIA;

	@Column(name = "creadoPorNotaria")
	private String CREADOPORNOTARIA;

	@Column(name = "emailNotaria")
	private String EMAILNOTARIA;

	@Column(name = "telefono1Notaria")
	private String TELEFONOPRINCIPAL;

	@Column(name = "telefono2Notaria")
	private String TELEFONOSECUNDARIO;

	@Column(name = "celularNotaria")
	private String CELULARNOTARIA;
	
	@Column(name = "firmaElectronicaNotaria")
	private String FIRMAELECTRONICANOTARIA;
	
	@Column(name = "claveFirmaElectronicaNotaria")
	private String CLAVEFIRMAELECTRONICANOTARIA;
	
	@Column(name = "saltNotaria")
	private String SALTNOTARIA;
	
	

	public Notaria() {
		super();
	}
	
	

	public Notaria(Long iDNOTARIA, Long iDPROGRAMACIONPE, Long iDDIRECCION, String cODIGOESTABLECIMIENTONOTARIA,
			String aCRONIMONOTARIA, String nUMERONOTARIA, String tIPONOTARIA, boolean eSTADONOTARIA,
			String nOMBRENOTARIA, String rUCNOTARIA, String cOORDENADALONGITUDNOTARIA, String cOORDENADALATITUDNOTARIA,
			String lOGONOTARIA, Date fECHACREACIONNOTARIA, String rESOLUCIONCREACIONNOTARIA, String dESCRIPCIONNOTARIA,
			String cREADOPORNOTARIA, String eMAILNOTARIA, String tELEFONOPRINCIPAL, String tELEFONOSECUNDARIO,
			String cELULARNOTARIA, String fIRMAELECTRONICANOTARIA, String cLAVEFIRMAELECTRONICANOTARIA) {
		super();
		IDNOTARIA = iDNOTARIA;
		IDPROGRAMACIONPE = iDPROGRAMACIONPE;
		IDDIRECCION = iDDIRECCION;
		CODIGOESTABLECIMIENTONOTARIA = cODIGOESTABLECIMIENTONOTARIA;
		ACRONIMONOTARIA = aCRONIMONOTARIA;
		NUMERONOTARIA = nUMERONOTARIA;
		TIPONOTARIA = tIPONOTARIA;
		ESTADONOTARIA = eSTADONOTARIA;
		NOMBRENOTARIA = nOMBRENOTARIA;
		RUCNOTARIA = rUCNOTARIA;
		COORDENADALONGITUDNOTARIA = cOORDENADALONGITUDNOTARIA;
		COORDENADALATITUDNOTARIA = cOORDENADALATITUDNOTARIA;
		LOGONOTARIA = lOGONOTARIA;
		FECHACREACIONNOTARIA = fECHACREACIONNOTARIA;
		RESOLUCIONCREACIONNOTARIA = rESOLUCIONCREACIONNOTARIA;
		DESCRIPCIONNOTARIA = dESCRIPCIONNOTARIA;
		CREADOPORNOTARIA = cREADOPORNOTARIA;
		EMAILNOTARIA = eMAILNOTARIA;
		TELEFONOPRINCIPAL = tELEFONOPRINCIPAL;
		TELEFONOSECUNDARIO = tELEFONOSECUNDARIO;
		CELULARNOTARIA = cELULARNOTARIA;
		FIRMAELECTRONICANOTARIA = fIRMAELECTRONICANOTARIA;
		CLAVEFIRMAELECTRONICANOTARIA = cLAVEFIRMAELECTRONICANOTARIA;
	}



	public Long getIDNOTARIA() {
		return IDNOTARIA;
	}




	public void setIDNOTARIA(Long iDNOTARIA) {
		IDNOTARIA = iDNOTARIA;
	}




	public Long getIDPROGRAMACIONPE() {
		return IDPROGRAMACIONPE;
	}




	public void setIDPROGRAMACIONPE(Long iDPROGRAMACIONPE) {
		IDPROGRAMACIONPE = iDPROGRAMACIONPE;
	}




	public Long getIDDIRECCION() {
		return IDDIRECCION;
	}




	public void setIDDIRECCION(Long iDDIRECCION) {
		IDDIRECCION = iDDIRECCION;
	}




	public String getCODIGO_ESTABLECIMIENTONOTARIA() {
		return CODIGOESTABLECIMIENTONOTARIA;
	}




	public void setCODIGO_ESTABLECIMIENTONOTARIA(String cODIGO_ESTABLECIMIENTONOTARIA) {
		CODIGOESTABLECIMIENTONOTARIA = cODIGO_ESTABLECIMIENTONOTARIA;
	}




	public String getACRONIMONOTARIA() {
		return ACRONIMONOTARIA;
	}




	public void setACRONIMONOTARIA(String aCRONIMONOTARIA) {
		ACRONIMONOTARIA = aCRONIMONOTARIA;
	}




	public String getNUMERONOTARIA() {
		return NUMERONOTARIA;
	}




	public void setNUMERONOTARIA(String nUMERONOTARIA) {
		NUMERONOTARIA = nUMERONOTARIA;
	}




	public String getTIPONOTARIA() {
		return TIPONOTARIA;
	}




	public void setTIPONOTARIA(String tIPONOTARIA) {
		TIPONOTARIA = tIPONOTARIA;
	}




	public boolean isESTADONOTARIA() {
		return ESTADONOTARIA;
	}




	public void setESTADONOTARIA(boolean eSTADONOTARIA) {
		ESTADONOTARIA = eSTADONOTARIA;
	}




	public String getNOMBRENOTARIA() {
		return NOMBRENOTARIA;
	}




	public void setNOMBRENOTARIA(String nOMBRENOTARIA) {
		NOMBRENOTARIA = nOMBRENOTARIA;
	}




	public String getRUCNOTARIA() {
		return RUCNOTARIA;
	}




	public void setRUCNOTARIA(String rUCNOTARIA) {
		RUCNOTARIA = rUCNOTARIA;
	}




	public String getCOORDENADALONGITUDNOTARIA() {
		return COORDENADALONGITUDNOTARIA;
	}




	public void setCOORDENADALONGITUDNOTARIA(String cOORDENADALONGITUDNOTARIA) {
		COORDENADALONGITUDNOTARIA = cOORDENADALONGITUDNOTARIA;
	}




	public String getCOORDENADALATITUDNOTARIA() {
		return COORDENADALATITUDNOTARIA;
	}




	public void setCOORDENADALATITUDNOTARIA(String cOORDENADALATITUDNOTARIA) {
		COORDENADALATITUDNOTARIA = cOORDENADALATITUDNOTARIA;
	}




	public String getLOGONOTARIA() {
		return LOGONOTARIA;
	}




	public void setLOGONOTARIA(String lOGONOTARIA) {
		LOGONOTARIA = lOGONOTARIA;
	}




//	public boolean isESTADOOBLIGADOCONTABILIDADNOTARIA() {
//		return ESTADOOBLIGADOCONTABILIDADNOTARIA;
//	}
//
//
//
//
//	public void setESTADOOBLIGADOCONTABILIDADNOTARIA(boolean eSTADOOBLIGADOCONTABILIDADNOTARIA) {
//		ESTADOOBLIGADOCONTABILIDADNOTARIA = eSTADOOBLIGADOCONTABILIDADNOTARIA;
//	}




	public Date getFECHACREACIONNOTARIA() {
		return FECHACREACIONNOTARIA;
	}




	public void setFECHACREACIONNOTARIA(Date fECHACREACIONNOTARIA) {
		FECHACREACIONNOTARIA = fECHACREACIONNOTARIA;
	}




	public String getRESOLUCIONCREACIONNOTARIA() {
		return RESOLUCIONCREACIONNOTARIA;
	}




	public void setRESOLUCIONCREACIONNOTARIA(String rESOLUCIONCREACIONNOTARIA) {
		RESOLUCIONCREACIONNOTARIA = rESOLUCIONCREACIONNOTARIA;
	}




	public String getDESCRIPCIONNOTARIA() {
		return DESCRIPCIONNOTARIA;
	}




	public void setDESCRIPCIONNOTARIA(String dESCRIPCIONNOTARIA) {
		DESCRIPCIONNOTARIA = dESCRIPCIONNOTARIA;
	}




	public String getCREADOPORNOTARIA() {
		return CREADOPORNOTARIA;
	}




	public void setCREADOPORNOTARIA(String cREADOPORNOTARIA) {
		CREADOPORNOTARIA = cREADOPORNOTARIA;
	}




	public String getEMAILNOTARIA() {
		return EMAILNOTARIA;
	}




	public void setEMAILNOTARIA(String eMAILNOTARIA) {
		EMAILNOTARIA = eMAILNOTARIA;
	}




	public String getTELEFONOPRINCIPAL() {
		return TELEFONOPRINCIPAL;
	}




	public void setTELEFONOPRINCIPAL(String tELEFONOPRINCIPAL) {
		TELEFONOPRINCIPAL = tELEFONOPRINCIPAL;
	}




	public String getTELEFONOSECUNDARIO() {
		return TELEFONOSECUNDARIO;
	}




	public void setTELEFONOSECUNDARIO(String tELEFONOSECUNDARIO) {
		TELEFONOSECUNDARIO = tELEFONOSECUNDARIO;
	}




	public String getCELULARNOTARIA() {
		return CELULARNOTARIA;
	}




	public void setCELULARNOTARIA(String cELULARNOTARIA) {
		CELULARNOTARIA = cELULARNOTARIA;
	}



	public String getCODIGOESTABLECIMIENTONOTARIA() {
		return CODIGOESTABLECIMIENTONOTARIA;
	}



	public void setCODIGOESTABLECIMIENTONOTARIA(String cODIGOESTABLECIMIENTONOTARIA) {
		CODIGOESTABLECIMIENTONOTARIA = cODIGOESTABLECIMIENTONOTARIA;
	}



	public String getFIRMAELECTRONICANOTARIA() {
		return FIRMAELECTRONICANOTARIA;
	}



	public void setFIRMAELECTRONICANOTARIA(String fIRMAELECTRONICANOTARIA) {
		FIRMAELECTRONICANOTARIA = fIRMAELECTRONICANOTARIA;
	}



	public String getCLAVEFIRMAELECTRONICANOTARIA() {
		return CLAVEFIRMAELECTRONICANOTARIA;
	}



	public void setCLAVEFIRMAELECTRONICANOTARIA(String cLAVEFIRMAELECTRONICANOTARIA) {
		CLAVEFIRMAELECTRONICANOTARIA = cLAVEFIRMAELECTRONICANOTARIA;
	}



	public String getSALTNOTARIA() {
		return SALTNOTARIA;
	}



	public void setSALTNOTARIA(String sALTNOTARIA) {
		SALTNOTARIA = sALTNOTARIA;
	}
	
	
	
	
	
	

}
