package com.company;

public class Farmacia {
    private String nome;
    private GestorVendas gestorVendas;
    private Armario armario;

    public Farmacia(String nome, GestorVendas gestorVendas, Armario armario) {
        this.nome = nome;
        this.gestorVendas = gestorVendas;
        this.armario = armario;
    }

    public String getNome() {
        return nome;
    }

    public GestorVendas getGestorVendas() {
        return gestorVendas;
    }

    public Armario getArmario() {
        return armario;
    }
}
