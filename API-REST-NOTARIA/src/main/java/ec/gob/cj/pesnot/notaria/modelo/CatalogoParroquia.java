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
@Table(name = "CATALOGOPARROQUIA")
public class CatalogoParroquia {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDPARROQUIA;
	
//	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "IDCANTON")
//	@JsonProperty(access = Access.WRITE_ONLY)
	private Long IDCANTON;
	
//	@OneToMany(mappedBy = "catalogoParroquia", cascade = CascadeType.ALL)
//	private Set<Direccion> direcciones = new HashSet<>();
//	
	
	@Column(name = "NOMBREPARROQUIA")
	private String NOMBREPARROQUIA;
	
	@Column(name = "ESTADOPARROQUIA")
	private boolean ESTADOPARROQUIA;

	

	public CatalogoParroquia(long iDPARROQUIA, long iDCANTON, String nOMBREPARROQUIA, boolean eSTADOPARROQUIA) {
		super();
		IDPARROQUIA = iDPARROQUIA;
		IDCANTON = iDCANTON;
		NOMBREPARROQUIA = nOMBREPARROQUIA;
		ESTADOPARROQUIA = eSTADOPARROQUIA;
	}
	
	

	public CatalogoParroquia() {
		super();
	}



	public Long getIDPARROQUIA() {
		return IDPARROQUIA;
	}

	public void setIDPARROQUIA(Long iDPARROQUIA) {
		IDPARROQUIA = iDPARROQUIA;
	}

	

//	public Set<Direccion> getDirecciones() {
//		return direcciones;
//	}
//
//	public void setDirecciones(Set<Direccion> direcciones) {
//		this.direcciones = direcciones;
//		for(Direccion direccion : direcciones) {
//			direccion.setCatalogoParroquia(this);
//		}
//	}

	public String getNOMBREPARROQUIA() {
		return NOMBREPARROQUIA;
	}

	public void setNOMBREPARROQUIA(String nOMBREPARROQUIA) {
		NOMBREPARROQUIA = nOMBREPARROQUIA;
	}

	public boolean isESTADOPARROQUIA() {
		return ESTADOPARROQUIA;
	}

	public void setESTADOPARROQUIA(boolean eSTADOPARROQUIA) {
		ESTADOPARROQUIA = eSTADOPARROQUIA;
	}

	public Long getIDCANTON() {
		return IDCANTON;
	}

	public void setIDCANTON(Long iDCANTON) {
		IDCANTON = iDCANTON;
	}
	
	

	
	
	
	

}
