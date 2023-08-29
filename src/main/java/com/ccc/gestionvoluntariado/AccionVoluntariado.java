/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariado;

import java.sql.Date;

/**
 *
 * @author Ermes
 */
public class AccionVoluntariado {
    private int id_adv;
    private Date fecha;
    private Persona participantes;
    private String area;
    private String tipoAccion;
    private int duracion;

    public AccionVoluntariado(Date fecha, Persona participantes, String area) {
        this.fecha = fecha;
        this.participantes = participantes;
        this.area = area;
    }

    
    public AccionVoluntariado(int id_adv, Date fecha, Persona participantes, String area, String tipoAccion, int duracion) {
        this.id_adv = id_adv;
        this.fecha = fecha;
        this.participantes = participantes;
        this.area = area;
        this.tipoAccion = tipoAccion;
        this.duracion = duracion;
    }

    // Getters y setters para cada atributo

    public int getId_adv() {
        return id_adv;
    }

    public void setId_adv(int id_adv) {
        this.id_adv = id_adv;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Persona getParticipantes() {
        return participantes;
    }

    public void setParticipantes(Persona participantes) {
        this.participantes = participantes;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public String getTipoAccion() {
        return tipoAccion;
    }

    public void setTipoAccion(String tipoAccion) {
        this.tipoAccion = tipoAccion;
    }

    public int getDuracion() {
        return duracion;
    }

    public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
    
}

