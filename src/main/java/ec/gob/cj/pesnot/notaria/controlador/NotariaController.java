package ec.gob.cj.pesnot.notaria.controlador;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Base64;
import java.util.List;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.gob.cj.pesnot.notaria.config.EncryptionUtils;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;
import springfox.documentation.spring.web.json.Json;


@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/notarias")
public class NotariaController {
	
	public boolean estado = true;

	@Autowired
	private NotariaRepository notariaRepository;
	
	
	public NotariaController(NotariaRepository noR) {
		this.notariaRepository = noR;
	}
	
	//Obtiene una lista de Notarias
	@GetMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notaria> allNotarias() {
		return notariaRepository.findAll();
	}
	
	//Obtiene ID's de Notarias por Acrónimo
	@GetMapping(value = "/{acronimo}/acronimo", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Long> busquedaPorAcronimo(@PathVariable String acronimo) {
		return notariaRepository.busquedaPorAcronimo(acronimo);
	}
	
	@GetMapping(value = "/{idNotaria}", produces = MediaType.APPLICATION_JSON_VALUE)
	public List<Notaria> busquedaNotariaPorId(@PathVariable long idNotaria){
		return notariaRepository.findByIdNotaria(idNotaria);
	}
	
	//Crea una Notaria
	@PostMapping(produces = MediaType.APPLICATION_JSON_VALUE)
	public Notaria createTabla(@RequestBody Notaria notaria){
//		
		
//		SecureRandom secureRandom = new SecureRandom();
//        
//        //make sure to save this into a database
//        byte[] salt = secureRandom.generateSeed(12);
//        String base64HashSalt = Base64.getMimeEncoder().encodeToString(salt);
//        notaria.setSALTNOTARIA(base64HashSalt);
//
//        //Hashea la clave
//        PBEKeySpec pbeKeySpec = new PBEKeySpec(notaria.getCLAVEFIRMAELECTRONICANOTARIA().toCharArray(), salt, 10, 512);
//        SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
//        byte[] hash = skf.generateSecret(pbeKeySpec).getEncoded();
//
//        //Convierte a string el hash para guardarlo en la base de datos
//        String base64Hash = Base64.getMimeEncoder().encodeToString(hash);
//        notaria.setCLAVEFIRMAELECTRONICANOTARIA(base64Hash);
		List<Notaria> notariaAnterior = notariaRepository.findByIdNotaria(notaria.getIDNOTARIA());
		
		
		String claveFirma = notariaAnterior.get(0).getCLAVEFIRMAELECTRONICANOTARIA();
		System.out.println(claveFirma);
		String claveEncriptada;
		try {
			claveEncriptada = EncryptionUtils.encrypt("PESNOT2022214365", claveFirma);
			System.out.println(claveEncriptada);
			notariaAnterior.get(0).setCLAVEFIRMAELECTRONICANOTARIA(claveEncriptada);
			
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return notariaRepository.save(notariaAnterior.get(0));
		
		
	}
	
//	@GetMapping("/{idNotaria}/firmaElectronica")
//	public List<String> firmaElectrónica(@PathVariable long idNotaria){
//		
//		return notariaRepository.firmaElectronica(idNotaria);
//	}
//	
//	
	//Actualiza una Notaria por ID
	@PutMapping(value = "/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    public Notaria updateNotaria(@PathVariable long id,@RequestBody Notaria notaria) {
		List<Notaria> notariaAnterior = notariaRepository.findByIdNotaria(id);
//		notariaAnterior.get(0).setIDDIRECCION(notaria.getIDDIRECCION());
		notariaAnterior.get(0).setTELEFONOPRINCIPAL(notaria.getTELEFONOPRINCIPAL());
		notariaAnterior.get(0).setEMAILNOTARIA(notaria.getEMAILNOTARIA());
		notariaAnterior.get(0).setFECHACREACIONNOTARIA(notaria.getFECHACREACIONNOTARIA());
		notariaAnterior.get(0).setRESOLUCIONCREACIONNOTARIA(notaria.getRESOLUCIONCREACIONNOTARIA());
		notariaAnterior.get(0).setESTADONOTARIA(notaria.isESTADONOTARIA());
		return notariaRepository.save(notariaAnterior.get(0));        
    }
	
	
	//Borra una Notaria por ID
//	@DeleteMapping("/eliminar/{idNotaria}")
//    public void eliminarNotariaPorId(@PathVariable long idNotaria){
//		 notariaRepository.deleteById(idNotaria);         
//	}
	
	//Cambia el estado de una Notaria por ID 	
	@PutMapping(value = "/", params = { "idNotaria", "estadoNotaria"}, produces = MediaType.APPLICATION_JSON_VALUE)
	public Notaria updateEstadoNotaria(@RequestParam Long idNotaria, @RequestParam boolean estadoNotaria) {
		List<Notaria> notariaAnterior = notariaRepository.findByIdNotaria(idNotaria);
		notariaAnterior.get(0).setESTADONOTARIA(!estadoNotaria);
		return notariaRepository.save(notariaAnterior.get(0));
	}
		
}
