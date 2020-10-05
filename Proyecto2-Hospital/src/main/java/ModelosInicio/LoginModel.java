/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModelosInicio;

import ConexionDB.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 *
 * @author joel
 */
public class LoginModel {
    
    private Connection conexion = Conexion.getConexion();
    
    public String devolverTipoPersona(String codigo){
        if (Character.isDigit(codigo.charAt(0))) {
            return "Paciente";
        }
        else if (codigo.substring(0, 3).equals("MED")) {
            return "Paciente";
        }
        else if (codigo.substring(0, 3).equals("LAB")) {
            return "Paciente";
        }
        else if (codigo.substring(0, 3).equals("ADM")) {
            return "Admin";
        }
        return "";
    }
    
    public boolean loginPacienteValido(int codigo, String contraseña){
        String query = "SELECT COUNT(*) FROM PACIENTE WHERE codigo=? AND password = ?";
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setInt(1, codigo);
            ps.setString(2, contraseña);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    if (rs.getInt(1)==1) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean loginMedicoValido(String codigo, String contraseña){
        String query = "SELECT COUNT(*) FROM MEDICO WHERE codigo=? AND password = ?";
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    if (rs.getInt(1)==1) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean loginLabValido(String codigo, String contraseña){
        String query = "SELECT COUNT(*) FROM LABORATORISTA WHERE codigo=? AND password = ?";
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    if (rs.getInt(1)==1) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
    
    public boolean loginAdminValido(String codigo, String contraseña){
        String query = "SELECT COUNT(*) FROM ADMINISTRADOR WHERE codigo=? AND password = ?";
        try(PreparedStatement ps = conexion.prepareStatement(query)) {
            ps.setString(1, codigo);
            ps.setString(2, contraseña);
            
            try(ResultSet rs = ps.executeQuery()){
                if (rs.next()) {
                    if (rs.getInt(1)==1) {
                        return true;
                    }
                }
            }
        } catch (Exception e) {
        }
        return false;
    }
}
