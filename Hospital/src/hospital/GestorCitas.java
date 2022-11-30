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
public final class GestorCitas {
    private ArrayList<Cita> citas;
    
    public GestorCitas(){
        citas = new ArrayList<Cita>();
    }
    
    public boolean nuevaCita(){
        String id = JOptionPane.showInputDialog(null, "Ingresa ID Cita: ", "Nueva Cita", JOptionPane.QUESTION_MESSAGE);
        String fecha = JOptionPane.showInputDialog(null, "Fecha Cita: ", "Nueva Cita", JOptionPane.QUESTION_MESSAGE);
        String hora = JOptionPane.showInputDialog(null, "Hora Cita: ", "Nueva Cita", JOptionPane.QUESTION_MESSAGE);
        String motivo = JOptionPane.showInputDialog(null, "Motivo Cita: ", "Nueva Cita", JOptionPane.QUESTION_MESSAGE);
        
        Cita nuevaCita = new Cita(id, fecha, hora, motivo);
        return citas.add(nuevaCita);
    }
    
    public void mostrarCita(){
        for(Cita c: citas)
            c.mostrar();
    }
    
    public boolean modificarCita(){
        String id = JOptionPane.showInputDialog(null, "Introduzca Identificador de la Cita a modificar:",
				"Modificar Cita", JOptionPane.QUESTION_MESSAGE);
        
        Cita cita = null;
		for (int i = 0; i < citas.size(); i++){
			if (citas.get(i).getId().equals(id)) {
				cita = citas.get(i);
				break;
			}
    }
       if (cita == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Cita con el ID:\n" + id,
					"Cita no encontrada", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			
			cita.setId(JOptionPane.showInputDialog(null, "ID actual: " + cita.getId()
				+ "\nIntroduzca nuevo identificador:", "Modificar Cita", JOptionPane.QUESTION_MESSAGE));
			cita.setFecha(JOptionPane.showInputDialog(null, "Fecha actual: " + cita.getFecha()
				+ "\nIntroduzca nueva fecha:", "Modificar Cita", JOptionPane.QUESTION_MESSAGE));
			cita.setHora(JOptionPane.showInputDialog(null, "Hora Cita: " + cita.getHora()
				+ "\nIntroduzca nuevo hora:", "Modificar Cita", JOptionPane.QUESTION_MESSAGE));
                        cita.setMotivo(JOptionPane.showInputDialog(null, "Motivo Cita: " + cita.getMotivo()
				+ "\nIntroduzca nuevo motivo:", "Modificar Cita", JOptionPane.QUESTION_MESSAGE));
	
			return true;
		}                   
}
    
    public boolean borrarCita() {
		String id = JOptionPane.showInputDialog(null, "Introduzca Identificador de la cita a borrar:",
				"Borrar Cita", JOptionPane.QUESTION_MESSAGE);
		
		Cita cita = null;
		for (int i = 0; i < citas.size(); i++){
			if (citas.get(i).getId().equals(id))
				cita = citas.remove(i);
		}
		
		if (cita == null) {
			JOptionPane.showMessageDialog(null, "No se encuentra Cita con el ID:\n" + id,
					"Cita no encontrado", JOptionPane.WARNING_MESSAGE);
			return false;
		}
		else {
			JOptionPane.showMessageDialog(null, "Se elimino la Cita con ID:\n" + id,
					"Cita Eliminado", JOptionPane.INFORMATION_MESSAGE);
			return false;
		}
	}
    public void crearCSV() {
		//E:\Java projects\Hospital
		File archivo = new File("E:/Java projects/hospital/citas.csv");
		
		try {
			//Si no existe archivo, intentamos crearlo
			if (!archivo.exists()) {
				File carpeta = archivo.getParentFile();
				carpeta.mkdirs();
				archivo.createNewFile();
			}
			
			FileWriter escritor = new FileWriter(archivo);
			//Cabecera para datos del CSV
			escritor.append("#ID;Fecha;Hora;Motivo\n");
			
			//Datos de los doctores
			for (Cita cita: citas)
				escritor.append(cita.generarCSV());//Insertamos linea CSV
			
			escritor.close();
		} catch (IOException e) {
			System.out.println("Error de acceso a: " + archivo.getAbsolutePath());
		}
	}
}
