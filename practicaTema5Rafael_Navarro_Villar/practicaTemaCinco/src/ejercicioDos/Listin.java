package ejercicioDos;

import java.io.Serializable;

/**
 * Clase Listin que contiene información de contacto
 * Implementa Serializable para poder guardar objetos en archivos binarios
 */
public class Listin implements Serializable {
    
    // Necesario para la serialización
    private static final long serialVersionUID = 1L;
    
    // Atributos de la clase
    private String nombre;
    private String direccion;
    private String telefono;
    
    /**
     * Constructor por defecto
     */
    public Listin() {
        this.nombre = "";
        this.direccion = "";
        this.telefono = "";
    }
    
    /**
     * Constructor con parámetros
     * 
     * @param nombre Nombre del contacto
     * @param direccion Dirección del contacto
     * @param telefono Teléfono del contacto
     */
    public Listin(String nombre, String direccion, String telefono) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
    // Getters y setters
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    public String getDireccion() {
        return direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    
    public String getTelefono() {
        return telefono;
    }
    
    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
    
    /**
     * Método toString para mostrar la información del objeto
     */
    @Override
    public String toString() {
        return "Nombre: " + nombre + "\n" +
               "Dirección: " + direccion + "\n" +
               "Teléfono: " + telefono;
    }
}