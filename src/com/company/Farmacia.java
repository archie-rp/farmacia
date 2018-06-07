package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Farmacia implements Serializable, Variaveis {
    private String nome;
    public GestorVendas gestorvendas;
    public Armario[] armarios;
    public GestorClientes gestorclientes;
    public ArrayList<Medicamento> medicamentos_pendentes;
    public ArrayList<Medicamento> medicamentosHistorico;
    public Funcionario[] funcionarios;
    public int numero_funcionario;


    public ArrayList<Medicamento> getMedicamentos_pendentes() {
        return medicamentos_pendentes;
    }

    public Farmacia(String nome, GestorVendas gestorvendas, Armario[] armarios, GestorClientes gestorclientes) {
        this.nome = nome;
        this.gestorvendas = gestorvendas;
        this.armarios = new Armario[3];
        this.gestorclientes = gestorclientes;
        this.funcionarios = Variaveis.funcionarios;
    }

    public int getNumero_funcionario() {
        return numero_funcionario;
    }

    public Farmacia() {
        this.nome = "";
        this.gestorvendas = new GestorVendas();
        this.armarios = new Armario[3];
        this.gestorclientes = new GestorClientes();
        this.funcionarios = Variaveis.funcionarios;

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


    public void adicionarMedicamento_pendente(Medicamento medicamento_pendente) {
        if (medicamentos_pendentes == null) {
            this.medicamentos_pendentes = new ArrayList<Medicamento>();
            this.medicamentos_pendentes.add(medicamento_pendente);
        } else {
            this.medicamentos_pendentes.add(medicamento_pendente);
        }
    }


    public void adicionarMedicamentoHistorico(ArrayList<Medicamento> medic) {
        for (Medicamento medic_ : medic) {
            try {

                if (!this.medicamentosHistorico.contains(medic_)) {
                    this.medicamentosHistorico.add(medic_);
                }
            } catch (Exception e) {
                this.medicamentosHistorico = new ArrayList<Medicamento>();
                this.medicamentosHistorico.add(medic_);

                // TODO: handle exception
            }
        }
    }


    public ArrayList<Medicamento> mostrarTodosMedicamentos() {
        ArrayList<Medicamento> medic_historico = new ArrayList<Medicamento>();

        for (int i = 0; i < armarios.length; i++) {
            for (Medicamento m : armarios[i].getTodos()) {
                if (!medic_historico.contains(m)) {
                    medic_historico.add(m);
                }
            }
        }
        return medic_historico;
    }

    public String getFuncionarioNome() {
        return this.funcionarios[getNumero_funcionario()].getNome();
    }

    public void setNumero_funcionario(int numero_funcionario) {
        this.numero_funcionario = numero_funcionario;
    }

    public ArrayList<Medicamento> getMedicamentosHistorico() {
        return medicamentosHistorico;
    }
}
