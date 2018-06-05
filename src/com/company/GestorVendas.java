package com.company;

import java.io.Serializable;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

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
        this.quantidade_vendas = 0;
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
        ArrayList<Venda> vendas_ = new ArrayList<>();
        for (Venda venda : vendas) {
            if (venda.getCliente() == cliente) {
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

    public boolean adicionarVenda(Venda venda) {
        this.vendas.add(venda);
        this.quantidade_vendas++;
        return true;
    }

    public ArrayList<Venda> comprasCliente(Cliente cliente) {
        ArrayList<Venda> vendas_cliente = new ArrayList<>();
        for (Venda venda : vendas) {
            System.out.println(venda.getCliente().getNome() + cliente.getNome());
            if (venda.getCliente().getNome() == cliente.getNome()) {
                vendas_cliente.add(venda);
            }
        }
        return vendas_cliente;
    }

    public ArrayList<Venda> getVendasDia() {
        ArrayList<Venda> vendas1 = new ArrayList<>();
        Date data = Calendar.getInstance().getTime();

        SimpleDateFormat sdf = new SimpleDateFormat("ddMMyyyy");
        for (Venda v_ : this.vendas) {
            try {
                if (sdf.format(v_.getDataCompra()).equals(sdf.format(data))) {
                    vendas1.add(v_);
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        return vendas1;
    }

    public ArrayList<Venda> getVendasSemana() {
        ArrayList<Venda> vendas1 = new ArrayList<>();
        Date data = Calendar.getInstance().getTime();
        // data-7;
        for (Venda v_ : this.vendas) {
            System.out.println(data + " " + v_.getDataCompra());

            try {
                if (v_.getDataCompra().compareTo(data) == 0) {
                    System.out.print(v_.getDataCompra().compareTo(data));
                    vendas1.add(v_);
                }
            } catch (Exception e) {
                System.out.print(e.getMessage());
            }
        }
        return vendas1;
    }

}
