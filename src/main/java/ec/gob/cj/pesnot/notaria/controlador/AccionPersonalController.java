package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.modelo.TipoAccionPersonal;
import ec.gob.cj.pesnot.notaria.repositorio.AccionPersonalRepository;
import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.TipoAccionPersonalRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/accionesPersonal")
public class AccionPersonalController {
	
	@Autowired
	private AccionPersonalRepository accionPersonalRepository;

	@Autowired
	private NotariaRepository notariaRepository;
	
	@Autowired
	private TipoAccionPersonalRepository tipoAccionPersonalRepository;
	
	public AccionPersonalController(AccionPersonalRepository dor) {
		this.accionPersonalRepository = dor;
	}
	
	//Busca acciones de personal por id de notaria
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccionPersonal> accionPersonal(@PathVariable long id) {
		return accionPersonalRepository.findByIdNotaria(id);
	}

	//Busca todas las ascciones de personal
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<AccionPersonal> allAccionPersonal() {
		return accionPersonalRepository.findAll();
	}
	
//	//Busca acciones de personal por id de tipo de accion de personal
//	@GetMapping("/allByTipoAccionPersonal/{id}")
//	@SuppressWarnings("null")
//	public List<AccionPersonal> accionPersonalByIdTipoAccionPersonal() {
//		final String titular = "Titular";
//		List<AccionPersonal> accionesPersonal = null;
//		List<Long> idsTipoAccionPersonal = tipoAccionPersonalRepository.busquedaPorNombre(titular);
//		for (Long id : idsTipoAccionPersonal) {
//			accionesPersonal.add((AccionPersonal) accionPersonalRepository.findByIdTipoAccionPersonal(id));
//		}
//		return accionesPersonal;
//	}
//	
	
	
	
	
	
	
	
	
}
