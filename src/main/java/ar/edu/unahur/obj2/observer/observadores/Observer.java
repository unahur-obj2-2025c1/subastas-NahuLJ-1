package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.estrategias.EstrategiaStrategy;

public interface Observer {

	void serNotificado(Oferta oferta);
	
	Oferta realizarOferta();
	
	String getNombre();
	
	void reset();
	
	Oferta getUltimaOferta();
	
	void setEstrategia(EstrategiaStrategy estrategia);
}
