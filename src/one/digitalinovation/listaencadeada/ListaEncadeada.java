package one.digitalinovation.listaencadeada;

public class ListaEncadeada<T> {

	private No<T> referenciaEntrada;

	public ListaEncadeada() {
		this.referenciaEntrada = null;
	}

	public void add(T conteudo) {
		No<T> novoNo = new No<>(conteudo);
		if (this.isEmpty()) {
			referenciaEntrada = novoNo;
			return;
		}
		No<T> noAuxiliar = referenciaEntrada;
		for (int i = 0; i < this.size() - 1; i++) {
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		noAuxiliar.setProximoNo(novoNo);
	}

	public T remove(int index) {
		validaIndice(index);
		No<T> noPivo = getNo(index);
		if (index == 0) {
			referenciaEntrada = noPivo.getProximoNo();
			return noPivo.getConteudo();
		}
		No<T> noAnterior = getNo(index - 1);
		noAnterior.setProximoNo(noPivo.getProximoNo());
		return noPivo.getConteudo();
	}

	public T get(int index) {
		return getNo(index).getConteudo();
	}

	private No<T> getNo(int index) {
		validaIndice(index);
		No<T> noAuxiliar = referenciaEntrada;
		No<T> noRetorno = null;
		for (int i = 0; i <= index; i++) {
			noRetorno = noAuxiliar;
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		return noRetorno;
	}

	private void validaIndice(int index) {
		if (index >= this.size()) {
			int ultimoIndice = this.size() - 1;
			throw new IndexOutOfBoundsException("Não existe conteúdo no índice " + index
					+ " desta lista. Esta lista só vai até o índice " + ultimoIndice + '.');
		}
	}

	public int size() {
		int tamanhoLista = 0;
		No<T> referenciaAux = referenciaEntrada;
		while (true) {
			if (referenciaAux != null) {
				tamanhoLista++;
				if (referenciaAux.getProximoNo() != null) {
					referenciaAux = referenciaAux.getProximoNo();
				} 
				else {
					break;
				}
			} 
			else {
				break;
			}
		}
		return tamanhoLista;
	}

	public boolean isEmpty() {
		return referenciaEntrada == null;
	}

	public No<T> getReferenciaEntrada() {
		return referenciaEntrada;
	}

	public void setReferenciaEntrada(No<T> referenciaEntrada) {
		this.referenciaEntrada = referenciaEntrada;
	}

	@Override
	public String toString() {
		String strRetorno = "";
		No<T> noAuxiliar = referenciaEntrada;
		for (int i = 0; i < size(); i++) {
			strRetorno += "[No{conteudo=" + noAuxiliar.getConteudo() + "}]--->";
			noAuxiliar = noAuxiliar.getProximoNo();
		}
		strRetorno += "null";
		return strRetorno;
	}
}