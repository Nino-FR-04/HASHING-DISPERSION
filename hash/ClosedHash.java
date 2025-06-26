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
    @SuppressWarnings("unchecked")
    public ClosedHash(int size) {
        this.size = size;
        this.hashTable = (Element<K,V>[]) new Element[size];

        for(int i=0;i<this.size;i++) {
            this.hashTable[i] = new Element<>();
        }
    }

    //Metodos
    public int getSize() {return this.size;}

    private int hashFunction(K key) {
        return Math.abs(key.hashCode() % this.hashTable.length);
    }

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

    public void insert(K key, V value) throws RuntimeException {
        int index = this.linearProbingInsert(key);

        if(index == -1) throw new RuntimeException("La tabla esta llena");

        this.hashTable[index].setRegister(new Register<>(key, value));
        this.hashTable[index].setMark(Mark.OCUPPED);
    }

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

    public void printTable() {

        System.out.println("{");
        for(int i=0 ; i<this.size ;i++) {

            Element<K,V> element = this.hashTable[i];

            if(element.getMark() == Mark.OCUPPED) {
                System.out.println("Index: " + i + " - " + element.getRegister());
                continue;
            }
            System.out.println("Index: " + i + " - " + this.hashTable[i].getMark());
        }
        System.out.println("}");
    }
}
