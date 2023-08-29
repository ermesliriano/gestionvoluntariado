/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariado;

/**
 *
 * @author Ermes
 */
public class Proyecto {
    private int id_pro;
    private String nombre;
    private int anoEjecucion;
    private int numPlazas;

    public Proyecto(int id_pro, String nombre, int anoEjecucion, int numPlazas) {
        this.id_pro = id_pro;
        this.nombre = nombre;
        this.anoEjecucion = anoEjecucion;
        this.numPlazas = numPlazas;
    }

    public Proyecto(String nombre, int anoEjecucion, int numPlazas) {
        this.nombre = nombre;
        this.anoEjecucion = anoEjecucion;
        this.numPlazas = numPlazas;
    }
    
    // Getters y setters para cada atributo

    public int getId_pro() {
        return id_pro;
    }

    public void setId_pro(int id_pro) {
        this.id_pro = id_pro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getAnoEjecucion() {
        return anoEjecucion;
    }

    public void setAnoEjecucion(int anoEjecucion) {
        this.anoEjecucion = anoEjecucion;
    }

    public int getNumPlazas() {
        return numPlazas;
    }

    public void setNumPlazas(int numPlazas) {
        this.numPlazas = numPlazas;
    }
    @Override
    public String toString() {
        return this.getNombre();
    }   
}