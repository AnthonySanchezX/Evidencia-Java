/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package hospital;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Intel
 */
public class Hospital {

    private static ArrayList<Administrador> administradores = new ArrayList<Administrador>();
    private static Scanner sn = new Scanner(System.in);
    static GestorPaciente pacientes = new GestorPaciente();
    static GestorDoctor doctores = new GestorDoctor();
    static GestorCitas citas = new GestorCitas();

    public static void main(String[] args) {
        int decision = 0;
        
        boolean salir = false;
        
        crearAdmins();
      
        if(validarAcceso()){
            System.out.println("Usuario autorizado");
        }else{
            System.out.println("Usuario no autorizado");
            
        }
        
        while(!salir){
        System.out.println("1. Dar de alta un medico\n" 
            + "2. Dar de alta un paciente\n"
            + "3. Crear una cita\n" 
            + "4. Ver medicos\n" 
            + "5. Ver pacientes\n"
            + "6. Ver citas\n"
            + "7. Eliminar medico\n"
            + "8. Eliminar paciente\n"
            + "9. Eliminar Cita\n"
            + "10. Salir");
       decision = sn.nextInt();
       switch(decision){
           case 1:
               doctores.nuevoDoctor();
               doctores.crearCSV();
               break;
           case 2:
               pacientes.nuevoPaciente();
               pacientes.crearCSV();
               break;
           case 3:
               citas.nuevaCita();
               citas.crearCSV();
               break;
           case 4:
               doctores.mostrarDoctor();
               break;
           case 5:
               pacientes.mostrarPacientes();
               break;
           case 6:
               citas.mostrarCita();
               break;
           case 7:
               doctores.borrarDoctor();
               break;
           case 8:
               pacientes.borrarPaciente();
               break;
           case 9:
               citas.borrarCita();
               break;
           case 10:
               salir = true;
               break;
               
       }
        }
       
       
    }
    
    public static void crearAdmins(){
        administradores.add(new Administrador("Secre1", "1478"));
        administradores.add(new Administrador("Secre2", "2589"));
        administradores.add(new Administrador("Secre3", "3697"));
        administradores.add(new Administrador("Secre4", "9632"));
    }
    
    public static boolean validarAcceso(){
        System.out.println("Acceso al sistema");
        System.out.println("-------------------");
        System.out.println("Usuario: ");
        String nombre = sn.nextLine();
        System.out.println("Password: ");
        String password = sn.nextLine();
        
        Administrador admin = new Administrador(nombre, password);
        
        return administradores.contains(admin);
    }
    
    
    
    
    
}
