package hash.components;


public class Element<K,V> {
    //Representa la marca de cada celda de la tabla hash
    public enum Mark {
        EMPTY,
        DELETED,
        OCUPPED
    }

    //Atributos
    protected Register<K,V> register;
    protected Mark mark;

    //Constructor por defecto
    public Element() {
        this.register = null;
        this.mark = Mark.EMPTY;
    }

    public Element(Register<K,V> register) {
        this.register = register;
        this.mark = Mark.OCUPPED;
    }

    public Register<K,V> getRegister() {return this.register;}
    public void setRegister(Register<K,V> register) {this.register = register;}
    public Mark getMark() {return this.mark;}
    public void setMark(Mark mark) {this.mark = mark;}
}