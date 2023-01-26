package ec.gob.cj.pesnot.notaria.modelo;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
@Table(name = "ACCIONPERSONAL")
public class AccionPersonal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idAccionPersonal")
	private Long IDACCIONPERSONAL;
	
	@Column(name = "idEstadoAccionPersonal")
	private Long IDESTADOACCIONPERSONAL;
	
	@Column(name = "idNotario")
	private Long IDNOTARIO;
	
	@Column(name = "idNotaria")
	private Long IDNOTARIA;
	
	@Column(name = "idTipoAccionPersonal")
	private Long IDTIPOACCIONPERSONAL;
	
	@Column(name = "numeroAccionPersonal")
	private Long NUMEROACCIONPERSONAL;

	@Column(name = "fechaInicioAccionPersonal")
	private Date FECHAINICIOACCIONPERSONAL;
	
	@Column(name = "fechaFinAccionPersonal")
	private Date FECHAFINACCIONPERSONAL;
	
	@Column(name = "fechaAccionPersonal")
	private Date FECHAACCIONPERSONAL;
	
	/*@Column(name = "VIGENTEACCIONPERSONAL")
	private boolean VIGENTEACCIONPERSONAL;*/
	
	@Column(name = "documentoAccionPersonal")
	private String DOCUMENTOACCIONPERSONAL;
	
	@Column(name = "observacionAccionPersonal")
	private String OBSERVACIONACCIONPERSONAL;
	
	/*@Column(name = "URLACCIONPERSONALDOC")
	private String URLACCIONPERSONALDOC;*/
	
	@Column(name = "estadoActivo")
	private boolean ESTADOACTIVO;

	public AccionPersonal(Long iDACCIONPERSONAL, Long iDESTADOACCIONPERSONAL, Long iDNOTARIO, Long iDNOTARIA,
			Long iDTIPOACCIONPERSONAL, Long nUMEROACCIONPERSONAL, Date fECHAINICIOACCIONPERSONAL,
			Date fECHAFINACCIONPERSONAL, Date fECHAACCIONPERSONAL, String dOCUMENTOACCIONPERSONAL,
			boolean eSTADOACTIVO, String oBSERVACIONACCIONPERSONAL) {
		super();
		IDACCIONPERSONAL = iDACCIONPERSONAL;
		IDESTADOACCIONPERSONAL = iDESTADOACCIONPERSONAL;
		IDNOTARIO = iDNOTARIO;
		IDNOTARIA = iDNOTARIA;
		IDTIPOACCIONPERSONAL = iDTIPOACCIONPERSONAL;
		NUMEROACCIONPERSONAL = nUMEROACCIONPERSONAL;
		FECHAINICIOACCIONPERSONAL = fECHAINICIOACCIONPERSONAL;
		FECHAFINACCIONPERSONAL = fECHAFINACCIONPERSONAL;
		FECHAACCIONPERSONAL = fECHAACCIONPERSONAL;
		DOCUMENTOACCIONPERSONAL = dOCUMENTOACCIONPERSONAL;
		OBSERVACIONACCIONPERSONAL = oBSERVACIONACCIONPERSONAL;
		ESTADOACTIVO = eSTADOACTIVO;
	}

	public AccionPersonal() {
		super();
	}

	public Long getIDACCIONPERSONAL() {
		return IDACCIONPERSONAL;
	}

	public void setIDACCIONPERSONAL(Long iDACCIONPERSONAL) {
		IDACCIONPERSONAL = iDACCIONPERSONAL;
	}

	public Long getIDESTADOACCIONPERSONAL() {
		return IDESTADOACCIONPERSONAL;
	}

	public void setIDESTADOACCIONPERSONAL(Long iDESTADOACCIONPERSONAL) {
		IDESTADOACCIONPERSONAL = iDESTADOACCIONPERSONAL;
	}

	public Long getIDNOTARIO() {
		return IDNOTARIO;
	}

	public void setIDNOTARIO(Long iDNOTARIO) {
		IDNOTARIO = iDNOTARIO;
	}

	public Long getIDNOTARIA() {
		return IDNOTARIA;
	}

	public void setIDNOTARIA(Long iDNOTARIA) {
		IDNOTARIA = iDNOTARIA;
	}

	public Long getIDTIPOACCIONPERSONAL() {
		return IDTIPOACCIONPERSONAL;
	}

	public void setIDTIPOACCIONPERSONAL(Long iDTIPOACCIONPERSONAL) {
		IDTIPOACCIONPERSONAL = iDTIPOACCIONPERSONAL;
	}

	public Long getNUMEROACCIONPERSONAL() {
		return NUMEROACCIONPERSONAL;
	}

	public void setNUMEROACCIONPERSONAL(Long nUMEROACCIONPERSONAL) {
		NUMEROACCIONPERSONAL = nUMEROACCIONPERSONAL;
	}

	public Date getFECHAINICIOACCIONPERSONAL() {
		return FECHAINICIOACCIONPERSONAL;
	}

	public void setFECHAINICIOACCIONPERSONAL(Date fECHAINICIOACCIONPERSONAL) {
		FECHAINICIOACCIONPERSONAL = fECHAINICIOACCIONPERSONAL;
	}

	public Date getFECHAFINACCIONPERSONAL() {
		return FECHAFINACCIONPERSONAL;
	}

	public void setFECHAFINACCIONPERSONAL(Date fECHAFINACCIONPERSONAL) {
		FECHAFINACCIONPERSONAL = fECHAFINACCIONPERSONAL;
	}

	public Date getFECHAACCIONPERSONAL() {
		return FECHAACCIONPERSONAL;
	}

	public void setFECHAACCIONPERSONAL(Date fECHAACCIONPERSONAL) {
		FECHAACCIONPERSONAL = fECHAACCIONPERSONAL;
	}

	public String getDOCUMENTOACCIONPERSONAL() {
		return DOCUMENTOACCIONPERSONAL;
	}

	public void setDOCUMENTOACCIONPERSONAL(String dOCUMENTOACCIONPERSONAL) {
		DOCUMENTOACCIONPERSONAL = dOCUMENTOACCIONPERSONAL;
	}

	public String getOBSERVACIONACCIONPERSONAL() {
		return OBSERVACIONACCIONPERSONAL;
	}

	public void setOBSERVACIONACCIONPERSONAL(String oBSERVACIONACCIONPERSONAL) {
		OBSERVACIONACCIONPERSONAL = oBSERVACIONACCIONPERSONAL;
	}

	public boolean isESTADOACTIVO() {
		return ESTADOACTIVO;
	}

	public void setESTADOACTIVO(boolean eSTADOACTIVO) {
		ESTADOACTIVO = eSTADOACTIVO;
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
