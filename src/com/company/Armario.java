package com.company;

import javax.swing.*;
import java.io.Serializable;
import java.util.ArrayList;
import javax.swing.JOptionPane;

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
                    if (armario[i][j].getMedicamentos().isEmpty()) {
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

    public ArrayList<Medicamento> getMedicamentosGaveta(int cat, int via) {
        return armario[cat][via].getMedicamentos();
    }

    public int getMedicamentoQuantidade(Medicamento medicamento) {
        int total = 0;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                try {
                    int medic = armario[i][j].getMedicamentoQuantidade(medicamento);
                    if (medic != 0) {
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

    //
    public JDialog adicionarMedicamento(Medicamento medicamento, int quantidade) {
        if (armario[medicamento.getCategoria()][medicamento.getViaAdmin()] == null) {
            //Criar gaveta
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()] = new Gaveta();
            //Adicionar medicamento na gaveta
            for (int i = 0; i < quantidade; i++) {
                armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.add(medicamento);
                // Aumentar quantidade
                this.quantidade++;
            }
            //Removi notificacao de adicionado com sucesso

        } else {
            if ((armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.size() + quantidade) <= 10) {
                for (int i = 0; i < quantidade; i++) {
                    armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.add(medicamento);
                    this.quantidade++;
                }
            } else {
                JOptionPane optionPane = new JOptionPane("Não é permitido adicionar o medicamento! Quantidade máxima:" + (10 - armario[medicamento.getCategoria()][medicamento.getViaAdmin()].medicamentos.size()), JOptionPane.WARNING_MESSAGE);
                JDialog dialog = optionPane.createDialog("Alerta!");
                dialog.setAlwaysOnTop(true);
                dialog.setVisible(true);
                return dialog;
            }
        }
        return null;
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
        try {
            return armario[cat][via].getMedicamentos().size();
        } catch (Exception e) {
            return 0;
        }
    }

    public float getPrecoGaveta(int cat, int via) {
        float preco_gaveta = 0;
        try {
            for (Medicamento med : this.getMedicamentosGaveta(cat, via)) {
                preco_gaveta += med.getPreco();
            }
            return preco_gaveta;
        } catch (Exception e) {
            return 0f;
        }
    }

    public boolean removerMedicamento(Medicamento medic) {
        int back_quantidade = this.quantidade;
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j] != null && armario[i][j].removerMedicamento(medic.getNome().toString())) {
                    this.quantidade--;
                    medic = null;
                }
            }
        }
        if (back_quantidade > this.quantidade) {
            return true;
        } else {
            return false;
        }
    }

    public Medicamento procurarMedicamento(String nome) {
        Medicamento medic =new Medicamento();
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 10; j++) {
                if (armario[i][j].getMedicamentos().size() >0) {
                    medic = armario[i][j].getMedicamento(nome);
                    if(medic!= null){
                        return medic;
                    }
                }
            }
        }
        return medic;
    }

    public boolean atualizarMedicamento(Medicamento novo_med) {
        if (armario[novo_med.getCategoria()][novo_med.getViaAdmin()] != null && armario[novo_med.getCategoria()][novo_med.getViaAdmin()].updateMedicamento(novo_med)) {
            return true;
        }
        return false;
    }
}