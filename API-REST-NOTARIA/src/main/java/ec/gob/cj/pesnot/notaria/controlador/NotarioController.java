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
import ec.gob.cj.pesnot.notaria.repositorio.AccionPersonalRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotarioRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/notario")
public class NotarioController {
	
	@Autowired
	private AccionPersonalRepository accionPersonalRepository;

	@Autowired
	private NotarioRepository notarioRepository;
	
	public NotarioController(NotarioRepository dor) {
		this.notarioRepository = dor;
	}
	
	//Busca notario por id de accion de personal
	@GetMapping("/all/{id}")
	public List<Notario> notario(@PathVariable long id) {
		Long idNotario;
		List<AccionPersonal> accionPersonal = accionPersonalRepository.findByIdAccionPersonal(id);
		idNotario = accionPersonal.get(0).getIDNOTARIO();
		return notarioRepository.findByIdNotario(idNotario);
	}

	//Busca todas las ascciones de personal
	@GetMapping("/all")
	public List<Notario> allNotario() {
		return notarioRepository.findAll();
	}
}
