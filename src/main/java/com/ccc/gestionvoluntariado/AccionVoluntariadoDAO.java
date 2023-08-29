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

public class AccionVoluntariadoDAO {

    public void agregarAccionVoluntariado(AccionVoluntariado accionVoluntariado) {
        String sql = "INSERT INTO AccionVoluntariado (Fecha, Participantes, Area, TipoAccion, Duración) VALUES (?, ?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, accionVoluntariado.getFecha());
            pstmt.setInt(2, accionVoluntariado.getParticipantes().getId());
            pstmt.setString(3, accionVoluntariado.getArea());
            pstmt.setString(4, accionVoluntariado.getTipoAccion());
            pstmt.setInt(5, accionVoluntariado.getDuracion());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarAccionVoluntariado(AccionVoluntariado accionVoluntariado) {
        String sql = "UPDATE AccionVoluntariado SET Fecha = ?, Participantes = ?, Area = ?, TipoAccion = ?, Duracion = ? WHERE id_adv = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setDate(1, accionVoluntariado.getFecha());
            pstmt.setInt(2, accionVoluntariado.getParticipantes().getId());
            pstmt.setString(3, accionVoluntariado.getArea());
            pstmt.setString(4, accionVoluntariado.getTipoAccion());
            pstmt.setInt(5, accionVoluntariado.getDuracion());
            pstmt.setInt(6, accionVoluntariado.getId_adv());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarAccionVoluntariado(int id_adv) {
        String sql = "DELETE FROM AccionVoluntariado WHERE id_adv = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_adv);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public AccionVoluntariado buscarAccionVoluntariado(int id_adv) {
        String sql = "SELECT * FROM AccionVoluntariado WHERE id_adv = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_adv);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Persona participante = getPersona(rs.getInt("Participantes"));
                return new AccionVoluntariado(
                        rs.getInt("id_adv"),
                        rs.getDate("Fecha"),
                        participante,
                        rs.getString("Area"),
                        rs.getString("TipoAccion"),
                        rs.getInt("Duracion"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<AccionVoluntariado> filtrarAccionesVoluntariado(String filtro) {
        List<AccionVoluntariado> listaAccionesVoluntariado = new ArrayList<>();
        String sql = "SELECT * FROM AccionVoluntariado WHERE Area LIKE ? OR TipoAccion LIKE ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + filtro + "%");
            pstmt.setString(2, "%" + filtro + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                Persona participante = getPersona(rs.getInt("Participantes"));
                AccionVoluntariado accionVoluntariado;
                accionVoluntariado = new AccionVoluntariado(
                        rs.getInt("id_adv"),
                        rs.getDate("Fecha"),
                        participante,
                        rs.getString("Area"),
                        rs.getString("TipoAccion"),
                        rs.getInt("Duracion"));
                listaAccionesVoluntariado.add(accionVoluntariado);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaAccionesVoluntariado;
    }

    Persona getPersona(int id) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

}
