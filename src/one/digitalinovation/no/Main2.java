package one.digitalinovation.no;

public class Main2 {
	public static void main(String[] args) {

		GenericsNo<String> no1 = new GenericsNo<>("Conteudo no1");
		GenericsNo<String> no2 = new GenericsNo<>("Conteudo no2");
		no1.setProximoNo(no2);
		GenericsNo<String> no3 = new GenericsNo<>("Conteudo no3");
		no2.setProximoNo(no3);
		GenericsNo<String> no4 = new GenericsNo<>("Conteudo no4");
		no3.setProximoNo(no4);

		System.out.println(no1.toStringEncadeado());
		System.out.println(no2.toStringEncadeado());
		System.out.println(no3.toStringEncadeado());
		System.out.println(no4.toStringEncadeado());
	}
}