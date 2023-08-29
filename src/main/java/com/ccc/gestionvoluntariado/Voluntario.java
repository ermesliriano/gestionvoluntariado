/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.ccc.gestionvoluntariado;

/**
 *
 * @author Ermes
 */
public class Voluntario extends Persona {
    //private int id;
    private String nombre;
    private String apellidos;
    private String titulacion;
    private String genero;
    private String localidad;

    public Voluntario(int id, String nombre, String apellidos, String titulacion, String genero, String localidad) {
        this.id = id;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.titulacion = titulacion;
        this.genero = genero;
        this.localidad = localidad;
    }

    public Voluntario(String nombre, String apellidos, String titulacion) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.titulacion = titulacion;
    }

    // Getters y setters para cada atributo

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getTitulacion() {
        return titulacion;
    }

    public void setTitulacion(String titulacion) {
        this.titulacion = titulacion;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }
    
}