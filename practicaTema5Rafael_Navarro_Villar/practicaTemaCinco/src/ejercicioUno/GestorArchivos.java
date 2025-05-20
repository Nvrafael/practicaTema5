package ejercicioUno;

import java.io.*;


/**
 * Clase utilitaria que contiene métodos estáticos para gestionar archivos de texto
 */
public class GestorArchivos {
    
    /**
     * Escribe el contenido de un array de strings en un archivo
     * 
     * @param nombreArchivo Nombre del archivo donde escribir
     * @param frases Array de strings a escribir en el archivo
     * @return true si la operación fue exitosa, false en caso contrario
     */
    public static boolean escribirArrayEnArchivo(String nombreArchivo, String[] frases) {
        try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
            for (String frase : frases) {
                escritor.write(frase);
                escritor.newLine(); // Añade una nueva línea después de cada frase
            }
            System.out.println("Archivo creado correctamente: " + nombreArchivo);
            return true;
        } catch (IOException e) {
            System.err.println("Error al escribir en el archivo: " + e.getMessage());
            return false;
        }
    }
    
    /**
     * Lee el contenido de un archivo y lo muestra por consola
     * 
     * @param nombreArchivo Nombre del archivo a leer
     * @return El contenido del archivo como una cadena de texto
     */
    public static String leerArchivo(String nombreArchivo) {
        StringBuilder contenido = new StringBuilder();
        
        try (BufferedReader lector = new BufferedReader(new FileReader(nombreArchivo))) {
            String linea;
            System.out.println("\nContenido del archivo " + nombreArchivo + ":");
            System.out.println("----------------------------------------");
            
            while ((linea = lector.readLine()) != null) {
                System.out.println(linea);
                contenido.append(linea).append("\n");
            }
            
            System.out.println("----------------------------------------");
        } catch (IOException e) {
            System.err.println("Error al leer el archivo: " + e.getMessage());
        }
        
        return contenido.toString();
    }
    
    /**
     * Cuenta el número de palabras en un texto
     * 
     * @param texto Texto en el que contar palabras
     * @return Número de palabras encontradas
     */
    public static int contarPalabras(String texto) {
        if (texto == null || texto.trim().isEmpty()) {
            return 0;
        }
        
        // Dividimos el texto por espacios en blanco y contamos los elementos no vacíos
        String[] palabras = texto.trim().split("\\s+");
        return palabras.length;
    }
}
