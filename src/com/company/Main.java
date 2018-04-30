package com.company;

import java.util.ArrayList;
import java.util.List;

public class Main implements CatVia {

    public static void main(String[] args) {
        Armario armario = new Armario();
        //Criar Medicamento
        for (int i=0;i<categorias.length;i++){
            System.out.println(categorias[i]);
        }
        Medicamento medicamento1 = new Medicamento("Nacix",12.3f,2,1);
        Medicamento medicamento2 = new Medicamento("benuron",12.3f,0,0);

        //adicionar medicamento
        armario.adicionarMedicamento(medicamento1);
        armario.adicionarMedicamento(medicamento1);
        System.out.println(armario.getQuantidadGaveta(2,1));
        System.out.println(armario.toString());
        System.out.println(armario.removerMedicamento("Nacix"));
        /* -----

        olaalsdlasdnjasndkjsadkjsnadkjnasdknaskjdnsajkndaskjnda
        asdsabdaskjdnsakjndjksandjkasndjksandsjkndasdãsdnjaksndjkas

        asdasdasdasda
        


         */
    }
}
