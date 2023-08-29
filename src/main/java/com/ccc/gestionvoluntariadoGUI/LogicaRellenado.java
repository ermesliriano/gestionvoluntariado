/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ccc.gestionvoluntariadoGUI;

import com.ccc.gestionvoluntariado.ConexionBD;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Ermes
 */
public class LogicaRellenado {
  
    public DefaultTableModel mostrarContenidoTabla(String[] nomCol,int numCol, String tab)
    {
        var registros = new String[numCol];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nomCol);
        
        String sql = "SELECT * FROM "+tab;
        
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            cn = ConexionBD.getConnection();
            pst = cn.prepareStatement(sql);                        
            rs = pst.executeQuery();
            
            while(rs.next()){
                registros[0] = rs.getString(nomCol[0]);
                registros[1] = rs.getString(nomCol[1]);
                registros[2] = rs.getString(nomCol[2]);
                modelo.addRow(registros);
            }
        }
        catch(SQLException e)
        {            
            JOptionPane.showMessageDialog(null,"Error al conectar: "+e.getMessage());
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
    public DefaultTableModel mostrarContenidoTablaAcc(String[] nomCol,int numCol, String tab)
    {
        var registros = new String[numCol];
        
        DefaultTableModel modelo = new DefaultTableModel(null,nomCol);
        
        String sql = "SELECT * FROM "+tab;
        
        Connection cn = null;
        PreparedStatement pst = null;
        ResultSet rs = null;
        
        try
        {
            cn = ConexionBD.getConnection();
            pst = cn.prepareStatement(sql);                        
            rs = pst.executeQuery();
            
            while(rs.next()){
                registros[0] = long2Fecha(rs.getString(nomCol[0]));
                registros[1] = rs.getString(nomCol[1]);
                registros[2] = rs.getString(nomCol[2]);
                modelo.addRow(registros);
            }
        }
        catch(SQLException e)
        {            
            JOptionPane.showMessageDialog(null,"Error al conectar: "+e.getMessage());
        }
        finally
        {
            try
            {
                if (rs != null) rs.close();
                if (pst != null) pst.close();
                if (cn != null) cn.close();
            }
            catch(SQLException e)
            {
                JOptionPane.showMessageDialog(null,e);
            }
        }
         return modelo;
    }
    
    private String long2Fecha(String fecha){
        
        long num = Long.parseLong(fecha);
        Date date = new Date(num);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(date);
    }
    
 }