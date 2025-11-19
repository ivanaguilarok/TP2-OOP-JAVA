import java.util.Iterator;
import java.util.NoSuchElementException;

public class ListaEnlazada<T> implements Iterable<T> {
    private Nodo<T> nodoInicial;
    private int size;

    // Constructor
    public ListaEnlazada() {
        this.nodoInicial = null;
        this.size = 0;
    }

    public void insertarOrdenado(T dato) {
        if (!(dato instanceof Comparable)) {
             agregarAlFinal(dato); 
             return;
        }

        Comparable<T> comparableDato = (Comparable<T>) dato;
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        
        if (this.nodoInicial == null || comparableDato.compareTo(this.nodoInicial.getDato()) < 0) {
            nuevoNodo.setSiguiente(this.nodoInicial);
            this.nodoInicial = nuevoNodo;
            this.size++;
            return;
        } 

        Nodo<T> actual = this.nodoInicial;
        
        while (actual.getSiguiente() != null) {
            Comparable<T> siguienteDato = (Comparable<T>) actual.getSiguiente().getDato(); 

            if (siguienteDato.compareTo(dato) > 0) {
                break;
            }
            actual = actual.getSiguiente();
        }
        
        nuevoNodo.setSiguiente(actual.getSiguiente());
        actual.setSiguiente(nuevoNodo);
        this.size++;
    }

    // Métodos
    public void agregarAlFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if(this.nodoInicial == null) {
            this.nodoInicial = nuevoNodo;
        } else {
            Nodo<T> nodoActual = this.nodoInicial;
            while (nodoActual.getSiguiente() != null) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(nuevoNodo);
        }
        this.size++;
    }

    public Nodo<T> getHead() {
        return this.nodoInicial;
    }
    public int getSize() {
        return this.size;
    }
    public boolean isEmpty() {
        return this.size == 0;
    }

    @Override
    public Iterator<T> iterator() {
        return new IteradorLista<T> (this.nodoInicial);
    }
    private static class IteradorLista<T> implements Iterator<T> {
        private Nodo<T>nodoActual;

        public IteradorLista(Nodo<T>nodoInicial) {
            this.nodoActual = nodoInicial;
        }

        @Override
        public boolean hasNext() {
            return nodoActual != null;
        }
        @Override
        public T next() {
            if(!hasNext()) {
                throw new NoSuchElementException("No hay más elementos en la lista.");
            }

            T dato = nodoActual.getDato();
            nodoActual = nodoActual.getSiguiente();
            return dato;
        }
    }
}