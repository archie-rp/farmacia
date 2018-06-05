package com.company;

import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

public class GestorClientes implements Serializable {
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
    
    public void removerCliente(Cliente cliente) {
        this.clientes.remove(cliente);
    }

    @Override
    public String toString() {
        return "GestorClientes{" +
                "clientes=" + clientes +
                '}';
    }

    public Dialog procurarCliente(String nomeCliente, Farmacia farmacia) {
        boolean encontrou = false;
        if (nomeCliente != null) {
            for (Cliente cliente : clientes) {
                if (cliente.getNome().equalsIgnoreCase(nomeCliente)) {
                    //  System.out.println(nomeCliente);
                    Relatorio relat = new Relatorio(farmacia.gestorvendas.comprasCliente(cliente), "Costa-Prozelo");
                    Dialog dialog = new Dialog(relat);
                    dialog.setVisible(true);
                    encontrou = true;
                    return dialog;
                }
            }
        }
        if (encontrou == false) {
            JOptionPane.showMessageDialog(null, "Cliente não encontrado na base de dados");
        }
        return null;
    }
}

