package one.digitalinovation.generics.model;

import java.util.Objects;

public class Carro implements Comparable<Carro> {

	private String marca;

	public Carro(String marca) {
		this.marca = marca;
	}

	public String getMarca() {
		return marca;
	}

	public void setMarca(String marca) {
		this.marca = marca;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (!(o instanceof Carro))
			return false;
		Carro carro = (Carro) o;
		return Objects.equals(getMarca(), carro.getMarca());
	}

	@Override
	public int hashCode() {
		return Objects.hash(getMarca());
	}

	@Override
	public String toString() {
		return "{marca: " + marca + "}";
	}

	@Override
	public int compareTo(Carro o) {
		return this.getMarca().compareTo(o.getMarca());
	}
}