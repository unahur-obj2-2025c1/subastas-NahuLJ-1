package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class ConLimite implements EstrategiaStrategy{
	private Integer umbral;
	
	public ConLimite(Integer umbral){
		this.umbral = umbral;
	}
	@Override
	public Oferta crearOfertaPara(Observer observador) {
		if(umbral >= observador.getUltimaOferta().getValor()) {
			return new Oferta(observador.getNombre(),observador.getUltimaOferta().getValor() + 10);
		}
		
		return observador.getUltimaOferta();
	}

}
