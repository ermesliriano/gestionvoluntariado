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

public class VoluntarioDAO {

    public void agregarVoluntario(Voluntario voluntario) {
        String sql = "INSERT INTO voluntarios (Nombre, Apellidos, Titulación) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, voluntario.getNombre());
            pstmt.setString(2, voluntario.getApellidos());
            pstmt.setString(3, voluntario.getTitulacion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    public void agregarVoluntarioCompleto(Voluntario voluntario) {
        String sql = "INSERT INTO voluntarios (Nombre, Apellidos, Titulación, Genero, Localidad) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, voluntario.getNombre());
            pstmt.setString(2, voluntario.getApellidos());
            pstmt.setString(3, voluntario.getTitulacion());
            pstmt.setString(4, voluntario.getGenero());
            pstmt.setString(5, voluntario.getLocalidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarVoluntario(Voluntario voluntario) {
        String sql = "UPDATE voluntarios SET Nombre = ?, Apellidos = ?, Titulación = ?, Genero = ?, Localidad = ? WHERE id_vol = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, voluntario.getNombre());
            pstmt.setString(2, voluntario.getApellidos());
            pstmt.setString(3, voluntario.getTitulacion());
            pstmt.setString(4, voluntario.getGenero());
            pstmt.setString(5, voluntario.getLocalidad());
            pstmt.setInt(6, voluntario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarVoluntario(int id_vol) {
        String sql = "DELETE FROM voluntarios WHERE id_vol = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_vol);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Voluntario buscarVoluntario(int id_vol) {
        String sql = "SELECT * FROM voluntarios WHERE id_vol = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_vol);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Voluntario voluntario = new Voluntario(
                        rs.getInt("id_vol"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Titulación"),
                        rs.getString("Género"),
                        rs.getString("Localidad"));
                return voluntario;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Voluntario> filtrarVoluntarios(String[] filtro) {
    List<Voluntario> listaVoluntarios = new ArrayList<>();
    StringBuilder sql = new StringBuilder("SELECT * FROM voluntarios WHERE ");

    // Asegurarse de que no haya espacios vacíos y agregar a la consulta SQL.
    boolean first = true;
    int paramCount = 1;
    if (filtro.length > 0 && filtro[0] != null && !filtro[0].isEmpty()) {
        sql.append("Nombre LIKE ? ");
        first = false;
        paramCount++;
    }
    if (filtro.length > 1 && filtro[1] != null && !filtro[1].isEmpty()) {
        if (!first) {
            sql.append("OR ");
        }
        sql.append("Apellidos LIKE ? ");
        first = false;
        paramCount++;
    }
    if (filtro.length > 2 && filtro[2] != null && !filtro[2].isEmpty()) {
        if (!first) {
            sql.append("OR ");
        }
        sql.append("Titulación LIKE ? ");
    }

    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql.toString())) {
        paramCount = 1;
        if (filtro.length > 0 && filtro[0] != null && !filtro[0].isEmpty()) {
            pstmt.setString(paramCount, "%" + filtro[0] + "%");
            paramCount++;
        }
        if (filtro.length > 1 && filtro[1] != null && !filtro[1].isEmpty()) {
            pstmt.setString(paramCount, "%" + filtro[1] + "%");
            paramCount++;
        }
        if (filtro.length > 2 && filtro[2] != null && !filtro[2].isEmpty()) {
            pstmt.setString(paramCount, "%" + filtro[2] + "%");
        }

        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Voluntario voluntario = new Voluntario(
                    rs.getInt("id_vol"),
                    rs.getString("Nombre"),
                    rs.getString("Apellidos"),
                    rs.getString("Titulación"),
                    rs.getString("Genero"),
                    rs.getString("Localidad"));
                    listaVoluntarios.add(voluntario);
                    }
    } catch (SQLException e) {
    System.out.println(e.getMessage());
    }
    return listaVoluntarios;
    }
}    