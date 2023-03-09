package one.digitalinovation.arvorebinaria.model;

public abstract class ObjArvore <T> implements Comparable<T>  {

    public abstract boolean equals(Object o);
    public abstract int hashCode();
    public abstract String toString();
}