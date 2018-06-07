package com.company;

public interface Variaveis {
    String categorias[] = {"Antiácidos‎", "Anticoagulantes‎ ", "Cardiotônicos‎", "Diuréticos‎", "Antidepressivos", "Hipertensores‎", "Fibrinolíticos‎", "Anti-hemorrágicos‎", "Laxantes", "Antipiréticos‎",
            "Relaxantes musculares‎", "Anti-histamínicos‎", "Imunossupressores", "Anti-inflamatórios‎", "Teratogênicos‎", "Agentes hormonais‎", "Plantas medicinais‎", "Antiarrítmicos‎", "Expectorantes‎", "Inibidores da lactação‎ "};
    String vias[] = {"Oral", "Injetável", "Dermatológica", "Nasal", "Oftálmica", "Ocular", "Intra-Nasal", "Cutânea", "Auricular"};
    Float IVA = 23f;
    String modoPagamento[] = {"Multibanco", "Dinheiro", "Cheque"};
    String farmacias[] = {"Loja 1", "Loja 2", "Loja 3"};
    String descontos[] = {"0%", "5%", "10%"};
    String estados[] = {"Pendente","OK" };
    String receitas[]={"Necessita Receita","Não necessita receita"};
    int selecao[][] = {{1,2},{0,2},{0,1}};
    Funcionario [] funcionarios = {new Funcionario("Paulo"),new Funcionario("Rita"),new Funcionario("Jéssica")};
}
