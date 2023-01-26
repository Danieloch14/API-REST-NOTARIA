package ec.gob.cj.pesnot.notaria.controlador;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.modelo.CatalogoCanton;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoProvincia;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoCantonRepository;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoParroquiaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoProvinciaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/cantones")
public class CatalogoCantonController {
	@Autowired
	private CatalogoParroquiaRepository catalogoParroquiaRepository;
	
	@Autowired
	private CatalogoCantonRepository catalogoCantonRepository;
	
	@Autowired
	private CatalogoProvinciaRepository catalogoProvinciaRepository;
	
	public CatalogoCantonController(CatalogoCantonRepository caor) {
		this.catalogoCantonRepository = caor;
	}
	
	@GetMapping(value = "", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogoCanton> allCantones() {
		return catalogoCantonRepository.findAll();
	}
	
	//Busca cantones por id de parroquia
		@GetMapping(value = "/{id}/parroquia" ,produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CatalogoCanton> catalogoCantonbyIdParroquia(@PathVariable long id) {
			Long idCanton;
			List<CatalogoParroquia> parroquia = catalogoParroquiaRepository.findByIdParroquias(id);
			idCanton = parroquia.get(0).getIDCANTON();
			return catalogoCantonRepository.findByIdCanton(idCanton);
		}
	
	//Busca cantones por id de provincia
	@GetMapping(value = "/{idProvincia}/provincia", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogoCanton> catalogoCantonbyIdProvincia(@PathVariable long idProvincia) {
		Long idProvincia1;
		List<CatalogoProvincia> provincia = catalogoProvinciaRepository.findByIdProvincia(idProvincia);
		idProvincia1 = provincia.get(0).getIDPROVINCIA();
		return catalogoCantonRepository.findByIdProvincia(idProvincia1);
	}
		
	
	//Busca cantones por id de canton
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CatalogoCanton> catalogoCantonbyId(@PathVariable long id) {
			return catalogoCantonRepository.findByIdCanton(id);
		}
	
	
}
