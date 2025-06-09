package ar.edu.unahur.obj2.observer.observables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import ar.edu.unahur.obj2.observer.Oferta;
import ar.edu.unahur.obj2.observer.excepciones.OfertaSubastadorException;
import ar.edu.unahur.obj2.observer.observadores.Observer;

public class ProductoSubatado implements Observable {
	List<Oferta> ofertas = new ArrayList<>();
	Set<Observer> participantes = new HashSet<>();

	public void notificar() {
		participantes.stream().forEach(p -> p.serNotificado(ofertas.get(ofertas.size() - 1)));
	}

	@Override
	public void agregarOferta(Oferta oferta) {
		if(!this.contieneParticipante(oferta.getNombre())){
			throw new OfertaSubastadorException("El subastador " + oferta.getNombre() + "no esta incluido en la subasta");
		}
		
		if(!ofertas.contains(oferta)) {
			ofertas.add(oferta);
			this.notificar();
		}
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
		this.ofertas.clear();
		this.participantes.clear();	
	}
	
	@Override
	public Integer cantOfertas() {
		return ofertas.size();
	}
}
