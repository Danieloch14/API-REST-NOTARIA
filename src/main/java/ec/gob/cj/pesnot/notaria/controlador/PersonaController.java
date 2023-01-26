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
import ec.gob.cj.pesnot.notaria.modelo.Persona;
import ec.gob.cj.pesnot.notaria.repositorio.NotarioRepository;
import ec.gob.cj.pesnot.notaria.repositorio.PersonaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/personas")
public class PersonaController {
	
	@Autowired
	private PersonaRepository personaRepository;
	
	@Autowired
	private NotarioRepository notarioRepository;
	
	public PersonaController(PersonaRepository noR) {
		this.personaRepository = noR;
	}
	
	//Busca persona por id de notario
	@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> persona(@PathVariable long id) {
		Long idPersona;
		List<Notario> notario = notarioRepository.findByIdNotario(id);
		idPersona = notario.get(0).getIDPERSONA();
		return personaRepository.findByIdPersona(idPersona);
	}
	
	//Busca persona por cédula
	@GetMapping(value = "/{cedula}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> personaByCedula(@PathVariable String cedula) {
		return personaRepository.findByCedulaPersona(cedula);
	}
	
	//Busca persona notario titular por cédula
//	@GetMapping("/notarioTitular/{cedulaNotarioTitular}")
//	public List<Persona> personaNotarioTitularByCedula(@PathVariable String cedulaNotarioTitular) {
//		return personaRepository.findAllPersonaNotarioTitularByCedula(cedulaNotarioTitular);
//	}
	
	//Obtiene  todas las personas
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Persona> allPersonas() {
		return personaRepository.findAll();
	}
	
	
}
