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
}

