package ec.gob.cj.pesnot.notaria.modelo;

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
@Table(name = "NOTARIO")
public class Notario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDNOTARIO;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "IDPERSONA")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDPERSONA;
	
	@Column(name = "NUMAUTORIZACIONNOTARIO")
	private String NUMAUTORIZACIONNOTARIO;
	
	@Column(name = "ESTADONOTARIO")
	private boolean ESTADONOTARIO;
	
	@Column(name = "TIPONOTARIO")
	private String TIPONOTARIO;
	
	@Column(name = "ESTADOACTIVO")
	private boolean ESTADOACTIVO;
	
//	@OneToMany(mappedBy = "notario", cascade = CascadeType.ALL)
//	private Set<AccionPersonal> accionPersonal = new HashSet<>();

	
	

	public Notario() {
		super();
	}

	public Notario(long iDNOTARIO, long iDPERSONA, String nUMAUTORIZACIONNOTARIO, boolean eSTADONOTARIO,
			String tIPONOTARIO, boolean eSTADOACTIVO) {
		super();
		IDNOTARIO = iDNOTARIO;
		IDPERSONA = iDPERSONA;
		NUMAUTORIZACIONNOTARIO = nUMAUTORIZACIONNOTARIO;
		ESTADONOTARIO = eSTADONOTARIO;
		TIPONOTARIO = tIPONOTARIO;
		ESTADOACTIVO = eSTADOACTIVO;
	}

	public Long getIDNOTARIO() {
		return IDNOTARIO;
	}

	public void setIDNOTARIO(Long iDNOTARIO) {
		IDNOTARIO = iDNOTARIO;
	}

	public String getNUMAUTORIZACIONNOTARIO() {
		return NUMAUTORIZACIONNOTARIO;
	}

	public void setNUMAUTORIZACIONNOTARIO(String nUMAUTORIZACIONNOTARIO) {
		NUMAUTORIZACIONNOTARIO = nUMAUTORIZACIONNOTARIO;
	}

	public boolean isESTADONOTARIO() {
		return ESTADONOTARIO;
	}

	public void setESTADONOTARIO(boolean eSTADONOTARIO) {
		ESTADONOTARIO = eSTADONOTARIO;
	}

	public String getTIPONOTARIO() {
		return TIPONOTARIO;
	}

	public void setTIPONOTARIO(String tIPONOTARIO) {
		TIPONOTARIO = tIPONOTARIO;
	}

	public boolean isESTADOACTIVO() {
		return ESTADOACTIVO;
	}

	public void setESTADOACTIVO(boolean eSTADOACTIVO) {
		ESTADOACTIVO = eSTADOACTIVO;
	}

	public Long getIDPERSONA() {
		return IDPERSONA;
	}

	public void setIDPERSONA(Long iDPERSONA) {
		IDPERSONA = iDPERSONA;
	}

	
	
	
	
	
	
	
	
}
