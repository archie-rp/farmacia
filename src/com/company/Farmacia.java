package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Farmacia implements Serializable{
    private String nome;
    public GestorVendas gestorvendas;
    public Armario[] armarios;
    public GestorClientes gestorclientes;
    public ArrayList<Medicamento> medicamentos_pendentes;

    public ArrayList<Medicamento> getMedicamentos_pendentes() {
        return medicamentos_pendentes;
    }

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

    public void setMedicamento_pendente(Medicamento medicamento_pendente) {
        if (medicamentos_pendentes ==null) {
            this.medicamentos_pendentes = new ArrayList<Medicamento>();
            this.medicamentos_pendentes.add(medicamento_pendente);
        }else{
            this.medicamentos_pendentes.add(medicamento_pendente);
        }
    }
}
