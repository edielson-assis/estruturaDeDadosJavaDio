package one.digitalinovation.fila;

public class Fila<T> {

	private No<T> refNoEntradaFila;

	public Fila() {
		this.refNoEntradaFila = null;
	}

	public void enqueue(T object) {
		No<T> novoNo = new No<>(object);
		novoNo.setRefNo(refNoEntradaFila);
		refNoEntradaFila = novoNo;
	}

	@SuppressWarnings("unchecked")
	public T first() {
		if (!this.isEmpty()) {
			No<T> primeiroNo = refNoEntradaFila;
			while (true) {
				if (primeiroNo.getRefNo() != null) {
					primeiroNo = primeiroNo.getRefNo();
				} 
				else {
					break;
				}
			}
			return (T) primeiroNo.getObject();
		}
		return null;
	}

	@SuppressWarnings("unchecked")
	public T dequeue() {
		if (!this.isEmpty()) {
			No<T> primeiroNo = refNoEntradaFila;
			No<T> noAux = refNoEntradaFila;
			while (true) {
				if (primeiroNo.getRefNo() != null) {
					noAux = primeiroNo;
					primeiroNo = primeiroNo.getRefNo();
				} 
				else {
					noAux.setRefNo(null);
					break;
				}
			}
			return (T) primeiroNo.getObject();
		}
		return null;
	}

	public boolean isEmpty() {
		return refNoEntradaFila == null;
	}

	@Override
	public String toString() {
		String stringRetorno = "";
		No<T> noAuxiliar = refNoEntradaFila;

		if (refNoEntradaFila != null) {
			while (true) {
				stringRetorno += "[No{objeto=" + noAuxiliar.getObject() + "}]--->";
				if (noAuxiliar.getRefNo() != null) {
					noAuxiliar = noAuxiliar.getRefNo();
				} 
				else {
					stringRetorno += "null";
					break;
				}
			}
		} 
		else {
			stringRetorno = "null";
		}
		return stringRetorno;
	}
}