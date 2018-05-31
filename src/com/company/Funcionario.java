package com.company;

public class Funcionario {
    private String nome;


    public Funcionario(String nome) {
        this.nome = nome;
    }

    public Funcionario() {
        this.nome = "";
    }

    @Override
    public String toString() {
       StringBuilder string=new StringBuilder();
       string.append(nome);

       return string.toString();

    }
}
