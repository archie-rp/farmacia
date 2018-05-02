package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Venda {
    private int cod_venda;
    private Cliente cliente;
    private Date data_compra;
    ArrayList<Medicamento> medicamentos;

    public void setCod_venda(int cod_venda) {
        this.cod_venda = cod_venda;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public void setData_compra(Date data_compra) {
        this.data_compra = data_compra;
    }

    public void setMedicamentos(ArrayList<Medicamento> medicamentos) {
        this.medicamentos = medicamentos;
    }

    public Venda(int cod_venda, Cliente cliente, Date data_compra, ArrayList<Medicamento> medicamentos) {
        this.cod_venda = cod_venda;
        this.cliente = cliente;
        this.data_compra = data_compra;
        this.medicamentos = medicamentos;
    }

    public Venda(Venda venda){
        this.cod_venda = venda.cod_venda;
        this.cliente = venda.cliente;
        this.data_compra = venda.data_compra;
        this.medicamentos = venda.medicamentos;
    }

    public Venda(){
        this.cod_venda = 0;
        this.cliente = new Cliente();
        this.data_compra = new Date();
        this.medicamentos = new ArrayList<Medicamento>();
    }

    @Override
    public String toString() {
        return "Venda{" +
                "cod_venda=" + cod_venda +
                ", nome_cliente='" + cliente + '\'' +
                ", data_compra=" + data_compra +
                ", medicamentos=" + medicamentos +
                '}';
    }

}
