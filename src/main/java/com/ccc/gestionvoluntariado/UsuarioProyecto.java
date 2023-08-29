/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariado;

/**
 *
 * @author Ermes
 */
public class UsuarioProyecto {
    private int id_rbp;
    private Beneficiario beneficiario;
    private Proyecto proyecto;
    private String estado;

    public UsuarioProyecto(int id_rbp, Beneficiario ben, Proyecto pro, String estado) {
        this.id_rbp = id_rbp;
        this.beneficiario = ben;
        this.proyecto = pro;
        this.estado = estado;
    }
    
    public UsuarioProyecto(Beneficiario ben, Proyecto pro, String estado) {
        this.beneficiario = ben;
        this.proyecto = pro;
        this.estado = estado;
    }

    // Getters y setters para cada atributo

    public int getId_rbp() {
        return id_rbp;
    }

    public void setId_rbp(int id_rbp) {
        this.id_rbp = id_rbp;
    }

    public Beneficiario getBeneficiario() {
        return beneficiario;
    }

    public void setBeneficiario(Beneficiario beneficiario) {
        this.beneficiario = beneficiario;
    }

    public Proyecto getProyecto() {
        return proyecto;
    }

    public void setProyecto(Proyecto proyecto) {
        this.proyecto = proyecto;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

}

