package com.tfm.miguel.planetaria.Models;

import java.util.ArrayList;

/**
 * Created by miguelfernandezvillegas on 29/6/17.
 */

public class Explorador {

    private String nombre;
    private String apellidos;
    private String dni;
    private int vidas;
    private int nRecompensas;
    private int experiencia;
    private int clasificacion;
    private ArrayList<Notas> notas;
    private ArrayList<Recompensas> recompensas;


    public Explorador(){

    }

    public Explorador(String nombre, String apellidos, String dni, int vidas, int nRecompensas,
                      int experiencia, int clasificacion, ArrayList<Notas> notas, ArrayList<Recompensas> recompensas){
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.dni = dni;
        this.vidas = vidas;


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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public int getVidas() {
        return vidas;
    }

    public void setVidas(int vidas) {
        this.vidas = vidas;
    }

    public int getnRecompensas() {
        return nRecompensas;
    }

    public void setnRecompensas(int nRecompensas) {
        this.nRecompensas = nRecompensas;
    }

    public int getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(int experiencia) {
        this.experiencia = experiencia;
    }

    public int getClasificacion() {
        return clasificacion;
    }

    public void setClasificacion(int clasificacion) {
        this.clasificacion = clasificacion;
    }

    public ArrayList<Notas> getNotas() {
        return notas;
    }

    public void setNotas(ArrayList<Notas> notas) {
        this.notas = notas;
    }

    public ArrayList<Recompensas> getRecompensas() {
        return recompensas;
    }

    public void setRecompensas(ArrayList<Recompensas> recompensas) {
        this.recompensas = recompensas;
    }





}
