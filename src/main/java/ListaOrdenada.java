public class ListaOrdenada<T extends Comparable<T>> extends Lista<T> {
    public ListaOrdenada() {
        super();
    }
    @Override
    public void insertar(T o) {
        if (raiz == null) {
            super.insertar(o);
            return;
        }
        Comparable<T> comparable = (Comparable)o;
        if (comparable.compareTo(raiz.getContenido()) <= 0) {
            super.insertar(o);
            return;
        }
        Contenedor<T> nuevo = new Contenedor<T>(o);
        Contenedor<T> actual = raiz;
        while(actual.getSiguiente() != null &&
                comparable.compareTo(actual.getSiguiente().getContenido()) > 0 ) {
            actual = actual.getSiguiente();
        }
        // Aqui actual es el nodo anterior al lugar donde debe ir o (nuevo)
        nuevo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevo);
        tamano++;
    }

}