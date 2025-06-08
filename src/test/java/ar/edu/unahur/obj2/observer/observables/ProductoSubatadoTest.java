package ar.edu.unahur.obj2.observer.observables;

import org.junit.jupiter.api.Test; 
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach; 

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.*;

class ProductoSubatadoTest {
	Observable producto = new ProductoSubatado();
	Observer gonzager = new Subastador("gonzager");
	Observer diazdan = new Subastador("diazdan");
	Observer martomau = new Subastador("martomau");
	
	@BeforeEach
	public void initEachTest(){
	  producto.reset();
	  gonzager.reset();
	  diazdan.reset();
	  martomau.reset();
	  producto.agregarParticipante(gonzager);
	  producto.agregarParticipante(martomau);
	  
	  gonzager.setObservado(producto);
	  martomau.setObservado(producto);
	  
	  martomau.realizarOferta();
	  gonzager.realizarOferta();
	  martomau.realizarOferta();
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
		diazdan.setObservado(producto);
		
		assertThrows(OfertaSubastadorException.class, () -> {diazdan.realizarOferta();});
	}
}
