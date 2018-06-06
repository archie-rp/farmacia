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

    public Venda procurarCod_venda(int codigo_venda) {
        Venda vendas_ = new Venda();
        for (Venda venda : vendas) {
            System.out.println(venda.getCod_venda());
            if (venda.getCod_venda() == codigo_venda) {
                vendas_ = venda;
            }
        }
        return vendas_;
    }

    public ArrayList<Venda> getVendasDia() {
        ArrayList<Venda> vendas1 = new ArrayList<>();

        for (Venda v_ : this.vendas) {

            Date max = new Date();
            Date min = Calendar.getInstance().getTime();
            Date d = v_.getDataCompra();

            Calendar cal = Calendar.getInstance();
            cal.setTime(Calendar.getInstance().getTime());
            cal.add(Calendar.DATE, 0);
            max = cal.getTime();

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(Calendar.getInstance().getTime());
            cal1.add(Calendar.DATE, -1);
            min = cal1.getTime();


            if (d.compareTo(min) > 0 && d.compareTo(max) < 0) {
                try {
                    vendas1.add(v_);

                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        return vendas1;
    }


    public ArrayList<Venda> getVendasSemana() {
        ArrayList<Venda> vendas1 = new ArrayList<>();

        for (Venda v_ : this.vendas) {

            Date max = new Date();
            Date min = Calendar.getInstance().getTime();
            Date d = v_.getDataCompra();

            Calendar cal = Calendar.getInstance();
            cal.setTime(Calendar.getInstance().getTime());
            cal.add(Calendar.DATE, 7);
            max = cal.getTime();

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(Calendar.getInstance().getTime());
            cal1.add(Calendar.DATE, -1);
            min = cal1.getTime();
            System.out.println(min + " " + max);
            System.out.println("Minimo" + d.compareTo(min) + " maximo" + d.compareTo(max));
            if (d.compareTo(min) > 0 && d.compareTo(max) < 0) {
                try {
                    vendas1.add(v_);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        return vendas1;
    }

    public ArrayList<Venda> getVendasMes() {
        ArrayList<Venda> vendas1 = new ArrayList<>();

        for (Venda v_ : this.vendas) {

            Date max = new Date();
            Date min = Calendar.getInstance().getTime();
            Date d = v_.getDataCompra();

            Calendar cal = Calendar.getInstance();
            cal.setTime(Calendar.getInstance().getTime());
            cal.add(Calendar.DATE, 30);
            max = cal.getTime();

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(Calendar.getInstance().getTime());
            cal1.add(Calendar.DATE, -1);
            min = cal1.getTime();
            System.out.println(min + " " + max);
            System.out.println("Minimo" + d.compareTo(min) + " maximo" + d.compareTo(max));
            if (d.compareTo(min) > 0 && d.compareTo(max) < 0) {
                try {
                    vendas1.add(v_);
                } catch (Exception e) {
                    System.out.print(e.getMessage());
                }
            }
        }
        return vendas1;
    }

}
