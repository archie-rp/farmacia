package com.company;

public class Farmacia {
    private String nome;
    public GestorVendas gestorvendas;
    public Armario armario;

    public Farmacia(String nome, GestorVendas gestorVendas, Armario armario) {
        this.nome = nome;
        this.gestorvendas = gestorVendas;
        this.armario = armario;
    }

    public String getNome() {
        return nome;
    }

    public GestorVendas getGestorVendas() {
        return gestorvendas;
    }

    public Armario getArmario() {
        return armario;
    }
}
