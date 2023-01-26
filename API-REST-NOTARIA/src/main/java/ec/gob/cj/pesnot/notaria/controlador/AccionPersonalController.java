package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.repositorio.AccionPersonalRepository;
import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/accionPersonal")
public class AccionPersonalController {
	
	@Autowired
	private AccionPersonalRepository accionPersonalRepository;

	@Autowired
	private NotariaRepository notariaRepository;
	
	public AccionPersonalController(AccionPersonalRepository dor) {
		this.accionPersonalRepository = dor;
	}
	
	//Busca acciones de personal por id de notaria
	@GetMapping("/all/{id}")
	public List<AccionPersonal> accionPersonal(@PathVariable long id) {
		Long idAccionPersonal;
		List<Notaria> notaria = notariaRepository.findByIdNotaria(id);
		idAccionPersonal = notaria.get(0).getIDACCIONPERSONAL();
		return accionPersonalRepository.findByIdAccionPersonal(idAccionPersonal);
	}

	//Busca todas las ascciones de personal
	@GetMapping("/all")
	public List<AccionPersonal> allAccionPersonal() {
		return accionPersonalRepository.findAll();
	}
	
	
	
}
