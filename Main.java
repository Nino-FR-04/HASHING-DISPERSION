import hash.*;

public class Main {
    public static void main(String[] args) {
        
        //Hash Cerrado
        ClosedHash<Integer,String> hashClosed = new ClosedHash<>(14);

        System.out.println("=========Hash_Cerrado============");

        //Insercion
        hashClosed.insert(34, "Treinta y cuatro");
        hashClosed.insert(3, "Tres");
        hashClosed.insert(7, "Siete");
        hashClosed.insert(30, "Treinta");
        hashClosed.insert(11, "Once");
        hashClosed.insert(8, "Ocho");
        hashClosed.insert(7, "Siete modificado"); // Sobrescribe el valor anterior
        hashClosed.insert(23, "Veintitrés");
        hashClosed.insert(41, "Cuarenta y uno");
        hashClosed.insert(16, "Dieciséis");
        hashClosed.insert(34, "Treinta y cuatro actualizado"); // Sobrescribe el valor anterior

        hashClosed.printTable();

        //Eliminar clave 30
        hashClosed.delete(30);
        System.out.println("\nTabla despues de eliminar 30: ");
        hashClosed.printTable();

        //Buscar la clave 23
        System.out.println("¿Existe la clave 23?: " + hashClosed.search(23));

        // Hash Cerrado
        OpenHash<Integer, String> hashOpen = new OpenHash<>(7);

        System.out.println("\n========= Hash Abierto ==========");

        // Inserciones
        hashOpen.insert(12, "Doce");
        hashOpen.insert(5, "Cinco");
        hashOpen.insert(9, "Nueve");
        hashOpen.insert(27, "Veintisiete");
        hashOpen.insert(18, "Dieciocho");
        hashOpen.insert(4, "Cuatro");
        hashOpen.insert(9, "Nueve actualizado"); // Sobrescribe valor anterior
        hashOpen.insert(31, "Treinta y uno");
        hashOpen.insert(38, "Treinta y ocho");
        hashOpen.insert(21, "Veintiuno");
        hashOpen.insert(12, "Doce actualizado"); // Sobrescribe valor anterior

        // Mostrar tabla antes de eliminar
        hashOpen.printTable();

        // Eliminar clave 27
        hashOpen.delete(27);
        System.out.println("\nTabla después de eliminar 27:");
        hashOpen.printTable();

        // Buscar clave 31
        System.out.println("¿Existe la clave 31?: " + hashOpen.search(31));
    }
}
