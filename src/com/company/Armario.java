package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Armario implements Serializable {
    private Gaveta armario[][];
    private String nome;
    private int quantidade;

    public Armario() {
        this.armario = new Gaveta[20][10];
        this.nome = "";
        this.quantidade = 0;
    }


    public ArrayList<Medicamento> getTodos() {
        ArrayList<Medicamento> medic = new ArrayList<Medicamento>();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {

                try {
                    if (armario[i][j].getMedicamentos().isEmpty() ) {

                    } else {

                        medic.addAll(armario[i][j].getMedicamentos());
                    }

                } catch (NullPointerException e) {
                    //Se o medic for nulo não fazer nada
                   // System.out.println(e);
                    //break;

                }

            }
        }

        return medic;
    }

    public Gaveta getArmarioGaveta(int cat, int via) {
        return armario[cat][via];
    }

    public int getMedicamentoQuantidade(Medicamento medicamento) {
        int total = 0;

        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {

                try {
                    int medic = armario[i][j].getMedicamentoQuantidade(medicamento);
                    if (medic > 0) {
                        total += medic;
                    }
                } catch (Exception e) {

                }

            }
        }
        return total;
    }

    public void setArmario(Gaveta[][] armario) {
        this.armario = armario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void adicionarMedicamento(Medicamento medicamento) {
        if (armario[medicamento.getCategoria()][medicamento.getViaAdmin()] == null) {
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()] = new Gaveta();
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.add(medicamento);
            this.quantidade++;
        } else {
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.add(medicamento);
            this.quantidade++;
        }
    }

    public void adicionarMedicamentos(Medicamento[] medicamentos) {
        for (Medicamento medicamento : medicamentos) {
            if (armario[medicamento.getCategoria()][medicamento.getViaAdmin()] == null) {
                armario[medicamento.getCategoria()][medicamento.getViaAdmin()] = new Gaveta();
                armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.add(medicamento);
                this.quantidade++;
            } else {
                armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.add(medicamento);
                this.quantidade++;
            }
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null) {
                    string.append("\n" + armario[i][j].getMedicamentos());
                }
            }
        }
        return string.toString();
    }

    public int getQuantidadGaveta(int cat, int via) {
        return armario[cat][via].getQuantidade();
    }

    public boolean removerMedicamento(Medicamento medic) {
        int back_quantidade = this.quantidade;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null && armario[i][j].removerMedicamento(medic.getNome().toString())) {
                    this.quantidade--;
                }
            }
        }
        if (back_quantidade > this.quantidade) {
            return true;
        } else {
            return false;
        }
    }

    public boolean atualizarMedicamento(String nome, Medicamento novo_med) {
        int med_actualizados = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null && armario[i][j].updateMedicamento(nome, novo_med)) {
                    med_actualizados++;
                }
            }
        }
        if (med_actualizados > 0) {
            return true;
        } else {
            return false;
        }
    }
}