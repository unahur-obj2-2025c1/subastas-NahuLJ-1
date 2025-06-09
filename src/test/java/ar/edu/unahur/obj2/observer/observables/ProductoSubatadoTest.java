package ar.edu.unahur.obj2.observer.observables;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 

import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.*;
import ar.edu.unahur.obj2.observer.estrategias.*;

class ProductoSubatadoTest {
	Observable producto = new ProductoSubatado();
	EstrategiaStrategy arriesgado = new Arriesgado();
	EstrategiaStrategy conLimite = new ConLimite(30);
	EstrategiaStrategy unico= new Unico();
	Observer gonzager = new Subastador("gonzager",arriesgado);
	Observer diazdan = new Subastador("diazdan", arriesgado);
	Observer martomau = new Subastador("martomau", arriesgado);
	
	@BeforeEach
	void initEachTest(){
	  producto.reset();
	  gonzager.reset();
	  diazdan.reset();
	  martomau.reset();
	  producto.agregarParticipante(gonzager);
	  producto.agregarParticipante(martomau);
	  
	  producto.agregarOferta(martomau.realizarOferta());
	  producto.agregarOferta(gonzager.realizarOferta());
	  producto.agregarOferta(martomau.realizarOferta());
	}
	
	@Test
	void seVerificaQueLosSubastadoresRecibenCorrectamenteLaUltimaOfertaRealizada() {
		assertEquals(martomau.getUltimaOferta(),gonzager.getUltimaOferta());
	}
	
	@Test
	void seVerificaQueLaUltimaOfertaFueRealizadaPorMartomau() {
		assertEquals("martomau",gonzager.getUltimaOferta().getNombre());
		assertEquals("martomau",martomau.getUltimaOferta().getNombre());
	}
	
	@Test
	void seVerificaQueLaUltimaOfertaFue30() {
		assertEquals(30,gonzager.getUltimaOferta().getValor());
		assertEquals(30,martomau.getUltimaOferta().getValor());
	}
	
	@Test
	void seVerificaQueLaCantidadDeOfertasEs3() {
		assertEquals(3,producto.cantOfertas());
	}
	
	@Test
	void siDiazdanRealizaUnaOfertaSeLanzaUnaExcepcion() {		
		assertThrows(OfertaSubastadorException.class, () -> {producto.agregarOferta(diazdan.realizarOferta());});
	}
	
	@Test
	void siGonzagerCambiaSuEstrategiaAUnicoSoloPuedeOfertar1vez() {
		gonzager.setEstrategia(unico);
		producto.agregarOferta(gonzager.realizarOferta());
		producto.agregarOferta(gonzager.realizarOferta());
		producto.agregarOferta(gonzager.realizarOferta());
		producto.agregarOferta(gonzager.realizarOferta());
		producto.agregarOferta(gonzager.realizarOferta());
		
		assertEquals(4,producto.cantOfertas());
		assertEquals(40,gonzager.getUltimaOferta().getValor());
		assertEquals(40,martomau.getUltimaOferta().getValor());
	}
	
	@Test
	void siMartomauCambiaSuEstrategiaAConLimiteCon30DeUmbralPuedeOfertarSolo1Vez() {
		martomau.setEstrategia(conLimite);
		producto.agregarOferta(martomau.realizarOferta());
		producto.agregarOferta(martomau.realizarOferta());
		producto.agregarOferta(martomau.realizarOferta());
		producto.agregarOferta(martomau.realizarOferta());
		producto.agregarOferta(martomau.realizarOferta());
		
		assertEquals(4,producto.cantOfertas());
		assertEquals(40,gonzager.getUltimaOferta().getValor());
		assertEquals(40,martomau.getUltimaOferta().getValor());
	}
}
