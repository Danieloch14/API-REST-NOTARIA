package ec.gob.cj.pesnot.notaria.modelo;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "NOTARIA")
@EntityListeners(AuditingEntityListener.class)
public class Notaria {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDNOTARIA")
	private Long IDNOTARIA;

//////	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "IDPROGRAMACIONPE")
//////	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDPROGRAMACIONPE;

//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "IDDIRECCION")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDDIRECCION;

	/*
	 * @ManyToOne(fetch = FetchType.LAZY, optional = false)
	 * 
	 * @JoinColumn(name = "IDCONTACTO")
	 * 
	 * @JsonProperty(access = Access.WRITE_ONLY) private Contacto contacto;
	 */

////	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "IDACCIONPERSONAL")
//////	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDACCIONPERSONAL;

	@Column(name = "CODIGO_ESTABLECIMIENTONOTARIA")
	private String CODIGO_ESTABLECIMIENTONOTARIA;

	@Column(name = "ACRONIMONOTARIA")
	private String ACRONIMONOTARIA;

	@Column(name = "NUMERONOTARIA")
	private String NUMERONOTARIA;

	@Column(name = "TIPONOTARIA")
	private String TIPONOTARIA;

	@Column(name = "ESTADONOTARIA")
	private boolean ESTADONOTARIA;

	@Column(name = "NOMBRENOTARIA")
	private String NOMBRENOTARIA;

	@Column(name = "RUCNOTARIA")
	private String RUCNOTARIA;

	@Column(name = "COORDENADALONGITUDNOTARIA")
	private String COORDENADALONGITUDNOTARIA;

	@Column(name = "COORDENADALATITUDNOTARIA")
	private String COORDENADALATITUDNOTARIA;

//	@Column(name = "CODIGOINSTITUCIONALUAF_NOTARIA")
//	private String CODIGOINSTITUCIONALUAF_NOTARIA;

	@Column(name = "LOGO_NOTARIA")
	private String LOGO_NOTARIA;

	@Column(name = "ESTADOOBLIGADOCONTABILIDAD_NOTARIA")
	private boolean ESTADOOBLIGADOCONTABILIDAD_NOTARIA;

	@Column(name = "FECHACREACIONNOTARIA")
	private Date FECHACREACIONNOTARIA;

	@Column(name = "RESOLUCIONCREACION_NOTARIA")
	private String RESOLUCIONCREACION_NOTARIA;

	@Column(name = "DESCRIPCIONNOTARIA")
	private String DESCRIPCIONNOTARIA;

	@Column(name = "CREADOPORNOTARIA")
	private String CREADOPORNOTARIA;

	@Column(name = "EMAILNOTARIA")
	private String EMAILNOTARIA;

	@Column(name = "TELEFONO1NOTARIA")
	private String TELEFONO1NOTARIA;

	@Column(name = "TELEFONO2NOTARIA")
	private String TELEFONO2NOTARIA;

	@Column(name = "CELULARNOTARIA")
	private String CELULARNOTARIA;
	
	
	

	public Notaria() {
		super();
	}
	
	

	





	public Long getIDNOTARIA() {
		return IDNOTARIA;
	}

	

	public Notaria(Long iDNOTARIA, Long iDPROGRAMACIONPE, Long iDDIRECCION, Long iDACCIONPERSONAL,
			String cODIGO_ESTABLECIMIENTONOTARIA, String aCRONIMONOTARIA, String nUMERONOTARIA, String tIPONOTARIA,
			boolean eSTADONOTARIA, String nOMBRENOTARIA, String rUCNOTARIA, String cOORDENADALONGITUDNOTARIA,
			String cOORDENADALATITUDNOTARIA, String lOGO_NOTARIA, boolean eSTADOOBLIGADOCONTABILIDAD_NOTARIA,
			Date fECHACREACIONNOTARIA, String rESOLUCIONCREACION_NOTARIA, String dESCRIPCIONNOTARIA,
			String cREADOPORNOTARIA, String eMAILNOTARIA, String tELEFONO1NOTARIA, String tELEFONO2NOTARIA,
			String cELULARNOTARIA) {
		super();
		IDNOTARIA = iDNOTARIA;
		IDPROGRAMACIONPE = iDPROGRAMACIONPE;
		IDDIRECCION = iDDIRECCION;
		IDACCIONPERSONAL = iDACCIONPERSONAL;
		CODIGO_ESTABLECIMIENTONOTARIA = cODIGO_ESTABLECIMIENTONOTARIA;
		ACRONIMONOTARIA = aCRONIMONOTARIA;
		NUMERONOTARIA = nUMERONOTARIA;
		TIPONOTARIA = tIPONOTARIA;
		ESTADONOTARIA = eSTADONOTARIA;
		NOMBRENOTARIA = nOMBRENOTARIA;
		RUCNOTARIA = rUCNOTARIA;
		COORDENADALONGITUDNOTARIA = cOORDENADALONGITUDNOTARIA;
		COORDENADALATITUDNOTARIA = cOORDENADALATITUDNOTARIA;
		LOGO_NOTARIA = lOGO_NOTARIA;
		ESTADOOBLIGADOCONTABILIDAD_NOTARIA = eSTADOOBLIGADOCONTABILIDAD_NOTARIA;
		FECHACREACIONNOTARIA = fECHACREACIONNOTARIA;
		RESOLUCIONCREACION_NOTARIA = rESOLUCIONCREACION_NOTARIA;
		DESCRIPCIONNOTARIA = dESCRIPCIONNOTARIA;
		CREADOPORNOTARIA = cREADOPORNOTARIA;
		EMAILNOTARIA = eMAILNOTARIA;
		TELEFONO1NOTARIA = tELEFONO1NOTARIA;
		TELEFONO2NOTARIA = tELEFONO2NOTARIA;
		CELULARNOTARIA = cELULARNOTARIA;
	}









	public void setIDNOTARIA(Long iDNOTARIA) {
		IDNOTARIA = iDNOTARIA;
	}

	
	public Long getIDDIRECCION() {
		return IDDIRECCION;
	}



	public void setIDDIRECCION(Long iDDIRECCION) {
		IDDIRECCION = iDDIRECCION;
	}



	public String getCODIGO_ESTABLECIMIENTONOTARIA() {
		return CODIGO_ESTABLECIMIENTONOTARIA;
	}

	public void setCODIGO_ESTABLECIMIENTONOTARIA(String cODIGO_ESTABLECIMIENTONOTARIA) {
		CODIGO_ESTABLECIMIENTONOTARIA = cODIGO_ESTABLECIMIENTONOTARIA;
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

//	public String getCODIGOINSTITUCIONALUAF_NOTARIA() {
//		return CODIGOINSTITUCIONALUAF_NOTARIA;
//	}
//
//	public void setCODIGOINSTITUCIONALUAF_NOTARIA(String cODIGOINSTITUCIONALUAF_NOTARIA) {
//		CODIGOINSTITUCIONALUAF_NOTARIA = cODIGOINSTITUCIONALUAF_NOTARIA;
//	}

	public String getLOGO_NOTARIA() {
		return LOGO_NOTARIA;
	}

	public void setLOGO_NOTARIA(String lOGO_NOTARIA) {
		LOGO_NOTARIA = lOGO_NOTARIA;
	}

	public boolean isESTADOOBLIGADOCONTABILIDAD_NOTARIA() {
		return ESTADOOBLIGADOCONTABILIDAD_NOTARIA;
	}

	public void setESTADOOBLIGADOCONTABILIDAD_NOTARIA(boolean eSTADOOBLIGADOCONTABILIDAD_NOTARIA) {
		ESTADOOBLIGADOCONTABILIDAD_NOTARIA = eSTADOOBLIGADOCONTABILIDAD_NOTARIA;
	}

	public Date getFECHACREACIONNOTARIA() {
		return FECHACREACIONNOTARIA;
	}

	public void setFECHACREACIONNOTARIA(Date fECHACREACIONNOTARIA) {
		FECHACREACIONNOTARIA = fECHACREACIONNOTARIA;
	}

	public String getRESOLUCIONCREACION_NOTARIA() {
		return RESOLUCIONCREACION_NOTARIA;
	}

	public void setRESOLUCIONCREACION_NOTARIA(String rESOLUCIONCREACION_NOTARIA) {
		RESOLUCIONCREACION_NOTARIA = rESOLUCIONCREACION_NOTARIA;
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

	public String getTELEFONO1NOTARIA() {
		return TELEFONO1NOTARIA;
	}

	public void setTELEFONO1NOTARIA(String tELEFONO1NOTARIA) {
		TELEFONO1NOTARIA = tELEFONO1NOTARIA;
	}

	public String getTELEFONO2NOTARIA() {
		return TELEFONO2NOTARIA;
	}

	public void setTELEFONO2NOTARIA(String tELEFONO2NOTARIA) {
		TELEFONO2NOTARIA = tELEFONO2NOTARIA;
	}

	public String getCELULARNOTARIA() {
		return CELULARNOTARIA;
	}

	public void setCELULARNOTARIA(String cELULARNOTARIA) {
		CELULARNOTARIA = cELULARNOTARIA;
	}

	public Long getIDPROGRAMACIONPE() {
		return IDPROGRAMACIONPE;
	}



	public void setIDPROGRAMACIONPE(Long iDPROGRAMACIONPE) {
		IDPROGRAMACIONPE = iDPROGRAMACIONPE;
	}
	
	



	public Long getIDACCIONPERSONAL() {
		return IDACCIONPERSONAL;
	}



	public void setIDACCIONPERSONAL(Long iDACCIONPERSONAL) {
		IDACCIONPERSONAL = iDACCIONPERSONAL;
	}





	
	
	
	
	
	
	
	

	



	
	
	
	

//	

}
