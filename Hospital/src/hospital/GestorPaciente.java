/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Intel
 */
public final class GestorPaciente {
    private ArrayList<Paciente> pacientes;
    
    public GestorPaciente(){
        pacientes = new ArrayList<Paciente>();
    }
    
    public boolean nuevoPaciente(){
        String id = JOptionPane.showInputDialog(null, "Ingresa ID Paciente: ", "Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);
        String nombre = JOptionPane.showInputDialog(null, "Nombre Paciente: ", "Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);
        String apellidos = JOptionPane.showInputDialog(null, "Apellido Paciente: ", "Nuevo Paciente", JOptionPane.QUESTION_MESSAGE);
        
        Paciente nuevoPaciente = new Paciente(id, nombre, apellidos);
		return pacientes.add(nuevoPaciente);
        }
    public void mostrarPacientes(){
        for( Paciente p: pacientes)
            p.mostrar();
    }
    
    public boolean modificarPaciente(){
        String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente a modificar:",
				"Modificar Paciente", JOptionPane.QUESTION_MESSAGE);
        
        Paciente paciente = null;
		for (int i = 0; i < pacientes.size(); i++){
			if (pacientes.get(i).getId().equals(id)) {
				paciente = pacientes.get(i);
				break;
			}
    }
                
       if (paciente == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Paciente con el ID:\n" + id,
					"Paciente no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			
			paciente.setId(JOptionPane.showInputDialog(null, "ID actual: " + paciente.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar Paciente", JOptionPane.QUESTION_MESSAGE));
			paciente.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + paciente.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar Paciente", JOptionPane.QUESTION_MESSAGE));
			paciente.setApellido(JOptionPane.showInputDialog(null, "Apellidos actuales: " + paciente.getApellido()
				+ "\nIntroduzca nuevos apellido:", "Modificar Paciente", JOptionPane.QUESTION_MESSAGE));
	
			return true;
		}         
}
    
    public boolean borrarPaciente() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del paciente a borrar:",
				"Borrar Paciente", JOptionPane.QUESTION_MESSAGE);
		
		Paciente paciente = null;
		for (int i = 0; i < pacientes.size(); i++){
			if (pacientes.get(i).getId().equals(id))
				paciente = pacientes.remove(i);
		}
		
		if (paciente == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Paciente con el ID:\n" + id,
					"Paciente no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el paciente con ID:\n" + id,
					"Paciente Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
    
    public void crearCSV() {
		//E:\Java projects\Hospital
		File archivo = new File("E:/Java projects/hospital/pacientes.csv");
		
		try {
			//Si no existe archivo, intentamos crearlo
			if (!archivo.exists()) {
				File carpeta = archivo.getParentFile();
				carpeta.mkdirs();
				archivo.createNewFile();
			}
			
			FileWriter escritor = new FileWriter(archivo);
			//Cabecera para datos del CSV
			escritor.append("#ID;Nombre;Apellido;\n");
			
			//Datos de los doctores
			for (Paciente paciente: pacientes)
				escritor.append(paciente.generarCSV());//Insertamos linea CSV
			
			escritor.close();
		} catch (IOException e) {
			System.out.println("Error de acceso a: " + archivo.getAbsolutePath());
		}
	}
    
    
}  
