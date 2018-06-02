package com.company;

import java.util.ArrayList;

public class GestorClientes {
    ArrayList<Cliente> clientes;

    public GestorClientes(ArrayList<Cliente> clientes) {
        this.clientes = clientes;
    }
    public GestorClientes() {
        this.clientes = new ArrayList<Cliente>();
    }

    public ArrayList<Cliente> getClientes() {
        return clientes;
    }

    public void setCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    @Override
    public String toString() {
        return "GestorClientes{" +
                "clientes=" + clientes +
                '}';
    }
    public Dialog procurarCliente(String nomeCliente,Farmacia farmacia){
        if (nomeCliente != null){
            for (Cliente cliente:clientes){
                if (cliente.getNome().equalsIgnoreCase(nomeCliente)){
                    System.out.println(nomeCliente);
                    Relatorio relat = new Relatorio(farmacia.gestorvendas.comprasCliente(cliente), "Costa-Prozelo");
                    Dialog dialog = new Dialog(relat);
                    dialog.setVisible(true);
                    return dialog;
                }
            }
        }
        return null;
    }
}

