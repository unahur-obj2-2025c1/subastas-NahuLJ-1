package ar.edu.unahur.obj2.observer.observadores;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.estrategias.EstrategiaStrategy;
//intento commit
public class Subastador implements Observer {
	private Oferta ultimaOferta;
	private final String nombre;
	private EstrategiaStrategy estrategia;
	
	public Subastador(String nombre, EstrategiaStrategy estrategia) {
		this.nombre = nombre;
		this.estrategia = estrategia;
		this.reset();
	}
	
	@Override
	public void serNotificado(Oferta oferta) {
		this.ultimaOferta = oferta;
	}

	@Override
	public Oferta realizarOferta() {
		return estrategia.crearOfertaPara(this);
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
	public Oferta getUltimaOferta() {
		return ultimaOferta;
	}

	@Override
	public void setEstrategia(EstrategiaStrategy estrategia) {
		this.estrategia = estrategia;
	}


}
