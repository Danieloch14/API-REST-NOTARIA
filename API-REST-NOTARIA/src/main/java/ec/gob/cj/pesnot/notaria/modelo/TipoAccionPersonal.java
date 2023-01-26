package ec.gob.cj.pesnot.notaria.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

@Entity
@Table(name = "TIPOACCIONPERSONAL")
@EntityListeners(AuditingEntityListener.class)
public class TipoAccionPersonal {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "IDTIPOACCIONPERSONAL")
	private Long IDTIPOACCIONPERSONAL;
	
	@Column(name = "NOMBRETIPOACCIONPERSONAL")
	private String NOMBRETIPOACCIONPERSONAL;
	
	@Column(name = "ESTADOACTIVO")
	private boolean ESTADOACTIVO;

	public TipoAccionPersonal(Long iDTIPOACCIONPERSONAL, String nOMBRETIPOACCIONPERSONAL, boolean eSTADOACTIVO) {
		super();
		IDTIPOACCIONPERSONAL = iDTIPOACCIONPERSONAL;
		NOMBRETIPOACCIONPERSONAL = nOMBRETIPOACCIONPERSONAL;
		ESTADOACTIVO = eSTADOACTIVO;
	}

	public TipoAccionPersonal() {
		super();
	}

	public Long getIDTIPOACCIONPERSONAL() {
		return IDTIPOACCIONPERSONAL;
	}

	public void setIDTIPOACCIONPERSONAL(Long iDTIPOACCIONPERSONAL) {
		IDTIPOACCIONPERSONAL = iDTIPOACCIONPERSONAL;
	}

	public String getNOMBRETIPOACCIONPERSONAL() {
		return NOMBRETIPOACCIONPERSONAL;
	}

	public void setNOMBRETIPOACCIONPERSONAL(String nOMBRETIPOACCIONPERSONAL) {
		NOMBRETIPOACCIONPERSONAL = nOMBRETIPOACCIONPERSONAL;
	}

	public boolean isESTADOACTIVO() {
		return ESTADOACTIVO;
	}

	public void setESTADOACTIVO(boolean eSTADOACTIVO) {
		ESTADOACTIVO = eSTADOACTIVO;
	}
	
	
	
	
}
