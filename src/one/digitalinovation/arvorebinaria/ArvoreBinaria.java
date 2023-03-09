package one.digitalinovation.arvorebinaria;

import java.io.PrintStream;

public class ArvoreBinaria<T extends Comparable<T>> {

	private BinNo<T> raiz;

	public ArvoreBinaria() {
		this.raiz = null;
	}

	public void inserir(T conteudo) {
		BinNo<T> novoNo = new BinNo<>(conteudo);
		raiz = inserirNo(raiz, novoNo);
	}

	private BinNo<T> inserirNo(BinNo<T> atual, BinNo<T> novoNo) {
		if (atual == null) {
			return novoNo;
		} 
		else if (novoNo.getConteudo().compareTo(atual.getConteudo()) < 0) {
			atual.setNoEsq(inserirNo(atual.getNoEsq(), novoNo));
		} 
		else {
			atual.setNoDir(inserirNo(atual.getNoDir(), novoNo));
		}
		return atual;
	}

	public void exibirInOrdem() {
		System.out.println("\nExibindo InOrdem");
		exibirInOrdem(this.raiz);
	}

	private void exibirInOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirInOrdem(atual.getNoEsq());
			System.out.print(atual.getConteudo() + ", ");
			exibirInOrdem(atual.getNoDir());
		}
	}

	public void exibirPosOrdem() {
		System.out.println("\nExibindo PosOrdem");
		exibirPosOrdem(this.raiz);
	}

	private void exibirPosOrdem(BinNo<T> atual) {
		if (atual != null) {
			exibirPosOrdem(atual.getNoEsq());
			exibirPosOrdem(atual.getNoDir());
			System.out.print(atual.getConteudo() + ", ");
		}
	}

	public void exibirPreOrdem() {
		System.out.println("\nExibindo PreOrdem");
		exibirPreOrdem(this.raiz);
	}

	private void exibirPreOrdem(BinNo<T> atual) {
		if (atual != null) {
			System.out.print(atual.getConteudo() + ", ");
			exibirPreOrdem(atual.getNoEsq());
			exibirPreOrdem(atual.getNoDir());
		}
	}

	public void remover(T conteudo) {
		raiz = removerNo(raiz, conteudo);
	}

	private T minimumElement(BinNo<T> atual) {
		while (atual.getNoDir() != null) {
			atual = atual.getNoDir();
		}
		return atual.getConteudo();
	}

	private BinNo<T> removerNo(BinNo<T> atual, T conteudo) {
		if (atual == null) {
			return null;
		}
		else if (conteudo.compareTo(atual.getConteudo()) < 0) {
			atual.setNoEsq(removerNo(atual.getNoEsq(), conteudo));
		}
		else if (conteudo.compareTo(atual.getConteudo()) > 0) {
			atual.setNoDir(removerNo(atual.getNoDir(), conteudo));
		}
		else {
			if (atual.getNoEsq() == null && atual.getNoDir() == null) {
				return null;
			}
			else if (atual.getNoDir() == null) {
				return atual.getNoEsq();
			}
			else if (atual.getNoEsq() == null) {
				return atual.getNoDir();
			}
			else {
				atual.setConteudo(minimumElement(atual.getNoEsq()));
				atual.setNoEsq(removerNo(atual.getNoEsq(), atual.getConteudo()));
			}
		}
		return atual;
	}

	private String traversePreOrder(BinNo<T> root) {

		if (root == null) {
			return "";
		}

		StringBuilder sb = new StringBuilder();
		sb.append(root.getConteudo());

		String pointerRight = "└──";
		String pointerLeft = (root.getNoDir() != null) ? "├──" : "└──";

		traverseNodes(sb, "", pointerLeft, root.getNoEsq(), root.getNoDir() != null);
		traverseNodes(sb, "", pointerRight, root.getNoDir(), false);

		return sb.toString();
	}

	private void traverseNodes(StringBuilder sb, String padding, String pointer, BinNo<T> node,
			boolean hasRightSibling) {

		if (node != null) {

			sb.append("\n");
			sb.append(padding);
			sb.append(pointer);
			sb.append(node.getConteudo());

			StringBuilder paddingBuilder = new StringBuilder(padding);

			if (hasRightSibling) {
				paddingBuilder.append("│  ");
			} 
			else {
				paddingBuilder.append("   ");
			}

			String paddingForBoth = paddingBuilder.toString();
			String pointerRight = "└──";
			String pointerLeft = (node.getNoDir() != null) ? "├──" : "└──";

			traverseNodes(sb, paddingForBoth, pointerLeft, node.getNoEsq(), node.getNoDir() != null);
			traverseNodes(sb, paddingForBoth, pointerRight, node.getNoDir(), false);
		}
	}

	public void print(PrintStream os) {
		os.print(traversePreOrder(raiz));
	}
}