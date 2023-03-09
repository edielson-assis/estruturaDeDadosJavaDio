package one.digitalinovation.no;

public class TextoEmNo {

	private String conteudo;
	private TextoEmNo proximoNo;
	
	public TextoEmNo(String conteudo) {
		this.proximoNo = null;
		this.conteudo = conteudo;
	}

	public String getConteudo() {
		return conteudo;
	}

	public void setConteudo(String conteudo) {
		this.conteudo = conteudo;
	}

	public TextoEmNo getProximoNo() {
		return proximoNo;
	}

	public void setProximoNo(TextoEmNo proximoNo) {
		this.proximoNo = proximoNo;
	}

	@Override
	public String toString() {
		return "TextoEmNo [conteudo=" + conteudo + "]";
	}
}