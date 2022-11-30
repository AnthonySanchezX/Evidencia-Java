/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Intel
 */
public class Cita {
    private String id;
    private String fecha;
    private String hora;
    private String motivo;
    
    public Cita(String id, String fecha, String hora, String motivo){
        this.id = id;
        this.fecha = fecha;
        this.hora = hora;
        this.motivo = motivo;
    }
    
    public String getId(){
        return id;
    }
    
    public void setId(String id){
        this.id = id;
    }
    
    public String getFecha(){
        return fecha;
    }
    
    public void setFecha(String fecha){
        this.fecha = fecha;
    }
    
    public String getHora(){
        return hora;
    }
    
    public void setHora(String hora){
        this.hora = hora;
    }
    
    public String getMotivo(){
        return motivo;
    }
    
    public void setMotivo(String motivo){
        this.motivo = motivo;
    }
    
    public String generarCSV(){
        return String.format("%s;%s;%s;%s\n", id, fecha, hora, motivo);
    }
    
    public void mostrar(){
        System.out.println("ID Cita" + id + "\nFecha: " + fecha + "\nHora: " + hora + "\nMotivo: " + motivo);
    }
}
