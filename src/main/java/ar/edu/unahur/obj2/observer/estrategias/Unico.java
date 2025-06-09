package ar.edu.unahur.obj2.observer.estrategias;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class Unico implements EstrategiaStrategy{
	private Boolean puedeOfertar = Boolean.TRUE;

	@Override
	public Oferta crearOfertaPara(Observer observador) {
		if (puedeOfertar) {
			this.puedeOfertar = Boolean.FALSE;
			return new Oferta(observador.getNombre(),observador.getUltimaOferta().getValor() + 10);
		}
		
		return observador.getUltimaOferta();
	}
	
	
}
