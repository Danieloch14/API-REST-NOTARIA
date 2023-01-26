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
@Table(name = "DIRECCION")
public class Direccion {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDDIRECCION;
	
////	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@Column(name = "IDPARROQUIA")
////	@JsonProperty(access = Access.WRITE_ONLY)
	private Long catalogoParroquia;
	
//	@OneToMany(mappedBy = "IDDIRECCION", cascade = CascadeType.ALL)
//	private Set<Notaria> notarias = new HashSet<>();

	
	@Column(name = "CALLEPRINCIPALDIRECCION")
	private String CALLEPRINCIPALDIRECCION;
	
	@Column(name = "CALLESECUNDARIADIRECCION")
	private String CALLESECUNDARIADIRECCION;
	
	@Column(name = "SECTORDIRECCION")
	private String SECTORDIRECCION;
	
	@Column(name = "REFERENCIADIRECCION")
	private String REFERENCIADIRECCION;
	
	@Column(name = "ESTADOACTIVO")
	private boolean ESTADOACTIVO;

	public Direccion(long i, long j, String cALLEPRINCIPALDIRECCION,
			String cALLESECUNDARIADIRECCION, String sECTORDIRECCION, String rEFERENCIADIRECCION, boolean eSTADOACTIVO) {
		super();
		IDDIRECCION = i;
		this.catalogoParroquia = j;
		CALLEPRINCIPALDIRECCION = cALLEPRINCIPALDIRECCION;
		CALLESECUNDARIADIRECCION = cALLESECUNDARIADIRECCION;
		SECTORDIRECCION = sECTORDIRECCION;
		REFERENCIADIRECCION = rEFERENCIADIRECCION;
		ESTADOACTIVO = eSTADOACTIVO;
	}



	



	public Direccion() {
		super();
	}







	public Long getIDDIRECCION() {
		return IDDIRECCION;
	}

	public void setIDDIRECCION(Long iDDIRECCION) {
		IDDIRECCION = iDDIRECCION;
	}

//	public Set<Notaria> getNotarias() {
//		return notarias;
//	}
//
//	public void setNotarias(Set<Notaria> notarias) {
//		this.notarias = notarias;
////		for(Notaria notaria : notarias) {
////			notaria.setDireccion(this);
////		}
//	}

	public String getCALLEPRINCIPALDIRECCION() {
		return CALLEPRINCIPALDIRECCION;
	}

	public void setCALLEPRINCIPALDIRECCION(String cALLEPRINCIPALDIRECCION) {
		CALLEPRINCIPALDIRECCION = cALLEPRINCIPALDIRECCION;
	}

	public String getCALLESECUNDARIADIRECCION() {
		return CALLESECUNDARIADIRECCION;
	}

	public void setCALLESECUNDARIADIRECCION(String cALLESECUNDARIADIRECCION) {
		CALLESECUNDARIADIRECCION = cALLESECUNDARIADIRECCION;
	}

	public String getSECTORDIRECCION() {
		return SECTORDIRECCION;
	}

	public void setSECTORDIRECCION(String sECTORDIRECCION) {
		SECTORDIRECCION = sECTORDIRECCION;
	}

	public String getREFERENCIADIRECCION() {
		return REFERENCIADIRECCION;
	}

	public void setREFERENCIADIRECCION(String rEFERENCIADIRECCION) {
		REFERENCIADIRECCION = rEFERENCIADIRECCION;
	}
	
	public Long getCatalogoParroquia() {
		return catalogoParroquia;
	}



	public void setCatalogoParroquia(Long catalogoParroquia) {
		this.catalogoParroquia = catalogoParroquia;
	}



	public boolean isESTADOACTIVO() {
		return ESTADOACTIVO;
	}



	public void setESTADOACTIVO(boolean eSTADOACTIVO) {
		ESTADOACTIVO = eSTADOACTIVO;
	}
	
	
	
	
	

	
	
	
	
}
