/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariado;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ProyectoDAO {

    public void agregarProyecto(Proyecto proyecto) {
        String sql = "INSERT INTO proyectos (Nombre, AnnoEjecucion, NumPlazas) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, proyecto.getNombre());
            pstmt.setInt(2, proyecto.getAnoEjecucion());
            pstmt.setInt(3, proyecto.getNumPlazas());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarProyecto(Proyecto proyecto) {
        String sql = "UPDATE proyectos SET Nombre = ?, AnioEjecucion = ?, NumPlazas = ? WHERE id_pro = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, proyecto.getNombre());
            pstmt.setInt(2, proyecto.getAnoEjecucion());
            pstmt.setInt(3, proyecto.getNumPlazas());
            pstmt.setInt(4, proyecto.getId_pro());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarProyecto(int id_pro) {
        String sql = "DELETE FROM proyectos WHERE id_pro = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_pro);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Proyecto buscarProyecto(int id_pro) {
        String sql = "SELECT * FROM proyectos WHERE id_pro = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_pro);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Proyecto proyecto = new Proyecto(
                        rs.getInt("id_pro"),
                        rs.getString("Nombre"),
                        rs.getInt("AnnoEjecucion"),
                        rs.getInt("NumPlazas"));
                return proyecto;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Proyecto> filtrarProyectos(String filtro) {
        List<Proyecto> listaProyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyectos WHERE Nombre LIKE ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + filtro + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Proyecto proyecto = new Proyecto(
                        rs.getInt("id_pro"),
                        rs.getString("Nombre"),
                        rs.getInt("AnioEjecucion"),
                        rs.getInt("NumPlazas"));
                listaProyectos.add(proyecto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaProyectos;
    }
    
    public List<Proyecto> obtenerTodos() {
        List<Proyecto> proyectos = new ArrayList<>();
        String sql = "SELECT * FROM proyectos";
        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery()) {
        while (rs.next()) {
            Proyecto proyecto = new Proyecto(
                    rs.getString("Nombre"),
                    Integer.parseInt(rs.getString("AnnoEjecucion")),
                    Integer.parseInt(rs.getString("NumPlazas")));
            proyectos.add(proyecto);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return proyectos;
}
}
