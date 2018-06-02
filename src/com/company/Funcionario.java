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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
