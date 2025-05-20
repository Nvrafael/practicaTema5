package ejercicioUno;

import java.util.Scanner;

/**
 * Clase principal que ejecuta el programa
 */
public class Main {
    
    public static void main(String[] args) {
        // Array de frases a escribir en el archivo
        String[] frases = {
            "El sol brilla intensamente hoy.",
            "Me gusta aprender cosas nuevas cada día.",
            "La programación es una habilidad muy útil.",
            "A veces, los errores enseñan más que los aciertos.",
            "Leer libros expande la mente."
        };
        
        // Solicitar el nombre del archivo al usuario
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduce el nombre del archivo (debe ser tu nombre completo sin espacios ni tildes, con extensión .txt):");
        String nombreArchivo = scanner.nextLine();
        
        // Validar que el nombre del archivo termina con .txt
        if (!nombreArchivo.endsWith(".txt")) {
            nombreArchivo += ".txt";
        }
        
        // Escribir el array en el archivo
        boolean resultado = GestorArchivos.escribirArrayEnArchivo(nombreArchivo, frases);
        
        if (resultado) {
            // Leer el contenido del archivo
            String contenido = GestorArchivos.leerArchivo(nombreArchivo);
            
            // Contar el número de palabras
            int numeroPalabras = GestorArchivos.contarPalabras(contenido);
            System.out.println("\nNúmero total de palabras en el archivo: " + numeroPalabras);
        }
        
        scanner.close();
    }
}
