package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.Notario;
import ec.gob.cj.pesnot.notaria.modelo.TipoAccionPersonal;
import ec.gob.cj.pesnot.notaria.repositorio.AccionPersonalRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotarioRepository;
import ec.gob.cj.pesnot.notaria.repositorio.TipoAccionPersonalRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/tipoAccionesPersonal")
public class TipoAccionPersonalController {
	
	@Autowired
	private TipoAccionPersonalRepository tipoAccionPersonalRepository;

	@Autowired
	private AccionPersonalRepository accionPersonalRepository;
	
	public TipoAccionPersonalController(TipoAccionPersonalRepository dor) {
		this.tipoAccionPersonalRepository = dor;
	}
	
	//Busca TipoAccionPersonal por id de accion de personal
	@GetMapping("/{id}")
	public List<TipoAccionPersonal> tipoAccionPersonal(@PathVariable long id) {
		Long idTipoAccionPersonal;
		List<AccionPersonal> accionPersonal = accionPersonalRepository.findByIdAccionPersonal(id);
		idTipoAccionPersonal = accionPersonal.get(0).getIDTIPOACCIONPERSONAL();
		return tipoAccionPersonalRepository.findByIdTipoAccionPersonal(idTipoAccionPersonal);
	}

	//Busca todas las acciones de personal
	@GetMapping("")
	public List<TipoAccionPersonal> allTiposAccionPersonal() {
		return tipoAccionPersonalRepository.findAll();
	}
	
	//Obtiene ID's de tipo de acción de personal por nombre
	@GetMapping("/{nombre}")
	public List<Long> busquedaPorNombre(@PathVariable String nombre) {
		return tipoAccionPersonalRepository.busquedaPorNombre(nombre);
	}
	
	

}
