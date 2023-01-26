package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/notaria")
public class NotariaController {
	
	public boolean estado = true;

	@Autowired
	private NotariaRepository notariaRepository;
	
	public NotariaController(NotariaRepository noR) {
		this.notariaRepository = noR;
	}
	
	@GetMapping("/all")
	public List<Notaria> allNotarias() {
		return notariaRepository.findAllNotarias();
	}
	
	@GetMapping("/all/{acronimo}")
	public List<Long> busquedaPorAcronimo(@PathVariable String acronimo) {
		return notariaRepository.busquedaPorAcronimo(acronimo);
	}
	
	@PostMapping("/create")
	public Notaria createTabla(@RequestBody Notaria tabla) {
		return notariaRepository.save(tabla);
	}
	
//	@GetMapping("/all1")
//	public List<Notaria> allNotarias1() {
//		return notariaRepository.findAll();
//	}
	
//	@PostMapping("/create")
//	public Notaria createTabla(@RequestBody Notaria tabla) {
//		return notariaRepository.save(tabla);
//	}
	
	//Actualiza una notaria por ID
	@PutMapping("{id}")
    public Notaria updateNotaria(@PathVariable long id,@RequestBody Notaria notaria) {
		List<Notaria> notariaAnterior = notariaRepository.findByIdNotaria(id);
//		notariaAnterior.get(0).setIDDIRECCION(notaria.getIDDIRECCION());
		notariaAnterior.get(0).setTELEFONO1NOTARIA(notaria.getTELEFONO1NOTARIA());
		notariaAnterior.get(0).setEMAILNOTARIA(notaria.getEMAILNOTARIA());
		notariaAnterior.get(0).setFECHACREACIONNOTARIA(notaria.getFECHACREACIONNOTARIA());
		notariaAnterior.get(0).setRESOLUCIONCREACION_NOTARIA(notaria.getRESOLUCIONCREACION_NOTARIA());
		notariaAnterior.get(0).setESTADONOTARIA(notaria.isESTADONOTARIA());
		notariaAnterior.get(0).setIDACCIONPERSONAL(notaria.getIDACCIONPERSONAL());
		return notariaRepository.save(notariaAnterior.get(0));

        
    }
	
	
}
