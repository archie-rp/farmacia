package com.company;

import java.io.Serializable;

public class Farmacia implements Serializable{
    private String nome;
    public GestorVendas gestorvendas;
    public Armario[] armarios;
    public GestorClientes gestorclientes;

    public Farmacia(String nome, GestorVendas gestorvendas, Armario[] armarios, GestorClientes gestorclientes) {
        this.nome = nome;
        this.gestorvendas = gestorvendas;
         this.armarios = new Armario[3];
        this.gestorclientes = gestorclientes;
    }
    public Farmacia() {
        this.nome = "";
        this.gestorvendas = new GestorVendas();
        this.armarios = new Armario[3];
        this.gestorclientes = new GestorClientes();
    }

    public GestorVendas getGestorvendas() {
        return gestorvendas;
    }

    public GestorClientes getGestorclientes() {
        return gestorclientes;
    }

    public String getNome() {
        return nome;
    }

    public GestorVendas getGestorVendas() {
        return gestorvendas;
    }

    public Armario[] getArmarios() {
        return armarios;
    }
}
