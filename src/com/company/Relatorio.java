package com.company;

import java.util.ArrayList;

public class Relatorio {
    private Venda venda = new Venda();
    private String nomeFarmacia;
    private String morada;

    public Relatorio(Venda venda, String nomeFarmacia, String morada) {
        this.venda = venda;
        this.nomeFarmacia = nomeFarmacia;
        this.morada = morada;
    }
    
    public Relatorio(Venda venda,  String morada) {
        this.venda = venda;
        this.nomeFarmacia = venda.getFuncionario().toString();
        this.morada = morada;
    }

    public Relatorio() {
        this.venda = new Venda();
        this.nomeFarmacia = "";
        this.morada = "";
    }

    public Venda getVenda() {
        return venda;
    }

    public void setVenda(Venda venda) {
        this.venda = venda;
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