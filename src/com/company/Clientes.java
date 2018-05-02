package com.company;

import java.util.Date;

public class Clientes {
    String nome;
    Character sexo;
    Date dataNascimento;


    public Clientes(String nome, Character sexo, Date dataNascimento) {
        this.nome = nome;
        this.sexo = sexo;
        this.dataNascimento = dataNascimento;
    }

    public Clientes() {
        this.nome = "";
        this.sexo = 'm';
        this.dataNascimento = new Date();
    }

    public String getNome() {
        return nome;
    }

    public Character getSexo() {
        return sexo;
    }

    public Date getDataNascimento() {
        return dataNascimento;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setSexo(Character sexo) {
        this.sexo = sexo;
    }

    public void setDataNascimento(Date dataNascimento) {
        this.dataNascimento = dataNascimento;
    }


    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();

        string.append("\nNome: " + getNome());
        string.append("\nSexo: " + getSexo());
        string.append("\nData Nascimento: " + getDataNascimento());

        return string.toString();
    }
}
