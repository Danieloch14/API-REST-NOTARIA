package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoParroquiaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parroquia")
public class CatalogoParroquiaController {
	
	@Autowired
	private CatalogoParroquiaRepository catalogoParroquiaRepository;
	
	@Autowired
	private DireccionRepository direccionRepository;
	
	public CatalogoParroquiaController(CatalogoParroquiaRepository cor) {
		this.catalogoParroquiaRepository = cor;
	}
	
	@GetMapping("/all")
	public List<CatalogoParroquia> allParroquias() {
		return catalogoParroquiaRepository.findAll();
	}
	
	//Busca parroquias por id de direccion
	@GetMapping("/all/{id}")
	public List<CatalogoParroquia> catalogoParroquiasbyIdDireccion(@PathVariable long id) {
		Long idParroquia;
		List<Direccion> direccion = direccionRepository.findByIdDirecciones(id);
		idParroquia = direccion.get(0).getCatalogoParroquia();
		return catalogoParroquiaRepository.findByIdParroquias(idParroquia);
	}
}
