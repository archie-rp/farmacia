package com.company;

import java.io.Serializable;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

public class Medicamento implements Variaveis,Serializable {
    private int id;
    private String nome;
    private float preco;
    private int Categoria;
    private int ViaAdmin;
    private Date dataValidade;


    public Medicamento(int id, String nome, float preco, int cate, int via, Date dataValidade) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        this.Categoria = cate;
        this.ViaAdmin = via;
        this.dataValidade = dataValidade;
    }
    
    public Medicamento( String nome, float preco, int cate, int via, Date dataValidade) {
        this.id = 0;
        this.nome = nome;
        this.preco = preco;
        this.Categoria = cate;
        this.ViaAdmin = via;
        this.dataValidade = dataValidade;
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

    public Medicamento(Medicamento medicamento) {
        this.id = medicamento.getId();
        this.nome = medicamento.getNome();
        this.preco = medicamento.getPreco();
        this.Categoria = medicamento.getCategoria();
        this.ViaAdmin = medicamento.getViaAdmin();
        this.dataValidade = medicamento.getDataValidade();
    }

    public Medicamento() {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
        this.Categoria = 0;
        this.ViaAdmin = 0;
        this.dataValidade = new Date();
    }


    public String getNome() {
        return nome;
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
        string.append(this.preco+ "  \n");
        return string.toString();
    }

    public boolean verificarValidade(Date data) {
        if (this.getDataValidade().compareTo(data)>0) {
            return false;
        } else {
            return true;
        }
    }
}