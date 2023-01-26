package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;
import ec.gob.cj.pesnot.notaria.modelo.*;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/direccion")
public class DireccionController {
	
	@Autowired
	private DireccionRepository direccionRepository;

	@Autowired
	private NotariaRepository notariaRepository;
	
	public DireccionController(DireccionRepository dor) {
		this.direccionRepository = dor;
	}
	
	@GetMapping("/all")
	public List<Direccion> allDirecciones() {
		return direccionRepository.findAll();
	}
	
	//Busca direcciones por id de notaria
	@GetMapping("/all/{id}")
	public List<Direccion> Direccion(@PathVariable long id) {
		Long idDireccion;
		List<Notaria> notaria = notariaRepository.findByIdNotaria(id);
		idDireccion = notaria.get(0).getIDDIRECCION();
		return direccionRepository.findByIdDirecciones(idDireccion);
	}
	
	//Crea una nueva dirección 
	@PostMapping("/create")
	public Direccion createTabla(@RequestBody Direccion direccion) {
		return direccionRepository.save(direccion);
	}
	
	
	
//	//Modifica direccion por id de notaria
//	@PutMapping("{id}")
//    public Direccion updateDireccion(@PathVariable long id,@RequestBody Direccion direccion) {
//		List<Direccion> direccionAnterior = direccionRepository.findByIdDirecciones(id);
////		notariaAnterior.get(0).setIDDIRECCION(notaria.getIDDIRECCION());
//		direccionAnterior.get(0).setCALLESECUNDARIADIRECCION(direccion.getCALLESECUNDARIADIRECCION());
//		direccionAnterior.get(0).setCALLEPRINCIPALDIRECCION(direccion.getCALLEPRINCIPALDIRECCION());
//		direccionAnterior.get(0).setREFERENCIADIRECCION(direccion.getREFERENCIADIRECCION());
//		direccionAnterior.get(0).setSECTORDIRECCION(direccion.getSECTORDIRECCION());;
//		return direccionRepository.save(direccionAnterior.get(0));
//    }
	
	
	
}
