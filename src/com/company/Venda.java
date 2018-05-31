package com.company;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

public class Venda  implements CatVia{
    private int cod_venda;
    private Cliente cliente;
    private Date data_compra;
    ArrayList<Medicamento> medicamentos;
    private float preco_total;
    private float preco_sub;
    private float desconto;
    private Funcionario funcionario;
    private Date dataCompra;
    private int formaPagamento;


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


    public Date getData_compra() {
        return data_compra;
    }

    public float getDesconto() {
        return desconto;
    }

    public Venda(int cod_venda, Cliente cliente, Date data_compra, ArrayList<Medicamento> medicamentos) {
        this.cod_venda = cod_venda;
        this.cliente = cliente;
        this.data_compra = data_compra;
        this.medicamentos = medicamentos;
        this.desconto = 0f;
    }

    public Venda(Venda venda){
        this.cod_venda = venda.cod_venda;
        this.cliente = venda.cliente;
        this.data_compra = venda.data_compra;
        this.medicamentos = venda.medicamentos;
        this.desconto = 0f;
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

    public ArrayList<Medicamento> getMedicamentos() {
        return medicamentos;
    }

    @Override
    public String toString() {
    	StringBuilder string =new StringBuilder();
    	string.append(cod_venda+" ");
    	string.append(cliente+" ");
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        String formattedDate = df.format(this.data_compra);
    	string.append(formattedDate);
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

}
