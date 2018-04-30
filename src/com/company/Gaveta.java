package com.company;

import java.util.Arrays;

public class Gaveta {
    Medicamento medicamentos[];
    private int quantidade=0;

    public Gaveta() {
        this.medicamentos = new Medicamento[10];
        this.quantidade = 0;
    }

    public Gaveta(Medicamento medicamento, String via_admin) {
        this.medicamentos[this.quantidade] = medicamento;
        this.quantidade++;
    }


    public int getQuantidade() {
        return this.quantidade;
    }

    public void setQuantidade() {
        this.quantidade = quantidade;
    }

    public Medicamento[] getMedicamentos() {
        return medicamentos;
    }

    public void setMedicamento(Medicamento medicamentos) {
        this.medicamentos[this.quantidade] = medicamentos;
        this.quantidade++;
    }
    public boolean removerMedicamento(String nome){
        for (int i=0; i < medicamentos.length;i++){
            if (medicamentos[i] != null && medicamentos[i].getNome() == nome ){
                return true;
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "Gaveta{" +
                "medicamentos=" + Arrays.toString(medicamentos) +
                '}';
    }
}
