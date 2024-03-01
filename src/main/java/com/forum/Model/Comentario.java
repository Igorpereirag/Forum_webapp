package com.forum.Model;

public class Comentario {
    private int id;
    private String content;
    private String user_id;
    private int idTopico;


    public Comentario(int id, String content, String user_id, int idTopico) {
        this.id = id;
        this.content = content;
        this.user_id = user_id;
        this.idTopico = idTopico;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getContent() {
        return content;
    }


    public void setContent(String content) {
        this.content = content;
    }


    public String getUser_id() {
        return user_id;
    }


    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }


    public int getIdTopico() {
        return idTopico;
    }


    public void setIdTopico(int idTopico) {
        this.idTopico = idTopico;
    }


   
   
}
