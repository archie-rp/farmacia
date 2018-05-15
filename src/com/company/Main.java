package com.company;

import java.io.*;
import java.util.ArrayList;
import java.util.Date;


public class Main implements CatVia {

    public static int listarCategorias() {
        for (int i = 0; i < categorias.length; i++) {
            System.out.println(categorias[i]);
        }
        int escolha = Console.readInt("\nEscolha uma categoria");
        return escolha;
    }

    public static int listarVias() {
        for (int i = 0; i < vias.length; i++) {
            System.out.println(vias[i]);
        }
        int escolha = Console.readInt("\nEscolha uma Via de Administração");
        return escolha;
    }

    public static void listarMedicamento(Armario armario) {
        if (armario.toString() != null) {
            System.out.println(armario.toString());
        }
    }

    public static void inserirMedicamento(Armario armario) {
        Medicamento medic = new Medicamento();
        medic.setNome(Console.readString("\nInsira um nome"));
        medic.setPreco(Console.readFloat("\nInsira um preço"));
        medic.setCategoria(listarCategorias());
        medic.setViaAdmin(listarVias());
        armario.adicionarMedicamento(medic);
    }

    public static void main(String[] args) {
        //Criar Armario
        Armario armario = new Armario();
        //Gestor de Vendas
        GestorVendas gestorvendas = new GestorVendas();
        //Criar uma venda
        Venda venda1 = new Venda();
        //Criar uma compra que é uma arraylist de Medicamentos
        ArrayList<Medicamento> compra1= new ArrayList<Medicamento>();
        //Criar Medicamento para inserir na compra
        Medicamento medicamento1 = new Medicamento();
        //Definir medicamento
        medicamento1.setNome("MEd1");
        medicamento1.setCategoria(1);
        medicamento1.setViaAdmin(1);
        //Defenir a venda
        venda1.setCod_venda(102);
        venda1.setData_compra(new Date());
        venda1.setCliente(new Cliente(2,"Nome Cliente",1222, new Date()));
        //Adicionar medicamento na compra
        compra1.add(medicamento1);
        //Adicionar o arraylist dos medicamentos
        venda1.setMedicamentos(compra1);
        //Adicionar Vendas ao gestor de vendas
        gestorvendas.adicionarVenda(venda1);
        //Imprimir a Vendas
        //System.out.println(gestorvendas.getVendas());
        armario.adicionarMedicamento(medicamento1);
        // Serializaçao
        try {
            FileOutputStream fileOut = new FileOutputStream("Armario.ser");
            ObjectOutputStream out = new ObjectOutputStream(fileOut);
            out.writeObject(armario);
            out.close();
            fileOut.close();
            System.out.printf("Serialized data foi guardada em Armario.ser");
        } catch (IOException i) {
            i.printStackTrace();
        }
        Armario armario_serializado = new Armario();

        try {
            FileInputStream fileIn = new FileInputStream("Armario.ser");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            armario_serializado = (Armario) in.readObject();
            in.close();
            fileIn.close();
        } catch (IOException i) {
            i.printStackTrace();
            return;
        } catch (ClassNotFoundException c) {
            System.out.println("Armario class nao encontrado!");
            c.printStackTrace();
            return;
        }
        System.out.println(armario_serializado.toString());
    }
}
