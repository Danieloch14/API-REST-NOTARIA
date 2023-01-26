package ec.gob.cj.pesnot.notaria.modelo;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "TablaAdministracionNotaria")
@EntityListeners(AuditingEntityListener.class)
public class TablaAdministracionNotaria {
	@Id
	private Long idNotaria;
	private String acronimoNotaria;
	private String nombreProvincia;
	private String nombreCanton;
	private String numeroNotaria;
	private String callePrincipal;
	private String calleSecundaria;
	private Boolean estadoNotaria;

	public TablaAdministracionNotaria() {
	}

	public TablaAdministracionNotaria(Long idNotaria, String acronimoNotaria, String nombreProvincia,
			String nombreCanton, String numeroNotaria, String callePrincipal, String calleSecundaria,
			Boolean estadoNotaria) {
		this.idNotaria = idNotaria;
		this.acronimoNotaria = acronimoNotaria;
		this.nombreProvincia = nombreProvincia;
		this.nombreCanton = nombreCanton;
		this.numeroNotaria = numeroNotaria;
		this.callePrincipal = callePrincipal;
		this.calleSecundaria = calleSecundaria;
		this.estadoNotaria = estadoNotaria;
	}

	public Long getIdNotaria() {
		return idNotaria;
	}

	public void setIdNotaria(Long idNotaria) {
		this.idNotaria = idNotaria;
	}

	public String getAcronimoNotaria() {
		return acronimoNotaria;
	}

	public void setAcronimoNotaria(String acronimoNotaria) {
		this.acronimoNotaria = acronimoNotaria;
	}

	public String getNombreProvincia() {
		return nombreProvincia;
	}

	public void setNombreProvincia(String nombreProvincia) {
		this.nombreProvincia = nombreProvincia;
	}

	public String getNombreCanton() {
		return nombreCanton;
	}

	public void setNombreCanton(String nombreCanton) {
		this.nombreCanton = nombreCanton;
	}

	public String getNumeroNotaria() {
		return numeroNotaria;
	}

	public void setNumeroNotaria(String numeroNotaria) {
		this.numeroNotaria = numeroNotaria;
	}

	public String getCallePrincipal() {
		return callePrincipal;
	}

	public void setCallePrincipal(String callePrincipal) {
		this.callePrincipal = callePrincipal;
	}

	public String getCalleSecundaria() {
		return calleSecundaria;
	}

	public void setCalleSecundaria(String calleSecundaria) {
		this.calleSecundaria = calleSecundaria;
	}

	public Boolean getEstadoNotaria() {
		return estadoNotaria;
	}

	public void setEstadoNotaria(Boolean estadoNotaria) {
		this.estadoNotaria = estadoNotaria;
	}

	@Override
	public String toString() {
		return "TablaAdministracionNotaria [idNotaria=" + idNotaria + ", acronimoNotaria=" + acronimoNotaria
				+ ", nombreProvincia=" + nombreProvincia + ", nombreCanton=" + nombreCanton + ", numeroNotaria="
				+ numeroNotaria + ", callePrincipal=" + callePrincipal + ", calleSecundaria=" + calleSecundaria
				+ ", estadoNotaria=" + estadoNotaria + "]";
	}
}
