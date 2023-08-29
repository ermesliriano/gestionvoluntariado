/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariado;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
/**
 * @author Ermes
 */
public class ConexionBD {
    public static Connection getConnection(){
        final String URL= "jdbc:sqlite::resource:gestionvoluntariado.db";
        Connection conexion = null;
        
        try {
            conexion = DriverManager.getConnection(URL);
        } catch(SQLException e) {
            e.printStackTrace();
        }
        return conexion;   
    }   
}