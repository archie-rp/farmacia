package com.company;


import java.io.Serializable;

public class Armario implements Serializable {
    private static final long serialVersionUID = 1L;
    private Gaveta armario[][];
    private String nome;
    private int quantidade;

    public Armario() {
        this.armario = new Gaveta[20][10];
        this.nome = "";
        this.quantidade = 0;
    }

    public Armario(Object readObject) {
        // TODO Auto-generated constructor stub
    }

    public Gaveta[][] getArmario() {
        return armario;
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
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()].setMedicamento(medicamento);
            this.quantidade++;
        } else {
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()].setMedicamento(medicamento);
            this.quantidade++;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null) {
                    string.append(armario[i][j].toString());
                }
            }
        }
        return string.toString();
    }

    public int getQuantidadGaveta(int cat, int via) {
        return armario[cat][via].getQuantidade();
    }

    public boolean removerMedicamento(String nome) {
        int back_quantidade= this.quantidade;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null && armario[i][j].removerMedicamento(nome)) {
                    this.quantidade--;
                }
            }
        }
        if (back_quantidade > this.quantidade){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean atualizarMedicamento(String nome, Medicamento novo_med) {
        int med_actualizados= 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null && armario[i][j].updateMedicamento(nome, novo_med)) {
                    med_actualizados++;
                }
            }
        }
        if (med_actualizados > 0){
            return true;
        }
        else{
            return false;
        }
    }
}