package com.company;

import java.util.Date;

public class Clientes {
    int id;
    String nome;
    int bi;
    Date dataInscricao;

    public Clientes(int id, String nome, int bi, Date dataInscricao) {
        this.id = id;
        this.nome = nome;
        this.bi = bi;
        this.dataInscricao = dataInscricao;
    }

    public Clientes() {
        this.id = 0;
        this.nome = "";
        this.bi = 0;
        this.dataInscricao = new Date();
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public int getBi() {
        return bi;
    }

    public Date getDataInscricao() {
        return dataInscricao;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setBi(int bi) {
        this.bi = bi;
    }

    public void setDataInscricao(Date dataInscricao) {
        this.dataInscricao = dataInscricao;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("\nNome: " + getNome());
        string.append("\nBI : " + getBi());
        string.append("\nData Inscrição: " + getDataInscricao());

        return string.toString();
    }
}
