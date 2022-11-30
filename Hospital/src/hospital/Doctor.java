/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Intel
 */
public class Doctor {
    private String id;
    private String nombre;
    private String apellido;
    private String especialidad;
    
public Doctor(String id, String nombre, String apellido, String especialidad){
    this.id = id;
    this.nombre = nombre;
    this.apellido = apellido;
    this.especialidad = especialidad;
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

public String getEspecialidad(){
    return especialidad;
}

public void setEspecialidad(String especialidad){
    this.especialidad = especialidad;
}

    public String generarCSV(){
        return String.format("%s;%s;%s;%s\n", id, nombre, apellido, especialidad);
    }
    
public void mostrar(){
    System.out.println("ID Doctor: " + id + "\nNombre: " + nombre + "\nApellido: " + apellido
    + "\nEspecialidad: " + especialidad);
}


}
