package ec.gob.cj.pesnot.notaria.modelo;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "PERSONA")
public class Persona {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long IDPERSONA;
	/*private Usuario IDUSUARIO;
	private DatosSri IDDATOSRI;
	private Discapacidad IDDISCAPACIDAD;
	private CatalgoGeneroPersona IDGENEROPERSONA;
	private EstadoActivoPersona IDESTADOCIVILPERSONA;
	private CatalagoTipoPersona IDCATALOGOTIPOPERSONA;
	private Direccion IDDIRECCION;
	private CatalogoNacionalidad IDNACIONALIDAD;*/
	
	@Column(name = "NOMBRESPERSONA")
	private String NOMBRESPERSONA;
	
	@Column(name = "APELLIDOSPERSONA")
	private String APELLIDOSPERSONA;
	
	@Column(name = "CEDULAPERSONA")
	private String CEDULAPERSONA;
	
	@Column(name = "RUCPERSONA")
	private String RUCPERSONA;
	
	@Column(name = "FECHANACIMIENTOPERSONA")
	private Date FECHANACIMIENTOPERSONA;
	
	@Column(name = "TIENERUC")
	private boolean TIENERUC;
	
	@Column(name = "EMAILPERSONA")
	private String EMAILPERSONA;
	
	@Column(name = "TELEFONOPERSONA")
	private String TELEFONOPERSONA;
	
	@Column(name = "CELULARPERSONA")
	private String CELULARPERSONA;
	
	@Column(name = "ESTADOACTIVO")
	private boolean ESTADOACTIVO;
	
	
	public Persona(long iDPERSONA, String nOMBRESPERSONA, String aPELLIDOSPERSONA, String cEDULAPERSONA,
			String rUCPERSONA, Date fECHANACIMIENTOPERSONA, boolean tIENERUC, String eMAILPERSONA,
			String tELEFONOPERSONA, String cELULARPERSONA, boolean eSTADOACTIVO) {
		super();
		IDPERSONA = iDPERSONA;
		NOMBRESPERSONA = nOMBRESPERSONA;
		APELLIDOSPERSONA = aPELLIDOSPERSONA;
		CEDULAPERSONA = cEDULAPERSONA;
		RUCPERSONA = rUCPERSONA;
		FECHANACIMIENTOPERSONA = fECHANACIMIENTOPERSONA;
		TIENERUC = tIENERUC;
		EMAILPERSONA = eMAILPERSONA;
		TELEFONOPERSONA = tELEFONOPERSONA;
		CELULARPERSONA = cELULARPERSONA;
		ESTADOACTIVO = eSTADOACTIVO;
	}
	
	

	public Persona() {
		super();
	}



	public Long getIDPERSONA() {
		return IDPERSONA;
	}

	public void setIDPERSONA(Long iDPERSONA) {
		IDPERSONA = iDPERSONA;
	}

	public String getNOMBRESPERSONA() {
		return NOMBRESPERSONA;
	}

	public void setNOMBRESPERSONA(String nOMBRESPERSONA) {
		NOMBRESPERSONA = nOMBRESPERSONA;
	}

	public String getAPELLIDOSPERSONA() {
		return APELLIDOSPERSONA;
	}

	public void setAPELLIDOSPERSONA(String aPELLIDOSPERSONA) {
		APELLIDOSPERSONA = aPELLIDOSPERSONA;
	}

	public String getCEDULAPERSONA() {
		return CEDULAPERSONA;
	}

	public void setCEDULAPERSONA(String cEDULAPERSONA) {
		CEDULAPERSONA = cEDULAPERSONA;
	}

	public String getRUCPERSONA() {
		return RUCPERSONA;
	}

	public void setRUCPERSONA(String rUCPERSONA) {
		RUCPERSONA = rUCPERSONA;
	}

	public Date getFECHANACIMIENTOPERSONA() {
		return FECHANACIMIENTOPERSONA;
	}

	public void setFECHANACIMIENTOPERSONA(Date fECHANACIMIENTOPERSONA) {
		FECHANACIMIENTOPERSONA = fECHANACIMIENTOPERSONA;
	}

	public boolean isTIENERUC() {
		return TIENERUC;
	}

	public void setTIENERUC(boolean tIENERUC) {
		TIENERUC = tIENERUC;
	}

	public String getEMAILPERSONA() {
		return EMAILPERSONA;
	}

	public void setEMAILPERSONA(String eMAILPERSONA) {
		EMAILPERSONA = eMAILPERSONA;
	}

	public String getTELEFONOPERSONA() {
		return TELEFONOPERSONA;
	}

	public void setTELEFONOPERSONA(String tELEFONOPERSONA) {
		TELEFONOPERSONA = tELEFONOPERSONA;
	}

	public String getCELULARPERSONA() {
		return CELULARPERSONA;
	}

	public void setCELULARPERSONA(String cELULARPERSONA) {
		CELULARPERSONA = cELULARPERSONA;
	}

	public boolean isESTADOACTIVO() {
		return ESTADOACTIVO;
	}

	public void setESTADOACTIVO(boolean eSTADOACTIVO) {
		ESTADOACTIVO = eSTADOACTIVO;
	}

	
	
	

}