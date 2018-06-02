package com.company;

import java.util.ArrayList;
import java.util.Date;

public class Relatorio {
    private ArrayList<Venda> vendas= new ArrayList<>();
    private String nomeFarmacia;
    private String morada;
    public Relatorio(Venda venda, String nomeFarmacia, String morada) {
        this.vendas.add(venda) ;
        this.nomeFarmacia = nomeFarmacia;
        this.morada = morada;
    }
    
    public Relatorio(Venda venda,  String morada) {
        this.vendas.add(venda);
        this.nomeFarmacia = venda.getFuncionario().toString();
        this.morada = morada;
    }

    public Relatorio(ArrayList<Venda> vendas,  String morada) {
        this.vendas = vendas;
        this.nomeFarmacia = "Medis";
        this.morada = morada;
    }

    public Relatorio() {
        this.vendas = new ArrayList<>();
        this.nomeFarmacia = "";
        this.morada = "";
    }

    public ArrayList<Venda> getVendas() {
        return vendas;
    }
    public Venda getVenda() {
        return vendas.get(0);
    }
    public Venda getVendaData(Date data){
        Venda vend = new Venda();
        for (Venda venda:vendas){
            if (venda.getDataCompra().equals(data)){
                vend=venda;
            }
        }
        return vend;
    }

    public String getFuncionario(){
        String funcionario="";
        for (Venda venda:vendas){
            funcionario=venda.getFuncionario().getNome();
        }
        return funcionario;
    }
    public String getCliente(){
        String cliente="";
        for (Venda venda:vendas){
            cliente=venda.getCliente().getNome();
        }
        return cliente;
    }
    public void setVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public String getNomeFarmacia() {
        return nomeFarmacia;
    }

    public void setNomeFarmacia(String nomeFarmacia) {
        this.nomeFarmacia = nomeFarmacia;
    }

    public String getMorada() {
        return morada;
    }

    public void setMorada(String morada) {
        this.morada = morada;
    }
}