package one.digitalinovation.no;

public class GenericsNo<T> {

	private T conteudo;
	private GenericsNo<T> proximoNo;
	
	public GenericsNo(T conteudo) {
		this.proximoNo = null;
		this.conteudo = conteudo;
	}

	public T getConteudo() {
		return conteudo;
	}

	public void setConteudo(T conteudo) {
		this.conteudo = conteudo;
	}

	public GenericsNo<T> getProximoNo() {
		return proximoNo;
	}

	public void setProximoNo(GenericsNo<T> proximoNo) {
		this.proximoNo = proximoNo;
	}

	@Override
	public String toString() {
		return "GenericsNo [conteudo=" + conteudo + "]";
	}
	
    public String toStringEncadeado() {
        String str = "GenericsNo{" + conteudo + "}";

        if (proximoNo != null){
            str += " -> " + proximoNo.toString();
        }
		else{
            str += " -> null";
        }
        return str;
    }	
}