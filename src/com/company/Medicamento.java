package com.company;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.Objects;

public class Medicamento implements Variaveis,Serializable,Cloneable{
    private int id;
    private String nome;
    private float preco;
    private int Categoria;
    private int ViaAdmin;
    private Date dataValidade;
    private boolean receita;
    private int estado;
    private int cod_compra;
    private int quantidadeEncomenda;



    public Medicamento(int id, String nome, float preco, int cate, int via, Date dataValidade ) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.Categoria = cate;
        this.ViaAdmin = via;
        this.dataValidade = dataValidade;
        this.receita=receita;
        this.estado=1;
        this.quantidadeEncomenda=0;
        
    }
    
    public Medicamento( String nome, float preco, int cate, int via, Date dataValidade,boolean receita) {
        this.id = 0;
        this.nome = nome;
        this.preco = preco;
        this.Categoria = cate;
        this.ViaAdmin = via;
        this.dataValidade = dataValidade;
        this.receita=receita;
        this.estado=1;
        this.quantidadeEncomenda=0;
    }




    public Medicamento(Medicamento medicamento) {
        this.id = medicamento.getId();
        this.nome = medicamento.getNome();
        this.preco = medicamento.getPreco();
        this.Categoria = medicamento.getCategoria();
        this.ViaAdmin = medicamento.getViaAdmin();
        this.dataValidade = medicamento.getDataValidade();
        this.estado=medicamento.getEstado();
        this.quantidadeEncomenda=medicamento.getQuantidadeEncomenda();
    }

    public Medicamento() {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
        this.Categoria = 0;
        this.ViaAdmin = 0;
        this.dataValidade = new Date();
        this.estado=1;
        this.quantidadeEncomenda=0;
    }


    public boolean isReceita() {
        return receita;
    }

    public void setCod_compra(int cod_compra) {
        this.cod_compra = cod_compra;
    }

    public int getCod_compra() {
        return cod_compra;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

    public int getEstado() {
        return estado;
    }

    public void setReceita(boolean receita) {
        this.receita = receita;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public Date getDataValidade() {
        return dataValidade;
    }

    public void setDataValidade(Date dataValidade) {
        this.dataValidade = dataValidade;
    }


    public String getNome() {
        return this.nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getCategoria() {
        return Categoria;
    }

    public void setCategoria(int categoria) {
        Categoria = categoria;
    }

    public int getViaAdmin() {
        return ViaAdmin;
    }

    public void setViaAdmin(int viaAdmin) {
        ViaAdmin = viaAdmin;
    }

    public int getQuantidadeEncomenda() {
        return quantidadeEncomenda;
    }

    public void setQuantidadeEncomenda(int quantidadeEncomenda) {
        this.quantidadeEncomenda = quantidadeEncomenda;
    }

    @Override
    public String toString() {

        StringBuilder string = new StringBuilder();
        //string.append("\n" + "ID = " + this.id);
        string.append(this.getNome() + " ");
        string.append(this.categorias[this.getCategoria()]+ " ");
        string.append(this.vias[this.getViaAdmin()]+ " ");
        DateFormat df = DateFormat.getDateInstance(DateFormat.LONG, Locale.getDefault());
        String formattedDate = df.format(this.getDataValidade());
        string.append(formattedDate + " ");
        string.append(this.preco+ " ");
        string.append(estados[this.getEstado()]);
        if(this.receita!=false) {
        	  string.append(" Necessita receita\n");
        }else {
        	  string.append(" \n");
        }
      
        return string.toString();
    }

    public boolean verificarValidade(Date data) {
        if (this.getDataValidade().compareTo(data)>0) {
            return false;
        } else {
            return true;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Medicamento that = (Medicamento) o;
        return id == that.id &&
                Float.compare(that.preco, preco) == 0 &&
                Categoria == that.Categoria &&
                ViaAdmin == that.ViaAdmin &&
                receita == that.receita &&
                estado == that.estado &&
                cod_compra == that.cod_compra &&
                Objects.equals(nome, that.nome) &&
                Objects.equals(dataValidade, that.dataValidade);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, nome, preco, Categoria, ViaAdmin, dataValidade, receita, estado, cod_compra);
    }


    public Object clone()throws CloneNotSupportedException{
        return super.clone();
    }
}