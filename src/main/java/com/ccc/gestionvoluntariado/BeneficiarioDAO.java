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

public class BeneficiarioDAO {

    public void agregarBeneficiario(Beneficiario beneficiario) {
        String sql = "INSERT INTO beneficiarios (Nombre, Apellidos, Nacionalidad) VALUES (?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, beneficiario.getNombre());
            pstmt.setString(2, beneficiario.getApellidos());
            pstmt.setString(3, beneficiario.getNacionalidad());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
    
    public void agregarBeneficiarioCompleto(Beneficiario beneficiario) {
        String sql = "INSERT INTO beneficiarios (Nombre, Apellidos, Nacionalidad, Genero) VALUES (?, ?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, beneficiario.getNombre());
            pstmt.setString(2, beneficiario.getApellidos());
            pstmt.setString(3, beneficiario.getNacionalidad());
            pstmt.setString(4, beneficiario.getGenero());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarBeneficiario(Beneficiario beneficiario) {
        String sql = "UPDATE beneficiarios SET Nombre = ?, Apellidos = ?, Nacionalidad = ?, Genero = ? WHERE id_ben = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, beneficiario.getNombre());
            pstmt.setString(2, beneficiario.getApellidos());
            pstmt.setString(3, beneficiario.getNacionalidad());
            pstmt.setString(4, beneficiario.getGenero());
            pstmt.setInt(5, beneficiario.getId());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarBeneficiario(int id_ben) {
        String sql = "DELETE FROM beneficiarios WHERE id_ben = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_ben);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public Beneficiario buscarBeneficiario(int id_ben) {
        String sql = "SELECT * FROM beneficiarios WHERE id_ben = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_ben);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                Beneficiario beneficiario = new Beneficiario(
                        rs.getInt("id_ben"),
                        rs.getString("Nombre"),
                        rs.getString("Apellidos"),
                        rs.getString("Nacionalidad"),
                        rs.getString("Genero"));
                return beneficiario;
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<Beneficiario> filtrarBeneficiarios(String filtro) {
    List<Beneficiario> listaBeneficiarios = new ArrayList<>();
    String sql = "SELECT * FROM beneficiarios WHERE Nombre LIKE ? OR Apellidos LIKE ? OR Nacionalidad LIKE ?";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
        pstmt.setString(1, "%" + filtro + "%");
        pstmt.setString(2, "%" + filtro + "%");
        pstmt.setString(3, "%" + filtro + "%");
        ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Beneficiario beneficiario = new Beneficiario(
                    rs.getInt("id_ben"),
                    rs.getString("Nombre"),
                    rs.getString("Apellidos"),
                    rs.getString("Nacionalidad"),
                    rs.getString("Genero"));
            listaBeneficiarios.add(beneficiario);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return listaBeneficiarios;
    }
    
    public List<Beneficiario> obtenerTodos() {
    List<Beneficiario> beneficiarios = new ArrayList<>();
    String sql = "SELECT * FROM beneficiarios";
    try (Connection conn = ConexionBD.getConnection();
         PreparedStatement pstmt = conn.prepareStatement(sql)) {
         ResultSet rs = pstmt.executeQuery();
        while (rs.next()) {
            Beneficiario beneficiario = new Beneficiario(
                    //rs.getInt("id_ben"),
                    rs.getString("Nombre"),
                    rs.getString("Apellidos"),
                    rs.getString("Nacionalidad"));
                    //rs.getString("Genero"),
                    //rs.getString("Localidad"));
            beneficiarios.add(beneficiario);
        }
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return beneficiarios;
    }
}