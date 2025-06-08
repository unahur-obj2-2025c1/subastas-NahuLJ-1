package ar.edu.unahur.obj2.observer;

public class Oferta {
	private final String nombre;
	private final Integer valor;
	
	public Oferta(String nombre, Integer valor) {
		this.nombre = nombre;
		this.valor = valor;
	}

	public String getNombre() {
		return nombre;
	}

	public Integer getValor() {
		return valor;
	}

}
