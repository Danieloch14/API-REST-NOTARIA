package ec.gob.cj.pesnot.notaria;

//import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.Date;
import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.test.context.SpringBootTest;
import ec.gob.cj.pesnot.notaria.controlador.AccionPersonalController;
import ec.gob.cj.pesnot.notaria.controlador.CatalogoCantonController;
import ec.gob.cj.pesnot.notaria.controlador.CatalogoParroquiaController;
import ec.gob.cj.pesnot.notaria.controlador.CatalogoProvinciaController;
import ec.gob.cj.pesnot.notaria.controlador.DireccionController;
import ec.gob.cj.pesnot.notaria.controlador.NotariaController;
import ec.gob.cj.pesnot.notaria.controlador.NotarioController;
import ec.gob.cj.pesnot.notaria.controlador.PersonaController;
import ec.gob.cj.pesnot.notaria.controlador.TipoAccionPersonalController;
import ec.gob.cj.pesnot.notaria.modelo.AccionPersonal;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoCanton;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoParroquia;
import ec.gob.cj.pesnot.notaria.modelo.CatalogoProvincia;
import ec.gob.cj.pesnot.notaria.modelo.Direccion;
import ec.gob.cj.pesnot.notaria.modelo.Notaria;
import ec.gob.cj.pesnot.notaria.modelo.Notario;
import ec.gob.cj.pesnot.notaria.modelo.Persona;
import ec.gob.cj.pesnot.notaria.modelo.TipoAccionPersonal;
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
	
	@Autowired
	private NotariaRepository contN;
	
//	@Autowired
//	private TestEntityManager em;
	
//	@Autowired
//	Date fecha = new Date(0);
//	
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
	    
	    @Test
		@DisplayName("Debe pasar cuando se obtenga una lista de notarías por acrónimo de notaría pero que no sea nulo")
		void listarNotariaPorAcronimo() {
		List<Long> listarNotaria = cont.busquedaPorAcronimo((String)"DECIMA");
		assertNotNull(listarNotaria);
		//assertThat(listaParametroActual).size().isGreaterThan(0);
		}
	    
	   
		
//	    @Test
//		@DisplayName("Debe pasar cuando se cree una Notaría")
//		void crearNotarias() {
//	    	Date fecha = new Date(0);
//	    	Notaria tablaNotaria1 = new Notaria((long)1, (long)4, (long)1, "646684", "CUARTA", "4", "Provincial", false, "Juan Hermosa", "533312131", "0", "0", "asdfasd", fecha, "213412314", "Cuarta notaria provincial", "DANIEL", "cuarta@gmail.com", "0920342323", "0920342323", "0920342323", "sadfasd", "dasfasdf");
//	    	assertNotNull(cont.createTabla(tablaNotaria1));
//		}
//	    
	    @Test
		@DisplayName("Debe pasar cuando se cree una Notaría")
		void actualizaNotarias() {
	    	Date fecha = new Date(0);
	    	Notaria tablaNotaria1 = new Notaria((long)1, (long)4, (long)1, "646684", "CUARTA", "4", "Provincial", false, "Juan Hermosa", "533312131", "0", "0", "asdfasd", fecha, "213412314", "Cuarta notaria provincial", "DANIEL", "cuarta@gmail.com", "0920342323", "0920342323", "0920342323", "sadfasd", "dasfasdf");
	    	 List<Notaria> notarias = cont.allNotarias();
		     final Long idPrimeraNotaria = notarias.get(0).getIDNOTARIA();
	    	 assertNotNull(cont.updateNotaria(idPrimeraNotaria, tablaNotaria1));
		}
	    
//	    @Test
//		@DisplayName("Debe pasar cuando se elimine una Notaría")
//		void eliminaNotariasbyId() {
//	    	
//	    	
//	    	System.out.println("Running testDelete...");
//	    	Date fecha = new Date(0);
//	    	Notaria notaria = new Notaria((long)2, (long)1, (long)1, "646684", "CUARTA", "4", "Provincial", false, "Juan Hermosa", "533312131", "0", "0", "asdfasd", false, fecha, "213412314", "Cuarta notaria provincial", "DANIEL", "cuarta@gmail.com", "0920342323", "0920342323", "0920342323");
//	        cont.createTabla(notaria);
//	        List<Notaria> notarias = cont.allNotarias();
//	        final Long idPrimeraNotaria = notarias.get(0).getIDNOTARIA();
//	        cont.eliminarNotariaPorId(idPrimeraNotaria);
//	    	List<Notaria> notariaEliminada = contN.findByIdNotaria(idPrimeraNotaria);
////    	    assertNull(notariaEliminada);
//		}
//	    
	    @Test
		@DisplayName("Debe pasar cuando se obtenga una lista de notarías por id de notaría pero que no sea nulo")
		void listarNotariaPorId() {
	    	 List<Notaria> notarias = cont.allNotarias();
		     final Long idPrimeraNotaria = notarias.get(0).getIDNOTARIA();
		     List<Notaria> listarNotaria = cont.busquedaNotariaPorId((long) idPrimeraNotaria);
		     assertNotNull(listarNotaria);
		//assertThat(listaParametroActual).size().isGreaterThan(0);
		}
	    
	    @Test
		@DisplayName("Debe pasar cuando se cambie el estado de una Notaría")
		void actualizaEstadoNotarias() {
	    	Date fecha = new Date(0);
//	    	 Notaria tablaNotaria1 = new Notaria((long)1, (long)1, (long)1, (long)1, "646684", "CUARTA", "4", "Provincial", false, "Juan Hermosa", "533312131", "0", "0", "asdfasd", false, fecha, "213412314", "Cuarta notaria provincial", "DANIEL", "cuarta@gmail.com", "0920342323", "0920342323", "0920342323");
	    	 List<Notaria> notarias = cont.allNotarias();
		     final Long idPrimeraNotaria = notarias.get(0).getIDNOTARIA();
		     final boolean estadoPrimeraNotaria = notarias.get(0).isESTADONOTARIA();
	    	 assertNotNull(cont.updateEstadoNotaria(idPrimeraNotaria, false));
	    	 
//	    	 Notaria tablaNotaria2 = new Notaria((long)2, (long)1, (long)1, (long)1, "646684", "CUARTA", "4", "Provincial", true, "Juan Hermosa", "533312131", "0", "0", "asdfasd", false, fecha, "213412314", "Cuarta notaria provincial", "DANIEL", "cuarta@gmail.com", "0920342323", "0920342323", "0920342323");
	    	 List<Notaria> notaria = cont.allNotarias();
		     final Long idPrimeraNotaria2 = notaria.get(1).getIDNOTARIA();
		     final boolean estadoPrimeraNotaria2 = notaria.get(0).isESTADONOTARIA();
	    	 assertNotNull(cont.updateEstadoNotaria(idPrimeraNotaria2, true));
		}

	    
	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST DIRECIÓN
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
    	List<Notaria> notarias = cont.allNotarias();
        final Long idPrimeraNotaria = notarias.get(0).getIDNOTARIA();
        List<Direccion> listarDirecciones = contD.Direccion(idPrimeraNotaria);
        assertNotNull(listarDirecciones);
        //assertThat(listaParametroActual).size().isGreaterThan(0);
    }
    
    @Test
    @DisplayName("Debe pasar cuando se cree una Direccion y exista en la base de datos")
    void crearDirecciones() {
    	
    	Direccion tablaDireccion1 = new Direccion(5,1,"Juan","Valverde","Orquideas","nel", false);
    	assertNotNull(contD.createTabla(tablaDireccion1));
    }
    

    @Test
	@DisplayName("Debe pasar cuando se obtenga una lista de direcciones por id de Direccion pero que no sea nulo")
	void listarDireccionesPorId() {
    	 List<Direccion> direcciones = contD.allDirecciones();
	     final Long idPrimeraDireccion = direcciones.get(0).getIDDIRECCION();
	     List<Direccion> listarDireccion = contD.DireccionById((long) idPrimeraDireccion);
	     assertNotNull(listarDireccion);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST TIPOACCIONPERSONAL
	@Autowired
	private TipoAccionPersonalController contTA;
    
	@Test
    @DisplayName("Debe pasar cuando se obtenga una lista de tipo de accion de personal no sea nula")
    void listarTipoAccionPersonal() {
        List<TipoAccionPersonal> listarTipoAccionPersonal = contTA.allTiposAccionPersonal();
        assertNotNull(listarTipoAccionPersonal);
        //assertThat(listaParametroActual).size().isGreaterThan(0);
    }
    
    @Test
    @DisplayName("Debe pasar cuando se obtenga una lista de tipos de acción de personal por id de acción de personal pero que no sea nulo")
    void listarTipoAccionPersonalPorIdAccionPersonal() {
        List<TipoAccionPersonal> listarTipoAccionPersonal = contTA.tipoAccionPersonal((long)2);
        assertNotNull(listarTipoAccionPersonal);
        //assertThat(listaParametroActual).size().isGreaterThan(0);
    }
    
    @Test
	@DisplayName("Debe pasar cuando se obtenga una lista de ids de TipoAccionPersonal por nombre de TipoAccionPersonal pero que no sea nulo")
	void listarTipoAccionPersonalPorNombre() {
	List<Long> listarTipoAccionPersonal = contTA.busquedaPorNombre((String)"Suplente");
	assertNotNull(listarTipoAccionPersonal);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST PERSONA
	@Autowired
	private PersonaController contP;
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de personas que no sea nula")
	void listarPersona() {
	List<Persona> listarPersona = contP.allPersonas();
	assertNotNull(listarPersona);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de personas con por id de notario pero que no sea nulo")
	void listarPersonaPorIdNotario() {
	List<Persona> listarPersona = contP.persona((long)1);
	assertNotNull(listarPersona);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de personas con por cedula pero que no sea nulo")
	void listarPersonaPorCedula() {
	List<Persona> listarPersona = contP.personaByCedula((String)"1234123");
	assertNotNull(listarPersona);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
//	@Test
//	@DisplayName("Debe pasar cuando se obtenga una lista de Persona que son notarios titulares por cedula pero que no sea nulo")
//	void listarPersonaNotarioTitularPorCedula() {
//	List<Persona> listarPersona = contP.personaNotarioTitularByCedula((String)"847591");
//	assertNotNull(listarPersona);
//	//assertThat(listaParametroActual).size().isGreaterThan(0);
//	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST NOTARIO
	@Autowired
	private NotarioController contNO;
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de notarios que no sea nula")
	void listarNotario() {
	List<Notario> listarNotario = contNO.allNotario();
	assertNotNull(listarNotario);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de notarios por id de accion de personal pero que no sea nulo")
	void listarNotarioPorIdAccionPersonal() {
	List<Notario> listarNotario = contNO.notario((long)2);
	assertNotNull(listarNotario);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}

//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST CATALOGO PROVINCIA
	@Autowired
	private CatalogoProvinciaController contCP;
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de provincias que no sea nula")
	void listarProvincia() {
	List<CatalogoProvincia> listarProvincia = contCP.allProvincias();
	assertNotNull(listarProvincia);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de provincias por id de catálogo de cantones pero que no sea nulo")
	void listarProvinciasPorIdCantones() {
	List<CatalogoProvincia> listarProvincia = contCP.catalogoProvincianbyIdCanton((long)1);
	assertNotNull(listarProvincia);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de CatalogoProvincia por id de CatalogProvincia pero que no sea nulo")
	void listarCatalogoProvinciaPorId() {
    	 List<CatalogoProvincia> catalogoProvincia = contCP.allProvincias();
	     final Long idPrimeraProvincia = catalogoProvincia.get(0).getIDPROVINCIA();
	     List<CatalogoProvincia> listarProvincia = contCP.catalogoProvincianbyId((long) idPrimeraProvincia);
	     assertNotNull(listarProvincia);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}

	
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST CATALOGO CANTON
	@Autowired
	private CatalogoCantonController contCC;
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de cantones que no sea nula")
	void listarCanton() {
	List<CatalogoCanton> listarCanton = contCC.allCantones();
	assertNotNull(listarCanton);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de cantones por id de catálogo de parroquias pero que no sea nulo")
	void listarCantonesPorIdParroquias() {
	List<CatalogoCanton> listarCanton = contCC.catalogoCantonbyIdParroquia((long)1);
	assertNotNull(listarCanton);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}	
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de Canton por id de Provincia pero que no sea nulo")
	void listarCatalogoCantonPorIdProvincia() {
    	 List<CatalogoProvincia> catalogoProvincia = contCP.allProvincias();
	     final Long idPrimeraProvincia = catalogoProvincia.get(0).getIDPROVINCIA();
	     List<CatalogoCanton> listarCanton = contCC.catalogoCantonbyIdProvincia((long) idPrimeraProvincia);
	     assertNotNull(listarCanton);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de Canton por id de Canton pero que no sea nulo")
	void listarCatalogoCantonPorId() {
    	 List<CatalogoCanton> catalogoCanton = contCC.allCantones();
	     final Long idPrimerCanton = catalogoCanton.get(0).getIDCANTON();
	     List<CatalogoCanton> listarCanton = contCC.catalogoCantonbyId((long) idPrimerCanton);
	     assertNotNull(listarCanton);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	


//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST CATALOGO PARROQUIA
	@Autowired
	private CatalogoParroquiaController contCPA;
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de parroquias que no sea nula")
	void listarParroquia() {
	List<CatalogoParroquia> listarParroquia = contCPA.allParroquias();
	assertNotNull(listarParroquia);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de parroquias por id de Dirección pero que no sea nulo")
	void listarParroquiasPorIdDireccion() {
	List<CatalogoParroquia> listarParroquia = contCPA.catalogoParroquiasbyIdDireccion((long)1);
	assertNotNull(listarParroquia);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}	
    
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de parroquias por id de Canton	 pero que no sea nulo")
	void listarCatalogoParroquiaPorIdCanton() {
    	 List<CatalogoCanton> catalogoCanton = contCC.allCantones();
	     final Long idPrimerCanton = catalogoCanton.get(0).getIDCANTON();
	     List<CatalogoParroquia> listarParroquia = contCPA.catalogoParroquiasbyIdCanton((long) idPrimerCanton);
	     assertNotNull(listarParroquia);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
    
//////////////////////////////////////////////////////////////////////////////////////////////////////////////

//TEST CATALOGO ACCIONPERSONAL
	@Autowired
	private AccionPersonalController contAP;
	
	@Autowired
	private TipoAccionPersonalController contTAP;
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de AccionPersonal que no sea nula")
	void listarAccionPersonal() {
	List<AccionPersonal> listarAccionPersonal = contAP.allAccionPersonal();
	assertNotNull(listarAccionPersonal);
	}
	
	@Test
	@DisplayName("Debe pasar cuando se obtenga una lista de Accion Personal por id de Notaria pero que no sea nulo")
	void listarAccionPersonalPorIdNotaria() {
	List<Notaria> notarias = cont.allNotarias();
    final Long idPrimeraNotaria = notarias.get(0).getIDNOTARIA();
	List<AccionPersonal> listarAccionPersonal = contAP.accionPersonal(idPrimeraNotaria);
	assertNotNull(listarAccionPersonal);
	//assertThat(listaParametroActual).size().isGreaterThan(0);
	}
	
//	@Test
//	@DisplayName("Debe pasar cuando se obtenga una lista de AccionPersonal por id de TipoAcionPersonal pero que no sea nulo")
//	void listarAccionPersonalPorIdTipoAccionPersonal() {
//    	 List<TipoAccionPersonal> tipoAccionPersonal = contTAP.allTiposAccionPersonal();
//	     final Long idPrimerTipoAccionPersonal = tipoAccionPersonal.get(0).getIDTIPOACCIONPERSONAL();
//	     List<AccionPersonal> listarAccionPersonal = contAP.accionPersonalByIdTipoAccionPersonal();
//	     assertNotNull(listarAccionPersonal);
//	//assertThat(listaParametroActual).size().isGreaterThan(0);
//	}

    
	
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
		Notaria tablaNotaria1 = new Notaria(null, null, null, null, null, null, null, false, null, null, null, null, null, fecha, null, null, null, null, null, null, null, null, null);
		Direccion tablaDireccion = new Direccion();
		Direccion tablaDireccion1 = new Direccion(1,1,"Antonio","Elizalde","Dorado","Sin salida",true);
		Persona tablaPersona = new Persona();
		Persona tablaPersona1 = new Persona((long)1, "Efrain", "Checa", "21412", "123124", fecha, false, "efra@gmail.com", "13513", "1242351", false);
		Notario tablaNotario = new Notario();
		Notario tablaNotario1 = new Notario((long)1, (long)1, "134235", false);
		CatalogoProvincia tablaProvincia = new CatalogoProvincia();
		CatalogoProvincia tablaProvincia1 = new CatalogoProvincia(0, 0, null, false);
		CatalogoParroquia tablaParroquia = new CatalogoParroquia();
		CatalogoParroquia tablaParroquia1 = new CatalogoParroquia(0, 0, null, false);
		CatalogoCanton tablaCanton = new CatalogoCanton();
		CatalogoCanton tablaCanton1 = new CatalogoCanton(null, null, null, false);
		AccionPersonal tablaAccionPersonal = new AccionPersonal();
		AccionPersonal tablaAccionPersonal1 = new AccionPersonal((long)0,(long) 0, (long)0, (long)0,(long) 0, (long)0, fecha, fecha, fecha, null, false, null);
		TipoAccionPersonal tablaTipoAccionPersonal = new TipoAccionPersonal();
		TipoAccionPersonal tablaTipoAccionPersonal1 = new TipoAccionPersonal(null, null, false);
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
		tablaNotaria.getLOGONOTARIA();
		tablaNotaria.getNOMBRENOTARIA();
		tablaNotaria.getNUMERONOTARIA();
		tablaNotaria.getRESOLUCIONCREACIONNOTARIA();
		tablaNotaria.getRUCNOTARIA();
		tablaNotaria.getTELEFONOPRINCIPAL();
		tablaNotaria.getTELEFONOSECUNDARIO();
		tablaNotaria.getTIPONOTARIA();
		tablaNotaria.isESTADONOTARIA();
//		tablaNotaria.isESTADOOBLIGADOCONTABILIDADNOTARIA();
		 
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
		tablaNotaria.setLOGONOTARIA(null);
		tablaNotaria.setNOMBRENOTARIA(null);
		tablaNotaria.setNUMERONOTARIA(null);
		tablaNotaria.setRESOLUCIONCREACIONNOTARIA(null);
		tablaNotaria.setRUCNOTARIA(null);
		tablaNotaria.setTELEFONOPRINCIPAL(null);
		tablaNotaria.setTELEFONOSECUNDARIO(null);
		tablaNotaria.setTIPONOTARIA(null);
		tablaNotaria.setESTADONOTARIA(false);
//		tablaNotaria.setESTADOOBLIGADOCONTABILIDADNOTARIA(false);
		
		//Pruebas Direccion
		// GET 
		tablaDireccion.getCALLEPRINCIPALDIRECCION();
		tablaDireccion.getCALLESECUNDARIADIRECCION();
		tablaDireccion.getIDPARROQUIA();
		tablaDireccion.isESTADOACTIVO();
		tablaDireccion.getIDDIRECCION();
		tablaDireccion.getREFERENCIADIRECCION();
		tablaDireccion.getREFERENCIADIRECCION();
		tablaDireccion.getSECTORDIRECCION();
		
		// Set
		tablaDireccion.setCALLEPRINCIPALDIRECCION(null);;
		tablaDireccion.setCALLESECUNDARIADIRECCION(null);
		tablaDireccion.setIDPARROQUIA(null);
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
//		tablaPersona1.isTIENERUC();
		
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
//		tablaPersona1.setTIENERUC(false);
		
		//Pruebas Notario
		//GET
		tablaNotario1.getIDNOTARIO();
		tablaNotario1.getIDPERSONA();
		tablaNotario1.getNUMAUTORIZACIONNOTARIO();
//		tablaNotario1.getTIPONOTARIO();
		tablaNotario1.isESTADOACTIVO();
//		tablaNotario1.isESTADONOTARIO();
		
		//SET
		tablaNotario1.setIDNOTARIO(null);
		tablaNotario1.setIDPERSONA(null);
		tablaNotario1.setNUMAUTORIZACIONNOTARIO(null);
//		tablaNotario1.setTIPONOTARIO(null);
		tablaNotario1.setESTADOACTIVO(true);
//		tablaNotario1.setESTADONOTARIO(true);
		
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
		tablaCanton1.getIDPROVINCIA();
		tablaCanton1.getIDCANTON();
		tablaCanton1.getNOMBRECANTON();
		tablaCanton1.isESTADOCANTON();
		
		//SET
		tablaCanton1.setIDPROVINCIA(null);
		tablaCanton1.setIDCANTON(null);
		tablaCanton1.setNOMBRECANTON(null);
		tablaCanton1.setESTADOCANTON(true);
		
		
		//Pruebas AccionPersonal
		//GET
		tablaAccionPersonal1.getDOCUMENTOACCIONPERSONAL();
		tablaAccionPersonal1.getFECHAACCIONPERSONAL();
		tablaAccionPersonal1.getFECHAFINACCIONPERSONAL();
		tablaAccionPersonal1.getIDACCIONPERSONAL();
//		tablaAccionPersonal1.getIDAUDITORIAACCIONPERSONAL();
		tablaAccionPersonal1.getIDESTADOACCIONPERSONAL();
		tablaAccionPersonal1.getIDNOTARIO();
		tablaAccionPersonal1.getIDTIPOACCIONPERSONAL();
		tablaAccionPersonal1.getNUMEROACCIONPERSONAL();
		tablaAccionPersonal1.getOBSERVACIONACCIONPERSONAL();
		tablaAccionPersonal1.isESTADOACTIVO();
		tablaAccionPersonal1.getFECHAINICIOACCIONPERSONAL();
		tablaAccionPersonal1.getIDNOTARIA();
		
		//SET
		tablaAccionPersonal1.setDOCUMENTOACCIONPERSONAL(null);
		tablaAccionPersonal1.setFECHAACCIONPERSONAL(null);
		tablaAccionPersonal1.setFECHAFINACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDESTADOACCIONPERSONAL(null);
		tablaAccionPersonal1.setIDNOTARIO(null);
		tablaAccionPersonal1.setIDTIPOACCIONPERSONAL(null);
		tablaAccionPersonal1.setNUMEROACCIONPERSONAL(null);
		tablaAccionPersonal1.setOBSERVACIONACCIONPERSONAL(null);
		tablaAccionPersonal1.setESTADOACTIVO(true);
		tablaAccionPersonal1.setFECHAINICIOACCIONPERSONAL(fecha);
		tablaAccionPersonal1.setIDNOTARIA(null);
		
		
		//Pruebas TipoAccionPersonal
		//GET
		tablaTipoAccionPersonal1.getIDTIPOACCIONPERSONAL();
		tablaTipoAccionPersonal1.getNOMBRETIPOACCIONPERSONAL();
		tablaTipoAccionPersonal1.isESTADOACTIVO();
		
		//SET
		tablaTipoAccionPersonal1.setESTADOACTIVO(true);
		tablaTipoAccionPersonal1.setIDTIPOACCIONPERSONAL(null);
		tablaTipoAccionPersonal1.setNOMBRETIPOACCIONPERSONAL(null);
		
		
	
       
	}

}
