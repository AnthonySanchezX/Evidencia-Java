/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Intel
 */
public class Paciente {
    private String id;
    private String nombre;
    private String apellido;
    
     Paciente(String id, String nombre, String apellido){
        this.id = id;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getApellido(){
        return apellido;
    }
    
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    
    public String generarCSV(){
        return String.format("%s;%s;%s;\n", id, nombre, apellido);
    }
    
    public void mostrar(){
        System.out.println("ID Paciente: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido);
    }
}
