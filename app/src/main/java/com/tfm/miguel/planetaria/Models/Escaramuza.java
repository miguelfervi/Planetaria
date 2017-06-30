package com.tfm.miguel.planetaria.Models;

/**
 * Created by miguelfernandezvillegas on 29/6/17.
 */

public class Escaramuza {

    private int codigo;
    private String titulo;
    private String descripcion;
    private boolean entregado;
    private boolean aceptado;

    public Escaramuza(){}

    public Escaramuza(int codigo, String titulo, String descripcion, boolean entregado, boolean aceptado) {
        this.codigo = codigo;
        this.titulo = titulo;
        this.descripcion = descripcion;
        this.entregado = entregado;
        this.aceptado = aceptado;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public boolean isEntregado() {
        return entregado;
    }

    public void setEntregado(boolean entregado) {
        this.entregado = entregado;
    }

    public boolean isAceptado() {
        return aceptado;
    }

    public void setAceptado(boolean aceptado) {
        this.aceptado = aceptado;
    }

}
