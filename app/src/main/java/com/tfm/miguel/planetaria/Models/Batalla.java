package com.tfm.miguel.planetaria.Models;

import java.util.ArrayList;

/**
 * Created by miguelfernandezvillegas on 29/6/17.
 */

public class Batalla {

    private String dni1;
    private String dni2;
    private int puntuacion1;
    private int puntuacion2;
    private ArrayList<Pregunta> preguntas;
    private float recompensa;
    boolean recompensaUsada = false;
    private int nPreguntas;
    private String fechaInicio;
    private String fechaFin;
    private boolean activado = false;
    private String tiempoFin1;
    private String tiempoFin2;


}
