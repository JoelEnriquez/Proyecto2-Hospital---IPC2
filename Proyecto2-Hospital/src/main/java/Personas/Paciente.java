/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Personas;

import java.sql.Date;

/**
 * 
 * @author Joel Enriquez
 */
public class Paciente extends Persona {
    
    public static final String PACIENTE_DB_NAME = "PACIENTE";
    public static final String PACIENTE_CODIGO_DB_NAME = "codigo";
    public static final String NOMBRE_DB_NAME = "nombre";
    public static final String SEXO_DB_NAME = "sexo";
    public static final String BIRTH_DB_NAME = "fecha_nacimiento";
    public static final String DPI_DB_NAME = "DPI";
    public static final String TELEFONO_DB_NAME = "telefono";
    public static final String PESO_DB_NAME = "peso";
    public static final String TIPO_SANGRE_DB_NAME = "tipo_sangre";
    public static final String CORREO_DB_NAME = "correo_electronico";
    public static final String PASSWORD_DB_NAME = "password";
    
    private String sexo;
    private Date fechaNacimiento;
    private String peso;
    private String tipoSangre;
    
    private int numeroInformes; //Sirve para guardar el numero de informes de un paciente

    public Paciente(String sexo, Date fechaNacimiento, String peso, String tipoSangre,
            String codigo, String nombre, String DPI, String contraseña,
            String telefono, String correoElectronico) {
        super(codigo, nombre, DPI, contraseña, telefono, correoElectronico);
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
    }

    public Paciente(String sexo, Date fechaNacimiento, String peso, String tipoSangre,
            String nombre, String DPI, String contraseña,
            String telefono, String correoElectronico) {
        super(nombre, DPI, contraseña, telefono, correoElectronico);
        this.sexo = sexo;
        this.fechaNacimiento = fechaNacimiento;
        this.peso = peso;
        this.tipoSangre = tipoSangre;
    }
    
    

    public String getSexo() {
        return sexo;
    }

    public void setSexo(String sexo) {
        this.sexo = sexo;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento;
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipoSangre() {
        return tipoSangre;
    }

    public void setTipoSangre(String tipoSangre) {
        this.tipoSangre = tipoSangre;
    }

    public int getNumeroInformes() {
        return numeroInformes;
    }

    public void setNumeroInformes(int numeroInformes) {
        this.numeroInformes = numeroInformes;
    }

    
    


    
    
    
}
