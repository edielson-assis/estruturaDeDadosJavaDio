package one.digitalinovation.generics;

import java.util.*;

import one.digitalinovation.generics.model.Carro;

public class EqualsHashCode {
	public static void main(String[] args) {
		
		List<Carro> listaCarros = new ArrayList<>();

        listaCarros.add(new Carro("Ford"));
        listaCarros.add(new Carro("Chevrolet"));
        listaCarros.add(new Carro("Volkswagen"));

        System.out.println(listaCarros.contains(new Carro("Ford")));
        System.out.println(new Carro("Ford").hashCode());
        System.out.println(new Carro("Ford").hashCode());
	}
}