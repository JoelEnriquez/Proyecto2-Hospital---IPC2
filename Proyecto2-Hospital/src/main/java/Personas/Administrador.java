/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Personas;

/**
 * 
 * @author Joel Enriquez
 */
public class Administrador extends Persona{
    
    public static final String ADMINISTRADOR_DB_NAME = "ADMINISTRADOR";
    public static final String ADMINISTRADOR_CODIGO_DB_NAME = "codigo";
    public static final String NOMBRE_DB_NAME = "nombre";
    public static final String DPI_DB_NAME = "DPI";
    public static final String PASSWORD_DB_NAME = "password";
    
    public Administrador(String codigo, String nombre, String DPI, String contraseña) {
        super(codigo, nombre, DPI, contraseña);
    }
    
    
    
}
