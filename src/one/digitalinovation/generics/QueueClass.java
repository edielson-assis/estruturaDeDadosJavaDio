package one.digitalinovation.generics;

import java.util.*;

import one.digitalinovation.generics.model.Carro;

public class QueueClass {
    public static void main(String[] args) {

        Queue<Carro> queueCarros = new LinkedList<>();

        queueCarros.add(new Carro("Ford"));
        queueCarros.add(new Carro("Chevrolet"));
        queueCarros.add(new Carro("Fiat"));
        System.out.println(queueCarros.add(new Carro("Peugeot"))); 
        System.out.println(queueCarros);

        System.out.println(queueCarros.element());
        System.out.println(queueCarros);

        System.out.println(queueCarros.offer(new Carro("Renault"))); 
        System.out.println(queueCarros);

        System.out.println(queueCarros.peek());
        System.out.println(queueCarros);

        System.out.println(queueCarros.remove()); 
        System.out.println(queueCarros);

        System.out.println(queueCarros.poll()); 
        System.out.println(queueCarros);

        System.out.println(queueCarros.isEmpty());
    }
}