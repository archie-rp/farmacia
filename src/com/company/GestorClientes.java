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
    
  public int  totalClientes() {




	  return clientes.size();
}

    @Override
    public String toString() {
        return "GestorClientes{" +
                "clientes=" + clientes +
                '}';
    }

    public Dialog procurarCliente(String nomeCliente, Farmacia farmacia) {
        boolean encontrou = false;
        try {
        	 if (nomeCliente != null) {
                 for (Cliente cliente : clientes) {
                     if (cliente.getNome().toLowerCase().equals(nomeCliente.toLowerCase())) {
                         if(farmacia.gestorvendas.comprasCliente(cliente).size()>0) {
                         Relatorio relat = new Relatorio(farmacia.gestorvendas.comprasCliente(cliente), "Costa-Prozelo");
                         Dialog dialog = new Dialog(relat);
                         dialog.setVisible(true);
                         encontrou = true;
                         return dialog;
                         }
                         else {
                        	 JOptionPane.showMessageDialog(null, "O Cliente: "+ cliente.getNome()+", ainda não efectuou compras!");
                        	 encontrou=true;
                        	 break;
                         }
                     }
                 }
             }
             if (encontrou == false) {
                 JOptionPane.showMessageDialog(null, "Cliente não encontrado na base de dados");
             }
			
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e);
		}
       
        return null;
    }
}

