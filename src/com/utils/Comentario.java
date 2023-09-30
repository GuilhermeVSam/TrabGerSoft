package com.utils;

import java.util.Date;

public class Comentario {
    private String texto;
    private String autor;
    private Date data;

    public Comentario(String texto, String autor) {
        this.texto = texto;
        this.autor = autor;
        this.data = new Date();
    }

    @Override
    public String toString() {
        String aux = "Autor: " + autor + "\n";
        aux += "Data: " + data + "\n";
        aux += "Comentario: " + texto + "\n";

        return aux;
    }
}
