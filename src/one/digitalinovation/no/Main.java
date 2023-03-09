package one.digitalinovation.no;

public class Main {
	public static void main(String[] args) {

		TextoEmNo no1 = new TextoEmNo("Conteudo no1");
		TextoEmNo no2 = new TextoEmNo("Conteudo no2");
		TextoEmNo no3 = new TextoEmNo("Conteudo no3");
		TextoEmNo no4 = new TextoEmNo("Conteudo no4");
		
		no1.setProximoNo(no2);
		no2.setProximoNo(no3);
		no3.setProximoNo(no4);
		
		System.out.println(no1);
		System.out.println(no1.getProximoNo());
		System.out.println(no1.getProximoNo().getProximoNo());
		System.out.println(no1.getProximoNo().getProximoNo().getProximoNo());
		System.out.println(no1.getProximoNo().getProximoNo().getProximoNo().getProximoNo());
	}
}