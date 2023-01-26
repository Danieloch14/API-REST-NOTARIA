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
import ec.gob.cj.pesnot.notaria.modelo.CatalogoProvincia;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoCantonRepository;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoParroquiaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoProvinciaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/provincia")
public class CatalogoProvinciaController {
	@Autowired
	private CatalogoProvinciaRepository catalogoProvinciaRepository;
	
	@Autowired
	private CatalogoCantonRepository catalogoCantonRepository;
	
	public CatalogoProvinciaController(CatalogoProvinciaRepository por) {
		this.catalogoProvinciaRepository = por;
	}
	
	@GetMapping("/all")
	public List<CatalogoProvincia> allProvincias() {
		return catalogoProvinciaRepository.findAll();
	}
	
	//Busca provincias por id de canton
	@GetMapping("/all/{id}")
	public List<CatalogoProvincia> catalogoProvincianbyIdCanton(@PathVariable long id) {
		Long idprovincia;
		List<CatalogoCanton> canton = catalogoCantonRepository.findByIdCanton(id);
		idprovincia = canton.get(0).getCatalogoProvincia();
		return catalogoProvinciaRepository.findByIdProvincia(idprovincia);
	}
}
