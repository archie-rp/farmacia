package com.company;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Venda  implements Variaveis,Serializable {
    private int cod_venda;
    private Cliente cliente;
    private Date data_compra;
    ArrayList<Medicamento> medicamentos;
    private float preco_total;
    private float preco_sub;
    private int desconto;
    private Funcionario funcionario;
    private Date dataCompra;
    private int formaPagamento;


    public Venda(int cod_venda, Cliente cliente, Date data_compra, ArrayList<Medicamento> medicamentos) {
        this.cod_venda = cod_venda;
        this.cliente = cliente;
        this.data_compra = data_compra;
        this.medicamentos = medicamentos;
        this.funcionario = new Funcionario();
        this.desconto = 0;
    }

    public Venda(Venda venda){
        this.cod_venda = venda.cod_venda;
        this.cliente = venda.cliente;
        this.data_compra = venda.data_compra;
        this.medicamentos = venda.medicamentos;
        this.desconto = 0;
    }


    public Venda(String funcionario){
        this.cod_venda = 0;
        this.cliente = new Cliente();
        this.data_compra = new Date();
        this.medicamentos = new ArrayList<Medicamento>();
        this.formaPagamento=0;
        this.funcionario=new Funcionario(funcionario);
        this.dataCompra=new Date();
    }

    public Venda(){
        this.cod_venda = 0;
        this.cliente = new Cliente();
        this.data_compra = new Date();
        this.medicamentos = new ArrayList<Medicamento>();
        this.formaPagamento=0;
        this.funcionario=new Funcionario();
        this.dataCompra=new Date();
    }


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

    public void setMedicamento(Medicamento medicamento){
        this.medicamentos.add(new Medicamento(medicamento));
    }

    public Date getData_compra() {
        return data_compra;
    }

    public float getDesconto() {
        return desconto;
    }


    public void setPreco_total(float preco_total) {
        this.preco_total = preco_total;
    }

    public void setPreco_sub(float preco_sub) {
        this.preco_sub = preco_sub;
    }

    public void setDesconto(int desconto) {
        this.desconto = desconto;
    }

    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }

    public void setDataCompra(Date dataCompra) {
        this.dataCompra = dataCompra;
    }

    public void setFormaPagamento(int formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public int getCod_venda() {
        return cod_venda;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Funcionario getFuncionario() {
        return funcionario;
    }

    public Date getDataCompra() {

        return dataCompra;
    }


    public int getFormaPagamento() {
        return formaPagamento;
    }

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
    	StringBuilder string =new StringBuilder();
    	string.append("cod:" + cod_venda+" ");
    	string.append("Cliente" + cliente+" ");
        DateFormat df = DateFormat.getDateInstance(DateFormat.SHORT, Locale.getDefault());
        String formattedDate = df.format(this.data_compra);
    	string.append("Data:" + formattedDate);
    	return string.toString();
    }

    public float getPreco_total(){
     float total=0f;
     for (Medicamento med:medicamentos){
         total +=med.getPreco();
     }
        return total+(total*0.23f);
    }

    public float getPreco_sub() {
        float sub=0f;
        for (Medicamento med:medicamentos){
            sub +=med.getPreco();
        }
        return sub;
    }
    public float getIVA(){
        return IVA;
    }

    public boolean darBaixa(Medicamento medicamento){
        boolean estado = false;
        System.out.println("Medicamento_para_trocar_estado: " + medicamento.getCod_compra() + "estado: "+medicamento.getEstado());
        for (Medicamento medicamento_:medicamentos) {
            System.out.println("Venda medicamento:" + medicamento_.toString() + "estado:" + medicamento_.getEstado());
            if (medicamento_.getNome() == medicamento.getNome() && medicamento_.getEstado() == 0) {
                System.out.println("Alerta encontrou! estado:" + medicamento_.getEstado());
                medicamento_.setEstado(1);
                estado = true;
            } else {
                System.out.println("Nao encontrou!");
                estado = false;
            }
            if (estado == true){
                break;
            }
        }
            return estado;
        }

   
    
}
