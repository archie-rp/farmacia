package com.company;

import java.util.List;

public class Coluna extends Gaveta{
    List<Gaveta> colunas;
    private String categoria;

    public Coluna() {
        this.colunas = null;
        this.categoria = "";
    }

    public Coluna(List<Gaveta> colunas, String categoria) {
        this.colunas = colunas;
        this.categoria = categoria;
    }

    public List<Gaveta> getColunas() {
        return colunas;
    }

    public void setColunas(List<Gaveta> colunas) {
        this.colunas = colunas;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    @Override
    public String toString() {
        return "Coluna{" +
                "colunas=" + colunas +
                ", categoria='" + categoria + '\'' +
                '}';
    }
}
