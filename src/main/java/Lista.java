import java.util.Iterator;

public class Lista<T> implements Iterable<T> {

    protected Contenedor<T> raiz;
    protected int tamano;

    public Lista() {
        raiz = null;
        tamano = 0;
    }

    public Contenedor<T> getRaiz() {
        return raiz;
    }

    public void setRaiz(Contenedor<T> raiz) {
        this.raiz = raiz;
    }

    public void insertar(T o) {
        Contenedor<T> nuevo = new Contenedor<T>(o);
        nuevo.setSiguiente(raiz);
        raiz = nuevo;
        tamano++;
    }

    public int tamano() {
        return tamano;
    }

    public void add(T o) {
        if (raiz == null) {
            insertar(o);
            return;
        }
        Contenedor<T> actual = raiz;
        Contenedor<T> nuevo = new Contenedor<T>(o);
        while (actual.getSiguiente() != null) {
            actual = actual.getSiguiente();
        }
        // Aqui tenemos al ultimo
        actual.setSiguiente(nuevo);
        tamano++;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Contenedor<T> actual = raiz;
        while (actual != null) {
            sb.append("[" + actual.getContenido().toString() + "]---");
            actual = actual.getSiguiente();
        }
        return sb.toString();
    }


    @Override
    public Iterator<T> iterator() {
        return new IteradorLista<T>(raiz);
    }

    class IteradorLista<T> implements Iterator<T> {

        private Contenedor<T> actual;

        public IteradorLista(Contenedor<T> inicio) {
            actual = inicio;
        }

        @Override
        public boolean hasNext() {
            return actual != null;
        }

        @Override
        public T next() {
            T result = actual.getContenido();
            actual = actual.getSiguiente();
            return result;
        }

    }

    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
    class Contenedor<T> {
        private T contenido;
        private Contenedor<T> siguiente;

        public Contenedor(T c) {
            contenido = c;
            siguiente = null;
        }

        public T getContenido() {
            return contenido;
        }

        public void setContenido(T contenido) {
            this.contenido = contenido;
        }

        public Contenedor<T> getSiguiente() {
            return siguiente;
        }

        public void setSiguiente(Contenedor<T> siguiente) {
            this.siguiente = siguiente;
        }
    }

}