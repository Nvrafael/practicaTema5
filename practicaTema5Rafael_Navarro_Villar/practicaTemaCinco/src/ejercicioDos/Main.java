package ejercicioDos;

import java.util.Scanner;

/**
 * Clase principal que ejecuta el programa
 */
public class Main {
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Definir el nombre del archivo binario
        System.out.println("Introduce tu nombre y apellido (sin espacios ni tildes):");
        String nombreApellido = scanner.nextLine();
        String nombreArchivo = nombreApellido + "Listin.bin";
        
        // Crear un array para almacenar 2 objetos Listin
        Listin[] contactos = new Listin[2];
        
        // Leer datos por teclado para cada objeto Listin
        System.out.println("\n=== INTRODUCCIÓN DE DATOS ===");
        for (int i = 0; i < contactos.length; i++) {
            contactos[i] = GestorListin.leerDatosContacto(scanner, i + 1);
        }
        
        // Guardar los objetos en el archivo binario
        boolean guardadoExitoso = GestorListin.guardarContactosEnArchivo(nombreArchivo, contactos);
        
        if (guardadoExitoso) {
            // Leer los objetos desde el archivo binario
            Listin[] contactosLeidos = GestorListin.leerContactosDesdeArchivo(nombreArchivo);
            
            // Mostrar los objetos leídos por consola
            GestorListin.mostrarContactos(contactosLeidos);
        }
        
        scanner.close();
    }
}
