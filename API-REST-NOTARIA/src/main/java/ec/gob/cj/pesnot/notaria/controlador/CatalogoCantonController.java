package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoCanton;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoCantonRepository;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoParroquiaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/canton")
public class CatalogoCantonController {
	@Autowired
	private CatalogoParroquiaRepository catalogoParroquiaRepository;
	
	@Autowired
	private CatalogoCantonRepository catalogoCantonRepository;
	
	public CatalogoCantonController(CatalogoCantonRepository caor) {
		this.catalogoCantonRepository = caor;
	}
	
	@GetMapping("/all")
	public List<CatalogoCanton> allCantones() {
		return catalogoCantonRepository.findAll();
	}
	
	//Busca cantones por id de parroquia
	@GetMapping("/all/{id}")
	public List<CatalogoCanton> catalogoCantonbyIdParroquia(@PathVariable long id) {
		Long idCanton;
		List<CatalogoParroquia> parroquia = catalogoParroquiaRepository.findByIdParroquias(id);
		idCanton = parroquia.get(0).getIDPARROQUIA();
		return catalogoCantonRepository.findByIdCanton(idCanton);
	}
}
