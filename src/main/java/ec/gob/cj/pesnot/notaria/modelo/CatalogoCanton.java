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
@Table(name = "CATALOGOCANTON")
public class CatalogoCanton {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCanton")
	private Long IDCANTON;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "idProvincia")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDPROVINCIA;
	
//	@OneToMany(mappedBy = "catalogoCanton", cascade = CascadeType.ALL)
//	private Set<CatalogoParroquia> catalogoParroquia = new HashSet<>();

	@Column(name = "nombreCanton")
	private String NOMBRECANTON;
	
	@Column(name = "estadoCanton")
	private boolean ESTADOCANTON;
	
	

	public CatalogoCanton(Long iDCANTON, Long catalogoProvincia, String nOMBRECANTON, boolean eSTADOCANTON) {
		super();
		IDCANTON = iDCANTON;
		this.IDPROVINCIA = catalogoProvincia;
		NOMBRECANTON = nOMBRECANTON;
		ESTADOCANTON = eSTADOCANTON;
	}
	
	

	public CatalogoCanton() {
		super();
	}



	public Long getIDCANTON() {
		return IDCANTON;
	}

	public void setIDCANTON(Long iDCANTON) {
		IDCANTON = iDCANTON;
	}

	public String getNOMBRECANTON() {
		return NOMBRECANTON;
	}

	public void setNOMBRECANTON(String nOMBRECANTON) {
		NOMBRECANTON = nOMBRECANTON;
	}

	public boolean isESTADOCANTON() {
		return ESTADOCANTON;
	}

	public void setESTADOCANTON(boolean eSTADOCANTON) {
		ESTADOCANTON = eSTADOCANTON;
	}



	public Long getIDPROVINCIA() {
		return IDPROVINCIA;
	}



	public void setIDPROVINCIA(Long iDPROVINCIA) {
		IDPROVINCIA = iDPROVINCIA;
	}

	
	
	
	
	
}
