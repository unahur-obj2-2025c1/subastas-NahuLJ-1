package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public interface EstrategiaStrategy {
	
	Oferta crearOfertaPara(Observer observador);
}
