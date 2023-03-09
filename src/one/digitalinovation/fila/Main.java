package one.digitalinovation.fila;

public class Main {
	public static void main(String[] args) {
		
		Fila<String> minhaFila = new Fila<>();

		minhaFila.enqueue("João");
		minhaFila.enqueue("Jose");
		minhaFila.enqueue("Luis");
		minhaFila.enqueue("Leco");
		System.out.println(minhaFila);

		System.out.println(minhaFila.dequeue());
		System.out.println(minhaFila);

		System.out.println(minhaFila.dequeue());
		System.out.println(minhaFila);
		
		minhaFila.enqueue("Maria");

		System.out.println(minhaFila);
		System.out.println(minhaFila.first());
	}
}