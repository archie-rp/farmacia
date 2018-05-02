package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private int cod_venda;
    private String nome_cliente;
    private Date data_compra;
    ArrayList<Medicamento> medicamentos;

    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

    public void setNome_cliente(String nome_cliente) {
        this.nome_cliente = nome_cliente;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Venda(int cod_venda, String nome_cliente, Date data_compra, ArrayList<Medicamento> medicamentos) {
        this.cod_venda = cod_venda;
        this.nome_cliente = nome_cliente;
        this.data_compra = data_compra;
        this.medicamentos = medicamentos;
    }

    public Venda(Venda venda){
        this.cod_venda = venda.cod_venda;
        this.nome_cliente = venda.nome_cliente;
        this.data_compra = venda.data_compra;
        this.medicamentos = venda.medicamentos;
    }

    public Venda(){
        this.cod_venda = 0;
        this.nome_cliente = "";
        this.data_compra = new Date();
        this.medicamentos = new ArrayList<Medicamento>();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cod_venda=" + cod_venda +
                ", nome_cliente='" + nome_cliente + '\'' +
                ", data_compra=" + data_compra +
                ", medicamentos=" + medicamentos +
                '}';
    }

}
