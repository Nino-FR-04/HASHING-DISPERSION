package collections.nodes;

public class Node <E> {

    //Atributos
    protected E data;
    protected Node <E> next;

    //Getters
    public E getData() {return this.data;}
    public Node<E> getNext() {return this.next;}
    
    //Setters
    public void setData(E data) {this.data = data;}
    public void setNext(Node<E> next) {this.next = next;}

    /**
     * Crea un nuevo nodo con el dato especificado.
     * La referencia al siguiente nodo se inicializa como null.
     *
     * @param data el dato que se almacenará en el nodo.
     */
    public Node(E data) {
        this.data = data;
        this.next = null;
    }

    // -> ToString
    @Override
    public String toString() {
        return data.toString();
    }
}