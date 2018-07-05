package com.tfm.miguel.planetaria.Models;

/**
 * Created by miguelfernandezvillegas on 7/7/17.
 */

public class Pregunta {

    public String pregunta;
    public String respuesta1;
    public String respuesta2;
    public String respuesta3;
    public String correcta;

    public Pregunta (){}
    public Pregunta(String pregunta, String respuesta1, String respuesta2, String respuesta3,String correcta){
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
        this.correcta = correcta;
    }
}
