package com.company;

import java.util.ArrayList;
import java.util.List;

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

        if (armario.toString() == null) {

        } else {
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
        Armario armario = new Armario();

        System.out.print("Inserir Medicamento");
        inserirMedicamento(armario);
        listarMedicamento(armario);


        //Criar Medicamento

        /*Medicamento medicamento1 = new Medicamento("Nacix", 12.3f, 2, 1);
        Medicamento medicamento2 = new Medicamento("benuron", 12.3f, 0, 0);

        //adicionar medicamento
        armario.adicionarMedicamento(medicamento1);
        armario.adicionarMedicamento(medicamento1);
        System.out.println(armario.getQuantidadGaveta(2, 1));
        System.out.println(armario.toString());
        System.out.println(armario.removerMedicamento("Nacix"));*/

    }
}
