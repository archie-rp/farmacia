package com.company;

import java.util.HashMap;

public class Medicamento implements CatVia {
    private int id;
    private String nome;
    private float preco;
    private int Categoria;
    private int ViaAdmin;


    public Medicamento(int id, String nome, float preco, int cate, int via) {
        this.id = id;
        this.nome = nome;
        this.preco = preco;
        Categoria = cate;
        ViaAdmin = via;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {

        return id;
    }

    public Medicamento(Medicamento medicamento) {
        this.id = medicamento.getId();

        this.nome = medicamento.getNome();
        this.preco = medicamento.getPreco();
        Categoria = medicamento.getCategoria();
        ViaAdmin = medicamento.getViaAdmin();
    }

    public Medicamento() {
        this.id = 0;
        this.nome = "";
        this.preco = 0;
        Categoria = 0;
        ViaAdmin = 0;
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

        string.append("\n" + "ID = " + id);
        string.append("\n" + "Nome = " + nome);
        string.append("\nPreço = " + preco);
        string.append("\nCategoria = " + categorias[this.getCategoria()]);
        string.append("\nViaAdmin = " + vias[this.getViaAdmin()] + "\n");

        return string.toString();
    }

}