package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Farmacia implements Serializable{
    private String nome;
    public GestorVendas gestorvendas;
    public ArrayList<Armario> armarios;
    public GestorClientes gestorclientes;

    public Farmacia(String nome, GestorVendas gestorvendas, ArrayList<Armario> armario, GestorClientes gestorclientes) {
        this.nome = nome;
        this.gestorvendas = gestorvendas;
        this.armarios = armario;
        this.gestorclientes = gestorclientes;
    }
    public Farmacia() {
        this.nome = "";
        this.gestorvendas = new GestorVendas();
        this.armarios = new ArrayList<Armario>();
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

    public ArrayList<Armario> getArmarios() {
        return armarios;
    }
}
