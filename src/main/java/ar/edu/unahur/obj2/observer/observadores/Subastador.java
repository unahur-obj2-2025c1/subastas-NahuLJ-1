package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.observables.Observable;

public class Subastador implements Observer {
	private Oferta ultimaOferta;
	private String nombre;
	private Observable productoSubastado;
	
	public Subastador(String nombre) {
		this.nombre = nombre;
	}
	
	@Override
	public void serNotificado(Oferta oferta) {
		this.ultimaOferta = oferta;
	}

	@Override
	public void realizarOferta() {
		Oferta oferta = new Oferta(nombre, ultimaOferta.getValor() + 10);
		productoSubastado.agregarOferta(oferta);
	}

	@Override
	public String getNombre() {
		return nombre;
	}

	@Override
	public void reset() {
		this.ultimaOferta = new Oferta(nombre, 0);
	}

	@Override
	public void setObservado(Observable observable) {
		this.productoSubastado = observable;
	}

	@Override
	public Oferta getUltimaOferta() {
		return ultimaOferta;
	}


}
