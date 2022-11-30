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
public final class GestorDoctor {
    private ArrayList<Doctor> doctores;
    
    public GestorDoctor(){
        doctores = new ArrayList<Doctor>();
    }
    
    public boolean nuevoDoctor(){
        String id = JOptionPane.showInputDialog(null, "Ingresa ID Doctor: ", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
        String nombre = JOptionPane.showInputDialog(null, "Nombre Doctor: ", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
        String apellido = JOptionPane.showInputDialog(null, "Apellido Doctor: ", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
        String especialidad = JOptionPane.showInputDialog(null, "Especialidad: ", "Nuevo Doctor", JOptionPane.QUESTION_MESSAGE);
        
        Doctor nuevoDoctor = new Doctor(id, nombre, apellido, especialidad);
        return doctores.add(nuevoDoctor);
    }
    
    public void mostrarDoctor(){
        for(Doctor d: doctores)
            d.mostrar();
    }
    
    public boolean modificarDoctor(){
        String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del doctor a modificar:",
				"Modificar Doctor", JOptionPane.QUESTION_MESSAGE);
        
        Doctor doctor = null;
		for (int i = 0; i < doctores.size(); i++){
			if (doctores.get(i).getId().equals(id)) {
				doctor = doctores.get(i);
				break;
			}
    }
       if (doctor == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Doctor con el ID:\n" + id,
					"Doctor no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			
			doctor.setId(JOptionPane.showInputDialog(null, "ID actual: " + doctor.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar Doctor", JOptionPane.QUESTION_MESSAGE));
			doctor.setNombre(JOptionPane.showInputDialog(null, "Nombre actual: " + doctor.getNombre()
				+ "\nIntroduzca nuevo nombre:", "Modificar Doctor", JOptionPane.QUESTION_MESSAGE));
			doctor.setApellido(JOptionPane.showInputDialog(null, "Apellidos Doctor: " + doctor.getApellido()
				+ "\nIntroduzca nuevos apellido:", "Modificar Doctor", JOptionPane.QUESTION_MESSAGE));
                        doctor.setApellido(JOptionPane.showInputDialog(null, "Apellidos Doctor: " + doctor.getApellido()
				+ "\nIntroduzca nuevos apellido:", "Modificar Doctor", JOptionPane.QUESTION_MESSAGE));
                        doctor.setEspecialidad(JOptionPane.showInputDialog(null, "Especialidad Doctor: " + doctor.getEspecialidad()
				+ "\nIntroduzca nueva especialidad:", "Modificar Doctor", JOptionPane.QUESTION_MESSAGE));
			return true;
		}                   
}
    
    public boolean borrarDoctor() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador del doctor a borrar:",
				"Borrar Doctor", JOptionPane.QUESTION_MESSAGE);
		
		Doctor doctor = null;
		for (int i = 0; i < doctores.size(); i++){
			if (doctores.get(i).getId().equals(id))
				doctor = doctores.remove(i);
		}
		
		if (doctor == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Doctor con el ID:\n" + id,
					"Doctor no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino el doctor con ID:\n" + id,
					"Doctor Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
    public void crearCSV() {
		//E:\Java projects\Hospital
		File archivo = new File("E:/Java projects/hospital/doctores.csv");
		
		try {
			//Si no existe archivo, intentamos crearlo
			if (!archivo.exists()) {
				File carpeta = archivo.getParentFile();
				carpeta.mkdirs();
				archivo.createNewFile();
			}
			
			FileWriter escritor = new FileWriter(archivo);
			//Cabecera para datos del CSV
			escritor.append("#ID;Nombre;Apellido;Especialidad\n");
			
			//Datos de los doctores
			for (Doctor doctor: doctores)
				escritor.append(doctor.generarCSV());//Insertamos linea CSV
			
			escritor.close();
		} catch (IOException e) {
			System.out.println("Error de acceso a: " + archivo.getAbsolutePath());
		}
	}
    
}
