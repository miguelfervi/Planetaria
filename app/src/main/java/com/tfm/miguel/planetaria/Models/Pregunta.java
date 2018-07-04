package com.tfm.miguel.planetaria.Models;

/**
 * Created by miguelfernandezvillegas on 7/7/17.
 */

public class Pregunta {

    public String pregunta;
    public Boolean respuesta1;
    public Boolean respuesta2;
    public Boolean respuesta3;

    public Pregunta (){}
    public Pregunta(String pregunta, Boolean respuesta1, Boolean respuesta2, Boolean respuesta3){
        this.pregunta = pregunta;
        this.respuesta1 = respuesta1;
        this.respuesta2 = respuesta2;
        this.respuesta3 = respuesta3;
    }
}
