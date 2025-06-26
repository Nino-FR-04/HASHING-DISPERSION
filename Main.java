import hash.OpenHash;

public class Main {
    public static void main(String[] args) {
        OpenHash<Integer,String> hash = new OpenHash<>(5);

        hash.insert(1, "Uno");
        hash.insert(6, "Seis"); 
        hash.insert(3, "Tres");
        hash.insert(2, "Dos");
        hash.insert(7, "Siete"); 

        hash.printTable();

        System.out.println(hash.search(3));
        hash.delete(1);
        hash.insert(12, "Doce");
        hash.printTable();
        System.out.println(hash.search(12));
    }
}
