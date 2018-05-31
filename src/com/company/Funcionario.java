package com.company;

public class Funcionario {
    private String nome;
    private String password;

    public Funcionario(String nome) {
        this.nome = nome;
        this.password = nome;
    }

    public Funcionario() {
        this.nome = "";
        this.password = "";
    }

    @Override
    public String toString() {
       StringBuilder string=new StringBuilder();
       string.append(nome);
       return string.toString();
    }
}
