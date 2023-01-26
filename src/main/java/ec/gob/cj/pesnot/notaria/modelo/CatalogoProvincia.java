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
@Table(name = "CATALOGOPROVINCIA")
public class CatalogoProvincia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idProvincia")
	private Long IDPROVINCIA;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "idPais")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long catologoPais;
	
//	@OneToMany(mappedBy = "catalogoProvincia", cascade = CascadeType.ALL)
//	private Set<CatalogoCanton> catalogoCanton = new HashSet<>();
	
	@Column(name = "nombreProvincia")
	private String NOMBREPROVINCIA;
	
	@Column(name = "estadoProvincia")
	private boolean ESTADOPROVINCIA;

	

	public CatalogoProvincia(long iDPROVINCIA, long catologoPais, String nOMBREPROVINCIA, boolean eSTADOPROVINCIA) {
		super();
		IDPROVINCIA = iDPROVINCIA;
		this.catologoPais = catologoPais;
		NOMBREPROVINCIA = nOMBREPROVINCIA;
		ESTADOPROVINCIA = eSTADOPROVINCIA;
	}
	
	

	public CatalogoProvincia() {
		super();
	}



	public Long getIDPROVINCIA() {
		return IDPROVINCIA;
	}

	public void setIDPROVINCIA(Long iDPROVINCIA) {
		IDPROVINCIA = iDPROVINCIA;
	}

	public String getNOMBREPROVINCIA() {
		return NOMBREPROVINCIA;
	}

	public void setNOMBREPROVINCIA(String nOMBREPROVINCIA) {
		NOMBREPROVINCIA = nOMBREPROVINCIA;
	}

	public boolean isESTADOPROVINCIA() {
		return ESTADOPROVINCIA;
	}

	public void setESTADOPROVINCIA(boolean eSTADOPROVINCIA) {
		ESTADOPROVINCIA = eSTADOPROVINCIA;
	}

	public Long getCatologoPais() {
		return catologoPais;
	}

	public void setCatologoPais(Long catologoPais) {
		this.catologoPais = catologoPais;
	}
	
	
	
}
