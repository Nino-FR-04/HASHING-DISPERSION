package collections.impl_List;
import exceptions.ExceptionIsEmpty;

/**
 * Interfaz que define las operaciones básicas para una lista genérica.
 * Proporciona métodos para verificar si la lista está vacía, obtener su tamaño,
 * destruir la lista, buscar, insertar, eliminar, entre otras.
 *
 * @param E el tipo de elementos que almacena la lista, que debe ser comparable.
 */
public interface TADList <E> extends Iterable<E> {
    public boolean isEmpty();
    public int length();
    public void clearList();
    public int indexOf(E data);
    public E getByIndex(int index) throws ExceptionIsEmpty;
    public void insertFirst(E data);
    public void insertLast(E data);
    public boolean remove(E data);
}