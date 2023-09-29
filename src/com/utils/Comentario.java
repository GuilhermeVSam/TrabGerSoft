package com.utils;
import java.util.Date;

public class Comentario {
    private String texto;
    private String autor;
    private Date data;

    public Comentario (String texto, String autor) {
      this.texto = texto;
      this.autor = autor;
      this.data = new Date (29/9/2023);
    }

      public String getTexto() {
          return texto;
      }
      public String getAutor() {
          return autor;
      }
      public Date getData()  {
          return data;
      }
   
      public void exibirComentario() {  
      System.out.println("Autor:"+ autor);  
      System.out.println("Data:" + data);  
      System.out.println("Comentario:" + texto);
       }
  
      }

