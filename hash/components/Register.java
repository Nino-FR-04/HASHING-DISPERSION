package hash.components;

public class Register<K,V> {
    
    //Atributos
    protected K key;
    protected V value;

    //Constructor
    public Register(K key, V value) {
        this.key = key;
        this.value = value;
    }

    //Getters y setters
    public K getKey() {return this.key;}
    public V getValue() {return this.value;}
    public void setKey(K key) {this.key = key;}
    public void setValue(V value) {this.value = value;}

    //toString
    @Override
    public String toString() {
        return "(" + this.key + ", " + this.value + ")";
    }

    //Equals
    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if(obj == null || obj.getClass() != this.getClass()) return false;

        Register<?,?> reg = (Register<?,?>) obj;
        return this.key.equals(reg.key);
    }
}