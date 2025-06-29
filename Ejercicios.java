import hash.*;

public class Ejercicios {
    public static void main(String[] args) {
        
        //Ejercicio1
        System.out.println("==================Tabla Hash Cerrada===============");
        ClosedHash<Integer, String> tabla1 = new ClosedHash<>(7);
        tabla1.insert(3, "Valor 3");
        tabla1.insert(10, "Valor 10");
        tabla1.insert(17, "Valor 17");
        tabla1.insert(24, "Valor 24");

        System.out.println("Tabla hash cerrada (tamaño 7):");
        tabla1.printTable();

        
        System.out.println("\n==================Tabla Hash Abierta===============");
        OpenHash<Integer, String> tabla2 = new OpenHash<>(7);
        tabla2.insert(3, "Valor 3");
        tabla2.insert(10, "Valor 10");
        tabla2.insert(17, "Valor 17");
        tabla2.insert(24, "Valor 24");

        System.out.println("Tabla hash abierta (tamaño 7):");
        tabla2.printTable();

        //Ejercicio2
        System.out.println("==================Tabla Hash Cerrada===============");
        ClosedHash<Integer, String> tabla3 = new ClosedHash<>(6);
        tabla3.insert(12, "Valor 12");
        tabla3.insert(18, "Valor 18");
        tabla3.insert(24, "Valor 24");
        tabla3.insert(30, "Valor 30");

        System.out.println("Tabla hash cerrada (tamaño 6):");
        tabla3.printTable();
        
        //Ejercicio3
        System.out.println("\n==================Tabla Hash Abierta===============");
        OpenHash<Integer, String> tabla4 = new OpenHash<>(5);
        tabla4.insert(10, "Juan");
        tabla4.insert(15, "Ana");
        tabla4.insert(20, "Luis");
        tabla4.insert(25, "Rosa");

        System.out.println("Tabla hash abierta (tamaño 5):");
        tabla4.printTable();

        System.out.println("Nombre asociado a la clave 20: " + tabla4.search(20));
        //System.out.println("Nombre asociado a la clave 30: " + tabla4.search(30));

        //Ejercicio4
        System.out.println("==================Tabla Hash Cerrada===============");
        ClosedHash<Integer, String> tabla5 = new ClosedHash<>(7);
        tabla5.insert(5, "Valor 5");
        tabla5.insert(12, "Valor 12");
        tabla5.insert(19, "Valor 19");

        System.out.println("Tabla hash cerrada inicial (tamaño 7):");
        tabla5.printTable();

        System.out.println("Tabla hash cerrada despues de la eliminación de la clave 12:");
        tabla5.delete(12);
        tabla5.printTable();

        System.out.println("Busqueda de la clave 19: " + tabla5.search(19));
    }
}
