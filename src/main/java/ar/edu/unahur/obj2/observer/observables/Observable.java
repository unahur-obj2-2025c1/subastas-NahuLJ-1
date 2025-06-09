package ar.edu.unahur.obj2.observer.observables;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public interface Observable {
	
	void notificar();
	
	void agregarOferta(Oferta oferta);
	
	void agregarParticipante(Observer participante);
	
	void quitarParticipante(Observer participante);
	
	void reset();

	Integer cantOfertas();
}
