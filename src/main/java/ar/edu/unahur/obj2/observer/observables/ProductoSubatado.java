package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class ProductoSubatado implements Observable {
	List<Oferta> ofertas = new ArrayList<>();
	List<Observer> participantes = new ArrayList<>();

	public void notificar(Oferta oferta) {
		participantes.stream().forEach(p -> p.serNotificado(oferta));
	}

	@Override
	public void agregarOferta(Oferta oferta) {
		if(!this.contieneParticipante(oferta.getNombre())){
			throw new OfertaSubastadorException("El subastador " + oferta.getNombre() + "no esta incluido en la subasta");
		}
		ofertas.add(oferta);
		this.notificar(oferta);
	}

	@Override
	public void agregarParticipante(Observer participante) {
		participantes.add(participante);
		
	}

	@Override
	public void quitarParticipante(Observer participante) {
		participantes.remove(participante);
	}
	
	public Boolean contieneParticipante(String nombre) {
		return participantes.stream().anyMatch(p -> p.getNombre() == nombre);
	}

	@Override
	public void reset() {
		this.ofertas = new ArrayList<>();
		this.participantes = new ArrayList<>();		
	}
	
	@Override
	public Integer cantOfertas() {
		return ofertas.size();
	}
}
