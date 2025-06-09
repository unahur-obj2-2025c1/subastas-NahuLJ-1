package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class Arriesgado implements EstrategiaStrategy {

	@Override
	public Oferta crearOfertaPara(Observer observador) {
		Oferta oferta = new Oferta(observador.getNombre(), observador.getUltimaOferta().getValor() + 10);
		return oferta;
	}

}
