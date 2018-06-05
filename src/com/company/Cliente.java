package com.company;

import java.io.Serializable;
import java.util.Date;


public class Cliente implements Serializable {
    int id;
    String nome;
    int bi;
    Date dataInscricao;

    public Cliente(int id, String nome, int bi, Date dataInscricao) {
        this.id = id;
        this.nome = nome;
        this.bi = bi;
        this.dataInscricao = dataInscricao;
    }


    public Cliente() {
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
        string.append(getId() + " ");
        string.append(getNome() + " ");
        string.append(getBi() + " ");
       // string.append(getDataInscricao() + " ");

        return string.toString();
    }
}
