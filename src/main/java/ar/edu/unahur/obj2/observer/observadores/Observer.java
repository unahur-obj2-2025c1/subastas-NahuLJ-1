package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public interface Observer {

	void serNotificado(Oferta oferta);
	
	void realizarOferta();
	
	String getNombre();
	
	void reset();
	
	void setObservado(Observable observable);
	
	Oferta getUltimaOferta();
}
