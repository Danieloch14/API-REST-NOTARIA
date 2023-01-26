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
	@Column(name = "idNotario")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDNOTARIO;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "idPersona")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDPERSONA;
		
	@Column(name = "numAutorizacionNotario")
	private String NUMAUTORIZACIONNOTARIO;
	
	@Column(name = "estadoActivo")
	private boolean ESTADOACTIVO;

	

	public Notario(Long iDNOTARIO, Long iDPERSONA, String nUMAUTORIZACIONNOTARIO, boolean eSTADOACTIVO) {
		super();
		IDNOTARIO = iDNOTARIO;
		IDPERSONA = iDPERSONA;
		NUMAUTORIZACIONNOTARIO = nUMAUTORIZACIONNOTARIO;
		ESTADOACTIVO = eSTADOACTIVO;
	}

	public Notario() {
		super();
	}

	public Long getIDNOTARIO() {
		return IDNOTARIO;
	}

	public void setIDNOTARIO(Long iDNOTARIO) {
		IDNOTARIO = iDNOTARIO;
	}

	public Long getIDPERSONA() {
		return IDPERSONA;
	}

	public void setIDPERSONA(Long iDPERSONA) {
		IDPERSONA = iDPERSONA;
	}

	public String getNUMAUTORIZACIONNOTARIO() {
		return NUMAUTORIZACIONNOTARIO;
	}

	public void setNUMAUTORIZACIONNOTARIO(String nUMAUTORIZACIONNOTARIO) {
		NUMAUTORIZACIONNOTARIO = nUMAUTORIZACIONNOTARIO;
	}

	public boolean isESTADOACTIVO() {
		return ESTADOACTIVO;
	}

	public void setESTADOACTIVO(boolean eSTADOACTIVO) {
		ESTADOACTIVO = eSTADOACTIVO;
	}
	
	
	
}
	

	