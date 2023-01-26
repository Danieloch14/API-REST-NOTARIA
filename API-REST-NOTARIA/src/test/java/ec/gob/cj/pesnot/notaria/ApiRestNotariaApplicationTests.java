package ec.gob.cj.pesnot.notaria;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.assertj.core.error.ShouldContainOnlyDigits;
import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import org.yaml.snakeyaml.external.com.google.gdata.util.common.base.PercentEscaper;

import ec.gob.cj.pesnot.notaria.controlador.DireccionController;
import ec.gob.cj.pesnot.notaria.controlador.NotariaController;
import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoCanton;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoProvincia;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.modelo.Notario;
import ec.gob.cj.pesnot.notaria.modelo.Persona;
import ec.gob.cj.pesnot.notaria.repositorio.NotariaRepository;

@SpringBootTest
class ApiRestNotariaApplicationTests {

//Main Test
	@Mock
	private SpringApplicationBuilder springApplicationBuilder;
	
	@Test
	   public void main() {
		ApiRestNotariaApplication.main(new String[] {});
	   }
	
	@Test
	  public void testIt() {
		ApiRestNotariaApplication apiRetNotariasApplication = new ApiRestNotariaApplication();
	    when(springApplicationBuilder.sources(ApiRestNotariaApplication.class)).thenReturn(springApplicationBuilder);

	    SpringApplicationBuilder result = apiRetNotariasApplication.configure(springApplicationBuilder);

	    verify(springApplicationBuilder).sources(ApiRestNotariaApplication.class);
	    assertEquals(springApplicationBuilder,result);
	  }

////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	
	
	@AfterEach
    void tearDown() {
    }
	
//TEST NOTARIA
	@Autowired
    private final NotariaRepository repo = Mockito.mock(NotariaRepository.class);
	
	@Autowired
	private NotariaController cont;
	
	 @BeforeEach
	    public void setUp() {
	    	tablaController = new NotariaController(repository);
	    }

	    

	    @Test
	    @DisplayName("Debe pasar cuando se obtenga una lista de notarias que no sea nulo")
	    void listarNotarias() {
	        List<Notaria> listaNotariaActual= repo.findAll();
	        assertNotNull(listaNotariaActual);
	        //assertThat(listaParametroActual).size().isGreaterThan(0);
	    }
	    
	    @Test
	    @DisplayName("Debe pasar cuando se obtenga una lista de notarias que no sea nulo con query")
	    void listarNotariasQuery() {
	        List<Notaria> listaNotariaActual= cont.allNotarias();
	        assertNotNull(listaNotariaActual);
	        //assertThat(listaParametroActual).size().isGreaterThan(0);
	    }

//	    @Test
//	    @DisplayName("Debe pasar cuando se actualice una notaria")
//	    void actualizarNotarias() {
//	    	List<Notaria> notariaAnterior = repo.findByIdNotaria((long) 1);
//	    	SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
//	        Date date = new Date();  
////			notariaAnterior.get(0).setIDDIRECCION(notaria.getIDDIRECCION());
//			notariaAnterior.get(0).setTELEFONO1NOTARIA("65265265");
//			notariaAnterior.get(0).setEMAILNOTARIA("danielo4@otlook.com");
//			notariaAnterior.get(0).setFECHACREACIONNOTARIA(date);
//			notariaAnterior.get(0).setRESOLUCIONCREACION_NOTARIA("23412341234");
//			notariaAnterior.get(0).setESTADONOTARIA(true);
//			notariaAnterior.get(0).setIDACCIONPERSONAL((long) 12312443);
//			assertNotNull(cont.updateNotaria((long)1, notariaAnterior.get(0)));
//			
//	        //assertThat(listaParametroActual).size().isGreaterThan(0);
//	    }
	    
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////
	@Autowired
	private DireccionController contD;
	
    
    @Test
    @DisplayName("Debe pasar cuando se obtenga una lista de direcciones que no sea nula")
    void listarDirecciones() {
        List<Direccion> listarDirecciones = contD.allDirecciones();
        assertNotNull(listarDirecciones);
        //assertThat(listaParametroActual).size().isGreaterThan(0);
    }
    
    @Test
    @DisplayName("Debe pasar cuando se obtenga una lista de direcciones por id de notaria pero que no sea nulo")
    void listarDireccionesPorIdNotaria() {
        List<Direccion> listarDirecciones = contD.Direccion((long)1);
        assertNotNull(listarDirecciones);
        //assertThat(listaParametroActual).size().isGreaterThan(0);
    }
    
    @Test
    @DisplayName("Debe pasar cuando se cree una Direccion y exista en la base de datos")
    void crearDirecciones() {
    	
    	Direccion tablaDireccion1 = new Direccion(5,1,"Juan","Valverde","Orquideas","nel", false);
    	assertNotNull(contD.createTabla(tablaDireccion1));
    }
    
    
    
    
    

    
	
	//TESTGETTERS Y SETTERS
	
	/**
	 * Test method for}.
	 */
	
	NotariaController prueba;

	 @Mock
	    private NotariaRepository repository;
	 	
	 	
	 @Mock
	    private NotariaController tablaController;

	    
	
	@Test
	public void testAllTablas() {
		Date fecha = new Date(0);

		this.setUp();
		
		Notaria tablaNotaria = new Notaria();
		Notaria tablaNotaria1 = new Notaria(null, null, null, null, null, null, null, null, false, null, null, null, null, null, false, fecha, null, null, null, null, null, null, null);
		Direccion tablaDireccion = new Direccion();
		Direccion tablaDireccion1 = new Direccion(1,1,"Antonio","Elizalde","Dorado","Sin salida",true);
		Persona tablaPersona = new Persona();
		Persona tablaPersona1 = new Persona(1, "Efrain", "Checa", "21412", "123124", fecha, false, "efra@gmail.com", "13513", "1242351", false);
		Notario tablaNotario = new Notario();
		Notario tablaNotario1 = new Notario(1, 1, "134235", false, "13413", false);
		CatalogoProvincia tablaProvincia = new CatalogoProvincia();
		CatalogoProvincia tablaProvincia1 = new CatalogoProvincia(0, 0, null, false);
		CatalogoParroquia tablaParroquia = new CatalogoParroquia();
		CatalogoParroquia tablaParroquia1 = new CatalogoParroquia(0, 0, null, false);
		CatalogoCanton tablaCanton = new CatalogoCanton();
		CatalogoCanton tablaCanton1 = new CatalogoCanton(null, null, null, false);
		AccionPersonal tablaAccionPersonal = new AccionPersonal();
		AccionPersonal tablaAccionPersonal1 = new AccionPersonal(0, 0, 0, 0, 0, 0, fecha, fecha, fecha, null, false, null);
		
		//Pruebas Notaria
		// GET 
		tablaNotaria.getACRONIMONOTARIA();
		tablaNotaria.getCELULARNOTARIA();
		tablaNotaria.getCODIGO_ESTABLECIMIENTONOTARIA();
		tablaNotaria.getCOORDENADALATITUDNOTARIA();
		tablaNotaria.getCOORDENADALONGITUDNOTARIA();
		tablaNotaria.getCREADOPORNOTARIA();
		tablaNotaria.getDESCRIPCIONNOTARIA();
		tablaNotaria.getEMAILNOTARIA();
		tablaNotaria.getFECHACREACIONNOTARIA();
		tablaNotaria.getIDDIRECCION();
		tablaNotaria.getIDNOTARIA();
		tablaNotaria.getIDPROGRAMACIONPE();
		tablaNotaria.getLOGO_NOTARIA();
		tablaNotaria.getNOMBRENOTARIA();
		tablaNotaria.getNUMERONOTARIA();
		tablaNotaria.getRESOLUCIONCREACION_NOTARIA();
		tablaNotaria.getRUCNOTARIA();
		tablaNotaria.getTELEFONO1NOTARIA();
		tablaNotaria.getTELEFONO2NOTARIA();
		tablaNotaria.getTIPONOTARIA();
		tablaNotaria.getIDACCIONPERSONAL();
		tablaNotaria.isESTADONOTARIA();
		tablaNotaria.isESTADOOBLIGADOCONTABILIDAD_NOTARIA();
		 
		//SET
		
		tablaNotaria.setACRONIMONOTARIA(null);
		tablaNotaria.setCELULARNOTARIA(null);
		tablaNotaria.setCODIGO_ESTABLECIMIENTONOTARIA(null);
		tablaNotaria.setCOORDENADALATITUDNOTARIA(null);
		tablaNotaria.setCOORDENADALONGITUDNOTARIA(null);
		tablaNotaria.setCREADOPORNOTARIA(null);
		tablaNotaria.setDESCRIPCIONNOTARIA(null);
		tablaNotaria.setEMAILNOTARIA(null);
		tablaNotaria.setFECHACREACIONNOTARIA(null);
		tablaNotaria.setIDDIRECCION(null);
		tablaNotaria.setIDNOTARIA(null);
		tablaNotaria.setIDPROGRAMACIONPE(null);
		tablaNotaria.setLOGO_NOTARIA(null);
		tablaNotaria.setNOMBRENOTARIA(null);
		tablaNotaria.setNUMERONOTARIA(null);
		tablaNotaria.setRESOLUCIONCREACION_NOTARIA(null);
		tablaNotaria.setRUCNOTARIA(null);
		tablaNotaria.setTELEFONO1NOTARIA(null);
		tablaNotaria.setTELEFONO2NOTARIA(null);
		tablaNotaria.setTIPONOTARIA(null);
		tablaNotaria.setIDACCIONPERSONAL(null);
		tablaNotaria.setESTADONOTARIA(false);
		tablaNotaria.setESTADOOBLIGADOCONTABILIDAD_NOTARIA(false);
		
		//Pruebas Direccion
		// GET 
		tablaDireccion.getCALLEPRINCIPALDIRECCION();
		tablaDireccion.getCALLESECUNDARIADIRECCION();
		tablaDireccion.getCatalogoParroquia();
		tablaDireccion.isESTADOACTIVO();
		tablaDireccion.getIDDIRECCION();
		tablaDireccion.getREFERENCIADIRECCION();
		tablaDireccion.getREFERENCIADIRECCION();
		tablaDireccion.getSECTORDIRECCION();
		
		// Set
		tablaDireccion.setCALLEPRINCIPALDIRECCION(null);;
		tablaDireccion.setCALLESECUNDARIADIRECCION(null);
		tablaDireccion.setCatalogoParroquia(null);
		tablaDireccion.setESTADOACTIVO(true);
		tablaDireccion.setIDDIRECCION(null);
		tablaDireccion.setREFERENCIADIRECCION(null);
		tablaDireccion.setREFERENCIADIRECCION(null);
		tablaDireccion.setSECTORDIRECCION(null);
		
		//Pruebas persona
		//GET
		tablaPersona1.getAPELLIDOSPERSONA();
		tablaPersona1.getCEDULAPERSONA();
		tablaPersona1.getCELULARPERSONA();
		tablaPersona1.getEMAILPERSONA();
		tablaPersona1.getFECHANACIMIENTOPERSONA();
		tablaPersona1.getIDPERSONA();
		tablaPersona1.getIDPERSONA();
		tablaPersona1.getNOMBRESPERSONA();
		tablaPersona1.getRUCPERSONA();
		tablaPersona1.getTELEFONOPERSONA();
		tablaPersona1.isESTADOACTIVO();
		tablaPersona1.isTIENERUC();
		
		//SET
		tablaPersona1.setAPELLIDOSPERSONA(null);
		tablaPersona1.setCEDULAPERSONA(null);
		tablaPersona1.setCELULARPERSONA(null);
		tablaPersona1.setEMAILPERSONA(null);
		tablaPersona1.setFECHANACIMIENTOPERSONA(null);
		tablaPersona1.setIDPERSONA(null);
		tablaPersona1.setIDPERSONA(null);
		tablaPersona1.setNOMBRESPERSONA(null);
		tablaPersona1.setRUCPERSONA(null);
		tablaPersona1.setTELEFONOPERSONA(null);
		tablaPersona1.setESTADOACTIVO(false);
		tablaPersona1.setTIENERUC(false);
		
		//Pruebas Notario
		//GET
		tablaNotario1.getIDNOTARIO();
		tablaNotario1.getIDPERSONA();
		tablaNotario1.getNUMAUTORIZACIONNOTARIO();
		tablaNotario1.getTIPONOTARIO();
		tablaNotario1.isESTADOACTIVO();
		tablaNotario1.isESTADONOTARIO();
		
		//SET
		tablaNotario1.setIDNOTARIO(null);
		tablaNotario1.setIDPERSONA(null);
		tablaNotario1.setNUMAUTORIZACIONNOTARIO(null);
		tablaNotario1.setTIPONOTARIO(null);
		tablaNotario1.setESTADOACTIVO(true);
		tablaNotario1.setESTADONOTARIO(true);
		
		//Pruebas CatalogoProvincia
		//GET
		tablaProvincia1.getCatologoPais();
		tablaProvincia1.getIDPROVINCIA();
		tablaProvincia1.getNOMBREPROVINCIA();
		tablaProvincia1.isESTADOPROVINCIA();
		
		//SET
		tablaProvincia1.setCatologoPais(null);
		tablaProvincia1.setIDPROVINCIA(null);
		tablaProvincia1.setNOMBREPROVINCIA(null);
		tablaProvincia1.setESTADOPROVINCIA(true);
		
		//Pruebas CatalgoParroquias
		//GET
		tablaParroquia1.getIDCANTON();
		tablaParroquia1.getIDPARROQUIA();
		tablaParroquia1.getNOMBREPARROQUIA();
		tablaParroquia1.isESTADOPARROQUIA();
		
		//SET
		tablaParroquia1.setIDCANTON(null);
		tablaParroquia1.setIDPARROQUIA(null);
		tablaParroquia1.setNOMBREPARROQUIA(null);
		tablaParroquia1.setESTADOPARROQUIA(true);
		
		//Pruebas CatalogoCanton
		//GET
		tablaCanton1.getCatalogoProvincia();
		tablaCanton1.getIDCANTON();
		tablaCanton1.getNOMBRECANTON();
		tablaCanton1.isESTADOCANTON();
		
		//SET
		tablaCanton1.setCatalogoProvincia(null);
		tablaCanton1.setIDCANTON(null);
		tablaCanton1.setNOMBRECANTON(null);
		tablaCanton1.setESTADOCANTON(true);
		
		
		//Pruebas AccionPersonal
		//GET
		tablaAccionPersonal1.getDOCUMENTOACCIONPERSONAL();
		tablaAccionPersonal1.getFECHAACCIONPERSONAL();
		tablaAccionPersonal1.getFECHAFINACCIONPERSONAL();
		tablaAccionPersonal1.getIDACCIONPERSONAL();
		tablaAccionPersonal1.getIDAUDITORIAACCIONPERSONAL();
		tablaAccionPersonal1.getIDESTADOACCIONPERSONAL();
		tablaAccionPersonal1.getIDNOTARIO();
		tablaAccionPersonal1.getIDTIPOACCIONPERSONAL();
		tablaAccionPersonal1.getNUMEROACCIONPERSONAL();
		tablaAccionPersonal1.getOBSERVACIONACCIONPERSONAL();
		tablaAccionPersonal1.isESTADOACTIVO();
		tablaAccionPersonal1.getFECHAINICIOACCIONPERSONAL();
		
		//SET
		tablaAccionPersonal1.setDOCUMENTOACCIONPERSONAL(null);
		tablaAccionPersonal1.setFECHAACCIONPERSONAL(null);
		tablaAccionPersonal1.setFECHAFINACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDAUDITORIAACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDESTADOACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDNOTARIO(null);
		tablaAccionPersonal1.setIDTIPOACCIONPERSONAL(null);
		tablaAccionPersonal1.setNUMEROACCIONPERSONAL(null);
		tablaAccionPersonal1.setOBSERVACIONACCIONPERSONAL(null);
		tablaAccionPersonal1.setESTADOACTIVO(true);
		tablaAccionPersonal1.setFECHAINICIOACCIONPERSONAL(fecha);

		
		
	
       
	}

}
