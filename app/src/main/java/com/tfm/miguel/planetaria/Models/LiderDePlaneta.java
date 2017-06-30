package com.tfm.miguel.planetaria.Models;

/**
 * Created by miguelfernandezvillegas on 29/6/17.
 */

public class LiderDePlaneta {

    private String dni;
    private String nombre;
    private String planeta;


    public LiderDePlaneta(){}
    public LiderDePlaneta(String dni, String nombre, String planeta) {
        this.dni = dni;
        this.nombre = nombre;
        this.planeta = planeta;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPlaneta() {
        return planeta;
    }

    public void setPlaneta(String planeta) {
        this.planeta = planeta;
    }
}
