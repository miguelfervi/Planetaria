package com.tfm.miguel.planetaria.Models;

import java.util.ArrayList;

/**
 * Created by miguelfernandezvillegas on 29/6/17.
 */

public class Planeta {

    private int codigo;
    private String nombre;
    private String descripcion;
    private int nTareas;
    private String profesor;
    private ArrayList<Explorador> exploradores;
    private ArrayList<Escaramuza> escaramuzas;

    public Planeta(){}

    public Planeta(int codigo, String nombre, String descripcion, int nTareas, String profesor, ArrayList<Explorador> exploradores, ArrayList<Escaramuza> escaramuzas) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.nTareas = nTareas;
        this.profesor = profesor;
        this.exploradores = exploradores;
        this.escaramuzas = escaramuzas;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getnTareas() {
        return nTareas;
    }

    public void setnTareas(int nTareas) {
        this.nTareas = nTareas;
    }

    public String getProfesor() {
        return profesor;
    }

    public void setProfesor(String profesor) {
        this.profesor = profesor;
    }

    public ArrayList<Explorador> getExploradores() {
        return exploradores;
    }

    public void setExploradores(ArrayList<Explorador> exploradores) {
        this.exploradores = exploradores;
    }

    public ArrayList<Escaramuza> getEscaramuzas() {
        return escaramuzas;
    }

    public void setEscaramuzas(ArrayList<Escaramuza> escaramuzas) {
        this.escaramuzas = escaramuzas;
    }
}
