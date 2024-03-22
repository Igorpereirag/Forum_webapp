package com.forum.Model;

public class Ranking {

    private Usuario usuario;
    private int pontuacao;
    private int posicao;

    public Ranking(Usuario usuario, int pontuacao, int posicao) {
        this.usuario = usuario;
        this.pontuacao = pontuacao;
        this.posicao = posicao;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    public int getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(int pontuacao) {
        this.pontuacao = pontuacao;
    }

    public int getPosicao() {
        return posicao;
    }

    public void setPosicao(int posicao) {
        this.posicao = posicao;
    }

    @Override
    public String toString() {
        return "Ranking [usuario=" + usuario + ", pontuacao=" + pontuacao + ", posicao=" + posicao + "]";
    }
}
