package hash;

import hash.components.Element;
import hash.components.Register;
import hash.components.Element.Mark;

/**
 * Implementación de una tabla hash cerrada con sondeo lineal.
 * Utiliza una estructura de arreglo para almacenar pares clave-valor,
 * resolviendo colisiones mediante sondeo lineal.
 *
 * @param <K> Tipo de la clave
 * @param <V> Tipo del valor
 */
public class ClosedHash<K,V> {
    
    //Atributos
    private Element<K,V>[] hashTable;
    private int size;

    //Constructor
    /**
     * Crea una tabla hash cerrada con el tamaño especificado.
     *
     * @param size Tamaño inicial de la tabla hash
     */
    @SuppressWarnings("unchecked")
    public ClosedHash(int size) {
        this.size = size;
        this.hashTable = (Element<K,V>[]) new Element[size];

        for(int i=0;i<this.size;i++) {
            this.hashTable[i] = new Element<>();
        }
    }

    //Metodos
    /**
     * Obtiene el tamaño de la tabla hash.
     *
     * @return Tamaño de la tabla
     */
    public int getSize() {return this.size;}

    /**
     * Función hash básica basada en el código hash de la clave.
     *
     * @param key Clave para calcular la posición
     * @return Índice calculado en la tabla hash
     */
    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % this.hashTable.length);
    }

    /**
     * Busca un registro en la tabla hash mediante su clave.
     *
     * @param key Clave a buscar
     * @return El registro asociado a la clave
     * @throws RuntimeException si la clave no se encuentra
     */
    public Register<K,V> search(K key) throws RuntimeException {

        int posInit = this.hashFunction(key);
        int currentPos = posInit;

        while (true) {
            Element<K,V> element = this.hashTable[currentPos];
            
            if (element.getMark() == Mark.EMPTY) {
                throw new RuntimeException("Clave no encontrada: " + key);
            }
            
            if(element.getMark() == Mark.OCUPPED && element.getRegister().getKey().equals(key)) {
                return element.getRegister();
            }

            currentPos = (currentPos + 1) % this.size;
            if(currentPos == posInit) break;
        }
        
        throw new RuntimeException("Clave no encontrada: " + key);

    }

    /**
     * Inserta un nuevo par clave-valor en la tabla hash.
     * Si la clave ya existe, sobrescribe el valor anterior.
     *
     * @param key   Clave a insertar
     * @param value Valor asociado
     * @throws RuntimeException si la tabla está llena
     */
    public void insert(K key, V value) throws RuntimeException {
        int index = this.linearProbingInsert(key);

        if(index == -1) throw new RuntimeException("La tabla esta llena");

        this.hashTable[index].setRegister(new Register<>(key, value));
        this.hashTable[index].setMark(Mark.OCUPPED);
    }

    /**
     * Busca una posición disponible en la tabla usando sondeo lineal.
     * También puede devolver el índice actual si la clave ya existe.
     *
     * @param key Clave a insertar
     * @return Índice para insertar o actualizar, o -1 si no hay espacio
     */
    private int linearProbingInsert(K key) {
        
        int posInit = this.hashFunction(key);
        int currentPos = posInit;

        while (true) {
            Element<K,V> element = this.hashTable[currentPos];
            if(element.getMark() == Mark.EMPTY || element.getMark() == Mark.DELETED) {
                return currentPos;
            }

            if(element.getMark() == Mark.OCUPPED && element.getRegister().getKey().equals(key)) {
                return currentPos;
            }

            currentPos = (currentPos + 1) % this.size;
            if(currentPos == posInit) break;
        }

        return -1;
    }

    /**
     * Elimina un elemento de la tabla hash mediante su clave.
     *
     * @param key Clave a eliminar
     * @throws RuntimeException si la clave no se encuentra
     */
    public void delete(K key) throws RuntimeException {
        
        int posInit = this.hashFunction(key);
        int currentPos = posInit;

        while (true) {
            Element<K,V> element = this.hashTable[currentPos];
            
            if(element.getMark() == Mark.OCUPPED && element.getRegister().getKey().equals(key)) {
                element.setMark(Mark.DELETED);
                return;
            }

            if(element.getMark() == Mark.EMPTY) break;

            currentPos = (currentPos + 1) % this.size;
            if(currentPos == posInit) break;
        }
        
        throw new RuntimeException("Clave no encontrada: " + key);
    }

    /**
     * Imprime el contenido de la tabla hash por consola.
     * Muestra para cada índice si está ocupado o su estado de marca.
     */
    public void printTable() {

        System.out.println("{");
        for(int i=0 ; i<this.size ;i++) {

            Element<K,V> element = this.hashTable[i];

            if(element.getMark() == Mark.OCUPPED) {
                System.out.println("  Index: " + i + " - " + element.getRegister());
                continue;
            }
            System.out.println("  Index: " + i + " - " + this.hashTable[i].getMark());
        }
        System.out.println("}");
    }
}