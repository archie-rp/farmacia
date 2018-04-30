package com.company;

import java.util.HashMap;

public class Medicamento implements CatVia {
    private String nome;
    private float preco;
    private int Categoria;
    private int ViaAdmin;


    public Medicamento(String nome, float preco, int cate, int via) {
        this.nome = nome;
        this.preco = preco;
        Categoria = cate;
        ViaAdmin = via;
    }

    public Medicamento(Medicamento medicamento) {
        this.nome = medicamento.getNome();
        this.preco = medicamento.getPreco();
        Categoria = medicamento.getCategoria();
        ViaAdmin = medicamento.getViaAdmin();
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

        string.append("Nome = " + nome);
        string.append(" || Preço = " + preco);
        string.append(" || Categoria = " + categorias[this.getCategoria()]);
        string.append(" || ViaAdmin = " + vias[this.getViaAdmin()] + "\n" );

        return string.toString();
    }

}