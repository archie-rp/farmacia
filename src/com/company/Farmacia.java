package com.company;

import java.io.Serializable;

public class Farmacia {
    private String nome;
    public GestorVendas gestorvendas;
    public Armario armario;
    public GestorClientes gestorclientes;

    public Farmacia(String nome, GestorVendas gestorvendas, Armario armario, GestorClientes gestorclientes) {
        this.nome = nome;
        this.gestorvendas = gestorvendas;
        this.armario = armario;
        this.gestorclientes = gestorclientes;
    }
    public Farmacia() {
        this.nome = "";
        this.gestorvendas = new GestorVendas();
        this.armario = new Armario();
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

    public Armario getArmario() {
        return armario;
    }
}
