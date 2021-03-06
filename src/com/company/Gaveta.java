package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class Gaveta implements Serializable {
    ArrayList<Medicamento> medicamentos;

    public Gaveta() {
        this.medicamentos = new ArrayList<Medicamento>(10);
    }

    public Gaveta(Medicamento medicamento, String via_admin) {
        this.medicamentos.add(medicamento);
    }

    public int getQuantidade() {
        if (this.medicamentos.size() != 0) {
            return this.medicamentos.size();
        } else {
            return 0;
        }
    }

    public int getMedicamentoQuantidade(Medicamento medicamento) {
        int i = 0;
        for (Medicamento medicamento_ : medicamentos) {
            if (medicamento_ != null && medicamento_.getNome() == medicamento.getNome()) {
                i++;
            }
        }
        return i;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    public Medicamento getMedicamento(String nome) {
        Medicamento medicamento = new Medicamento();
        for (Medicamento medicamento_ : medicamentos) {
            if (medicamento_.getNome().toLowerCase().equals(nome.toLowerCase())) {
                    return medicamento_;
            }
        }
        return null;
    }


    public boolean setMedicamentos(Medicamento medicamento) {
        if (medicamentos.size() <= 10) {
            this.medicamentos.add(medicamento);
            return true;
        } else {
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
    
    public boolean removerTodosMedicamento(String nome) {
        for (Medicamento medicamento : medicamentos) {
        
            if (medicamento != null && medicamento.getNome() == nome) {
                medicamentos.remove(medicamento);
                return true;
            }
        }
        return false;
    }

    public boolean updateMedicamento(Medicamento novo_med) {
        for (Medicamento medicamento : medicamentos) {
            if (medicamento != null && medicamento.getNome() == novo_med.getNome()) {
                medicamento = novo_med;
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

    public boolean contains(String nome) {
        return false;
    }

}
 
