package ejercicioDos;

import java.io.*;
import java.util.Scanner;

/**
 * Clase para gestionar operaciones con objetos Listin
 */
public class GestorListin {
    
    /**
     * Método para leer datos por teclado y crear un objeto Listin
     * 
     * @param scanner Scanner para leer de teclado
     * @param numeroContacto Número de contacto que se está creando
     * @return Objeto Listin con los datos introducidos
     */
    public static Listin leerDatosContacto(Scanner scanner, int numeroContacto) {
        System.out.println("\n--- Datos del contacto " + numeroContacto + " ---");
        
        System.out.print("Introduce el nombre: ");
        String nombre = scanner.nextLine();
        
        System.out.print("Introduce la dirección: ");
        String direccion = scanner.nextLine();
        
        System.out.print("Introduce el teléfono: ");
        String telefono = scanner.nextLine();
        
        return new Listin(nombre, direccion, telefono);
    }
    
    /**
     * Guarda un array de objetos Listin en un archivo binario
     * 
     * @param nombreArchivo Nombre del archivo donde guardar los objetos
     * @param contactos Array de objetos Listin a guardar
     * @return true si la operación fue exitosa, false en caso contrario
     */
    public static boolean guardarContactosEnArchivo(String nombreArchivo, Listin[] contactos) {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(nombreArchivo))) {
            
            // Guardamos el array completo de objetos
            oos.writeObject(contactos);
            System.out.println("\nLos contactos se han guardado correctamente en " + nombreArchivo);
            return true;
            
        } catch (IOException e) {
            System.err.println("Error al guardar los contactos: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Lee un array de objetos Listin desde un archivo binario
     * 
     * @param nombreArchivo Nombre del archivo a leer
     * @return Array de objetos Listin leído del archivo
     */
    public static Listin[] leerContactosDesdeArchivo(String nombreArchivo) {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(nombreArchivo))) {
            
            // Leemos el array completo de objetos
            Listin[] contactos = (Listin[]) ois.readObject();
            System.out.println("\nLos contactos se han leído correctamente desde " + nombreArchivo);
            return contactos;
            
        } catch (IOException | ClassNotFoundException e) {
            System.err.println("Error al leer los contactos: " + e.getMessage());
            return null;
        }
    }
    
    /**
     * Muestra la información de un array de contactos por consola
     * 
     * @param contactos Array de objetos Listin a mostrar
     */
    public static void mostrarContactos(Listin[] contactos) {
        if (contactos == null || contactos.length == 0) {
            System.out.println("No hay contactos para mostrar.");
            return;
        }
        
        System.out.println("\n=== LISTADO DE CONTACTOS ===");
        for (int i = 0; i < contactos.length; i++) {
            System.out.println("\nContacto " + (i + 1) + ":");
            System.out.println("--------------------");
            System.out.println(contactos[i]);
        }
        System.out.println("\n===========================");
    }
}