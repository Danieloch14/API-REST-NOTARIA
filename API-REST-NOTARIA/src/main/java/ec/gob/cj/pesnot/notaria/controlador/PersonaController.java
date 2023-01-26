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
import ec.gob.cj.pesnot.notaria.modelo.Persona;
import ec.gob.cj.pesnot.notaria.repositorio.NotarioRepository;
import ec.gob.cj.pesnot.notaria.repositorio.PersonaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/persona")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private NotarioRepository notarioRepository;
	
	public PersonaController(PersonaRepository noR) {
		this.personaRepository = noR;
	}
	
	//Busca persona por id de notario
	@GetMapping("/all/{id}")
	public List<Persona> persona(@PathVariable long id) {
		Long idPersona;
		List<Notario> notario = notarioRepository.findByIdNotario(id);
		idPersona = notario.get(0).getIDPERSONA();
		return personaRepository.findByIdPersona(idPersona);
	}
	
	//Busca persona por cédula
	@GetMapping("/cedula/{cedula}")
	public List<Persona> personaByCedula(@PathVariable String cedula) {
		return personaRepository.findByCedulaPersona(cedula);
	}
	
	@GetMapping("/all")
	public List<Persona> allPersonas() {
		return personaRepository.findAll();
	}
}
