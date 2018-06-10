package com.company;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.toedter.calendar.DateUtil;

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


    public int totalClientes() {
        return clientes.size();
    }

    public int totalClientesSemana() {
        int total = 0;

        //
        for (Cliente c : clientes) {

            Date max = new Date();
            Date min = Calendar.getInstance().getTime();
            Date d = c.getDataInscricao();

            Calendar cal = Calendar.getInstance();
            cal.setTime(Calendar.getInstance().getTime());
            cal.add(Calendar.DATE, 7);
            max = cal.getTime();

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(Calendar.getInstance().getTime());
            cal1.add(Calendar.DATE, -1);
            min = cal1.getTime();

            if (d.compareTo(min) > 0 && d.compareTo(max) < 0) {
                total++;
            }
        }


        return total;
    }

    public int totalClientesMes() {
        int total = 0;

        //
        for (Cliente c : clientes) {
            Date max = new Date();
            Date min = Calendar.getInstance().getTime();
            Date d = c.getDataInscricao();

            Calendar cal = Calendar.getInstance();
            cal.setTime(Calendar.getInstance().getTime());
            cal.add(Calendar.DATE, 30);
            max = cal.getTime();

            Calendar cal1 = Calendar.getInstance();
            cal1.setTime(Calendar.getInstance().getTime());
            cal1.add(Calendar.DATE, -1);
            min = cal1.getTime();

            if (d.compareTo(min) > 0 && d.compareTo(max) < 0) {
                total++;
            }
        }


        return total;
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
                        if (farmacia.gestorvendas.comprasCliente(cliente).size() > 0) {
                            Relatorio relat = new Relatorio(farmacia.gestorvendas.comprasCliente(cliente), "Costa-Prozelo");
                            Dialog dialog = new Dialog(relat,farmacia);
                            dialog.setVisible(true);
                            encontrou = true;
                            return dialog;
                        } else {
                            JOptionPane.showMessageDialog(null, "O Cliente: " + cliente.getNome() + ", ainda não efectuou compras!");
                            encontrou = true;
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

    public Dialog procurarClienteBI(int bi, Farmacia farmacia) {
        boolean encontrou = false;
        try {

            for (Cliente cliente_ : clientes) {
                if (cliente_.getBi() == bi) {
                    if (farmacia.gestorvendas.comprasCliente(cliente_).size() > 0) {
                        Relatorio relat = new Relatorio(farmacia.gestorvendas.comprasCliente(cliente_), "Costa-Prozelo");
                        Dialog dialog = new Dialog(relat,farmacia);
                        dialog.setVisible(true);
                        encontrou = true;
                        return dialog;
                    } else {
                        JOptionPane.showMessageDialog(null, "O Cliente: " + cliente_.getNome() + ", ainda não efectuou compras!");
                        encontrou = true;
                        break;
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

