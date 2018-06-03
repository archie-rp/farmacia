package com.company;

import java.io.Serializable;
import java.util.ArrayList;

public class GestorVendas implements Serializable {
    private String nome;
    ArrayList<Venda> vendas;
    private int quantidade_vendas;
    private int quantidade_maxima;

    public GestorVendas(String nome, ArrayList<Venda> vendas, int quantidade_maxima) {
        this.nome = nome;
        this.vendas = vendas;
        this.quantidade_maxima = quantidade_maxima;
        this.quantidade_vendas = 0;
    }

    public GestorVendas() {
        this.nome = "";
        this.vendas = new ArrayList<Venda>();
        this.quantidade_maxima = 2000;
        this.quantidade_vendas= 0;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
    public ArrayList<Venda> getVendas(Cliente cliente) {
        ArrayList<Venda> vendas_=new ArrayList<>();
        for (Venda venda:vendas){
            if (venda.getCliente() == cliente){
                vendas_.add(venda);
            }
        }
        return vendas_;
    }

    public void setVendas(ArrayList<Venda> vendas) {
        this.vendas = vendas;
    }

    public int getQuantidade_maxima() {
        return quantidade_maxima;
    }

    public void setQuantidade_maxima(int quantidade_maxima) {
        this.quantidade_maxima = quantidade_maxima;
    }
    public boolean adicionarVenda(Venda venda){
        this.vendas.add(venda);
        this.quantidade_vendas++;
        return true;
    }
    public ArrayList<Venda> comprasCliente(Cliente cliente){
        ArrayList<Venda> vendas_cliente = new ArrayList<>();
        for (Venda venda:vendas){
            if (venda.getCliente().getNome() == cliente.getNome()){
                vendas_cliente.add(venda);
            }
        }
        return vendas_cliente;
    }
}
