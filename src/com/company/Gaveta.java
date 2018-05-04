package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Gaveta {
    ArrayList<Medicamento> medicamentos;

    public Gaveta() {
        this.medicamentos = new ArrayList<Medicamento>(10);
    }

    public Gaveta(Medicamento medicamento, String via_admin) {
        this.medicamentos.add(medicamento);
    }

    public int getQuantidade() {
        return this.medicamentos.size();
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public boolean setMedicamentos(Medicamento medicamento) {
        if (medicamentos.size() <= 10) {
            this.medicamentos.add(medicamento);
            return true;
        }
        else {
            return false;
        }
    }

    public boolean removerMedicamento(String nome) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento != null && medicamento.getNome() == nome) {
                medicamentos.remove(medicamento);
                return true;
            }
        }
        return false;
    }

    public boolean updateMedicamento(String nome, Medicamento novo_med) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento != null && medicamento.getNome() == nome) {
                medicamento= novo_med;
            }
        }
        return false;
    }

    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\nGaveta: ");
        for (Medicamento medicamento : medicamentos) {
            string.append("\nMedicamento = " + medicamento.toString());
        }
        return string.toString();
    }
}
 
