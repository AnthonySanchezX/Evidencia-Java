/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package hospital;

/**
 *
 * @author Intel
 */
public class Administrador {
    private String nombre;
    private String password;
    
    public Administrador(String name, String pass){
        nombre = name;
        password = pass;
    }
    
    @Override
    public boolean equals(Object objeto){
        if(objeto instanceof Administrador) {
            Administrador otroAdmin = (Administrador)objeto;
            if(nombre.equals(otroAdmin.nombre) && password.equals(otroAdmin.password))
                return true;
            else
                return false;
        }
        else
            return false;
    }
}
