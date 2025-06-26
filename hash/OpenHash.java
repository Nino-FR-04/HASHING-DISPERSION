package hash;

import collections.impl_List.ListLinked;
import hash.components.Register;

/**
 * Implementación de una tabla hash abierta.
 * Utiliza una estructura de arreglo para almacenar listas enlazadas,
 * resolviendo colisiones mediante esta estructura de datos.
 *
 * @param <K> Tipo de la clave
 * @param <V> Tipo del valor
 */
public class OpenHash<K,V> {
    
    //Atributos
    private ListLinked<Register<K,V>>[] hashTable;
    private int size;

    //Constructor
    /**
     * Crea una tabla hash cerrada con el tamaño especificado.
     *
     * @param size Tamaño inicial de la tabla hash
     */
    @SuppressWarnings("unchecked")
    public OpenHash(int size) {
        this.size = size;
        this.hashTable = new ListLinked[size];

        for(int i=0; i<this.size ;i++) {
            this.hashTable[i] = new ListLinked<>();
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

        int index = this.hashFunction(key);
        ListLinked<Register<K,V>> list = this.hashTable[index];

        // int regIndex = list.indexOf(new Register<K,V>(key,null));
        // if(regIndex == -1) 
        //     throw new RuntimeException("Clave no encontrada: " + key);
        // return list.getByIndex(regIndex);

        for (Register<K,V> register : list) {
            if(register.getKey().equals(key)){
                return register;
            }
        }

        throw new RuntimeException("Clave no encontrada: " + key);
    }

    /**
     * Inserta un nuevo par clave-valor en la tabla hash.
     * Si la clave ya existe, sobrescribe el valor anterior.
     *
     * @param key Clave a insertar
     * @param value Valor asociado a la clave
     */
    public void insert(K key, V value) {
        int index = this.hashFunction(key);
        
        ListLinked<Register<K, V>> list = this.hashTable[index];

        for (Register<K, V> reg : list) {
            if (reg.getKey().equals(key)) {
                reg.setValue(value);
                return;
            }
        }

        // -> Otra solucion
        // int indexReg = list.indexOf(new Register<>(key, value));
        // if(indexReg != -1) {
        //     list.getByIndex(indexReg).setValue(value);
        //     return;
        // }

        list.insertLast(new Register<>(key, value));
    }

    /**
     * Elimina un elemento de la tabla hash mediante su clave.
     *
     * @param key Clave a eliminar
     * @throws RuntimeException si la clave no se encuentra
     */
    public void delete(K key) throws RuntimeException {
        int index = this.hashFunction(key);

        ListLinked<Register<K,V>> list = this.hashTable[index];
        boolean del = list.remove(new Register<>(key, null));

        if(!del) throw new RuntimeException("Clave no encontrada: " + key);
    }

    /**
     * Imprime el contenido de la tabla hash por consola.
     * Muestra el indice y la lista correspondiente.
     */
    public void printTable() {

        System.out.println("{");

        for(int i=0 ; i<this.size ;i++) {
            System.out.println("  Index: " + i + " - " + this.hashTable[i]);
        }
        
        System.out.println("}");
    }
}