package com.forum.Model;

public class Topico {
    private int id;
    private String titulo;
    private String content;
    private String userId;


    public Topico(String titulo, String content, String userId) {
        this.titulo = titulo;
        this.content = content;
        this.userId = userId;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getTitulo() {
        return titulo;
    }


    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public String getUserId() {
        return userId;
    }


    public void setUserId(String userId) {
        this.userId = userId;
    }
public  String toString(){  
    return "Titulo: "+titulo+" Content: "+content+" UserId: "+userId;
}

}
