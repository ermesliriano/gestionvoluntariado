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

public class UsuarioProyectoDAO {

    public void agregarUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
        String sql = "INSERT INTO RelacionBeneficiariosProyectos(id_ben, id_pro, Estado) VALUES(?, ?, ?)";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioProyecto.getBeneficiario().getId());
            pstmt.setInt(2, usuarioProyecto.getProyecto().getId_pro());
            pstmt.setString(3, usuarioProyecto.getEstado());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void editarUsuarioProyecto(UsuarioProyecto usuarioProyecto) {
        String sql = "UPDATE RelacionBeneficiariosProyectos SET id_ben = ?, id_pro = ?, Estado = ? WHERE id_rbp = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, usuarioProyecto.getBeneficiario().getId());
            pstmt.setInt(2, usuarioProyecto.getProyecto().getId_pro());
            pstmt.setString(3, usuarioProyecto.getEstado());
            pstmt.setInt(4, usuarioProyecto.getId_rbp());
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public void eliminarUsuarioProyecto(int id_rbp) {
        String sql = "DELETE FROM RelacionBeneficiariosProyectos WHERE id_rbp = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_rbp);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public UsuarioProyecto buscarUsuarioProyecto(int id_rbp) {
        String sql = "SELECT * FROM RelacionBeneficiariosProyectos WHERE id_rbp = ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_rbp);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return new UsuarioProyecto(
                        new BeneficiarioDAO().buscarBeneficiario(rs.getInt("id_rbp")),
                        new ProyectoDAO().buscarProyecto(rs.getInt("id_pro")),
                        rs.getString("Estado"));
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public List<UsuarioProyecto> filtrarUsuarioProyecto(String estado) {
        List<UsuarioProyecto> listaUsuarioProyecto = new ArrayList<>();
        String sql = "SELECT * FROM RelacionBeneficiariosProyectos WHERE Estado LIKE ?";
        try (Connection conn = ConexionBD.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, "%" + estado + "%");
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                UsuarioProyecto usuarioProyecto = new UsuarioProyecto(
                        new BeneficiarioDAO().buscarBeneficiario(rs.getInt("id_rbp")),
                        new ProyectoDAO().buscarProyecto(rs.getInt("id_pro")),
                        rs.getString("Estado"));
                listaUsuarioProyecto.add(usuarioProyecto);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return listaUsuarioProyecto;
    }
// Método nuevo para comprobar la existencia de un registro en UsuarioProyectoDAO
    public boolean existeRegistro(int id_ben, int id_pro, String estado) {
        String sql = "SELECT * FROM RelacionBeneficiariosProyectos WHERE id_ben = ? AND id_pro = ? AND Estado = ?";
        try (Connection conn = ConexionBD.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, id_ben);
            pstmt.setInt(2, id_pro);
            pstmt.setString(3, estado);
            ResultSet rs = pstmt.executeQuery();
        return rs.next();
    } catch (SQLException e) {
        System.out.println(e.getMessage());
    }
    return false;
    }
}
