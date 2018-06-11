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
    private long bi;
    private long nib;

    public long getBi() {
        return bi;
    }

    public long getNib() {
        return nib;
    }

    public String getCapital() {
        return capital;
    }

    private String capital;



    public ArrayList<Medicamento> getMedicamentos_pendentes() {
        return medicamentos_pendentes;
    }



    public Farmacia(String nome, GestorVendas gestorvendas, Armario[] armarios, GestorClientes gestorclientes) {
        this.nome = nome;
        this.gestorvendas = gestorvendas;
        this.armarios = new Armario[3];
        this.gestorclientes = gestorclientes;
        this.funcionarios = Variaveis.funcionarios;
        this.bi=435567822;
        this.nib=98844399;
        this.capital= "1.499.123";
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
        Medicamento medicamento = new Medicamento();
        int existe = 0;
        if(medicamentosHistorico!=null) {
            for (Medicamento m_ : medic) {
                if (medicamentosHistorico.contains(m_)) {
                    System.out.print("Existe");
                    existe++;
                } else {
                    medicamento = m_;
                }
            }
            System.out.print(existe);
            if (existe < 1) {
                try {
                    this.medicamentosHistorico.add(medicamento);
                } catch (Exception e) {
                    this.medicamentosHistorico = new ArrayList<Medicamento>();
                    this.medicamentosHistorico.add(medicamento);
                }
            }
        }else{
            medicamentosHistorico=new ArrayList<>();
            this.medicamentosHistorico.add(medic.get(0));
            System.out.print("NULO");
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
    public boolean removerMedicamentoPendende(Medicamento medicamento){
        boolean estado = false;
        for (Medicamento medicamento_:medicamentos_pendentes){
            if (medicamento_.getNome()== medicamento.getNome()){
                medicamentos_pendentes.remove(medicamento_);
                estado=true;
            }
            if (estado==true){
                break;
            }
        }
        return estado;
    }

    public boolean removerMedicamentoEncomenda(Medicamento medicamento){
        boolean estado = false;
        for (Medicamento medicamento_:medicamentos_pendentes){
            if (medicamento_.getNome()== medicamento.getNome() && medicamento.getEstado()==2){
                medicamentos_pendentes.remove(medicamento_);
                estado=true;
            }
            if (estado==true){
                break;
            }
        }
        return estado;
    }
}
