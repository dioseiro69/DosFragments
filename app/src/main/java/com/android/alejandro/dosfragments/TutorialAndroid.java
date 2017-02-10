package com.android.alejandro.dosfragments;

/**
 * Created by alejandro on 2/02/17.
 */

public class TutorialAndroid {


    private String titulo;
    private String enlaceContenido;

    public TutorialAndroid( String titulo, String enlaceContenido) {

        this.titulo = titulo;
        this.enlaceContenido = enlaceContenido;
    }



    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getEnlaceContenido() {
        return enlaceContenido;
    }

    public void setEnlaceContenido(String enlaceContenido) {
        this.enlaceContenido = enlaceContenido;
    }
}
