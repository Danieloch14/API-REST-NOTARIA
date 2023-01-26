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
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoCantonRepository;
import ec.gob.cj.pesnot.notaria.repositorio.CatalogoParroquiaRepository;
import ec.gob.cj.pesnot.notaria.repositorio.DireccionRepository;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/parroquias")
public class CatalogoParroquiaController {
	
	@Autowired
	private CatalogoParroquiaRepository catalogoParroquiaRepository;
	
	@Autowired
	private DireccionRepository direccionRepository;
	
	@Autowired
	private CatalogoCantonRepository catalogoCantonRepository;
	
	public CatalogoParroquiaController(CatalogoParroquiaRepository cor) {
		this.catalogoParroquiaRepository = cor;
	}
	
	//Trae todas las parroquias
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogoParroquia> allParroquias() {
		return catalogoParroquiaRepository.findAll();
	}
	
	//Busca parroquias por id de direccion
		@GetMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
		public List<CatalogoParroquia> catalogoParroquiasbyIdDireccion(@PathVariable long id) {
			Long idParroquia;
			List<Direccion> direccion = direccionRepository.findByIdDirecciones(id);
			idParroquia = direccion.get(0).getIDPARROQUIA();
			return catalogoParroquiaRepository.findByIdParroquias(idParroquia);
		}
	
	//Busca parroquias por id de canton
	@GetMapping(value = "/{idCanton}/canton", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<CatalogoParroquia> catalogoParroquiasbyIdCanton(@PathVariable long idCanton) {
		Long idCanton1;
		List<CatalogoCanton> canton = catalogoCantonRepository.findByIdCanton(idCanton);
		idCanton1 = canton.get(0).getIDCANTON();
		return catalogoParroquiaRepository.findByIdCanton(idCanton1);
	}
}
