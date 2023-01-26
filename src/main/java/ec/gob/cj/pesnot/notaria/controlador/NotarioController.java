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
import ec.gob.cj.pesnot.notaria.modelo.Notario;
import ec.gob.cj.pesnot.notaria.repositorio.AccionPersonalRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotarioRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/notarios")
public class NotarioController {
	
	@Autowired
	private AccionPersonalRepository accionPersonalRepository;

	@Autowired
	private NotarioRepository notarioRepository;
	
	@Autowired
	private AccionPersonalController accionPersonalController;
	
	public NotarioController(NotarioRepository dor) {
		this.notarioRepository = dor;
	}
	
	//Busca notario por id de accion de personal
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notario> notario(@PathVariable long id) {
		Long idNotario;
		List<AccionPersonal> accionPersonal = accionPersonalRepository.findByIdAccionPersonal(id);
		idNotario = accionPersonal.get(0).getIDNOTARIO();
		return notarioRepository.findByIdNotario(idNotario);
	}

	//Busca todos los objetos Notario
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notario> allNotario() {
		return notarioRepository.findAll();
	}
	
//	@SuppressWarnings("null")
//	public List<Notario> NotarioTitular(){
//		
//		List<Notario> notariosTitulares = null;
//		List<AccionPersonal> accionesPersonal = accionPersonalController.accionPersonalByIdTipoAccionPersonal();
//		for (AccionPersonal accionPersonal : accionesPersonal) {
//			notariosTitulares.add((Notario) notarioRepository.findByIdNotario(accionPersonal.getIDNOTARIO()));
//		}
//		return notariosTitulares;
//		
//	}
}
