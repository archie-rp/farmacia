package com.company;




public class Armario{
    private Gaveta armario[][];
    private String nome;
    private int quantidade;

    public Armario() {
        this.armario = new Gaveta[20][10];
        this.nome = "";
        this.quantidade = 0;
    }

    public Gaveta[][] getArmario() {
        return armario;
    }

    public void setArmario(Gaveta[][] armario) {
        this.armario = armario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public void adicionarMedicamento(Medicamento medicamento){
        if (armario[medicamento.getCategoria()][medicamento.getViaAdmin()] == null){
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()]= new Gaveta();
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()].setMedicamento(medicamento);
            this.quantidade++;
        }
        else{
            armario[medicamento.getCategoria()][medicamento.getViaAdmin()].setMedicamento(medicamento);
            this.quantidade++;
        }
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("\t Medicamentos:");
        for (int i=0; i<20;i++){
            for(int j=0;j<10;j++){
                if (armario[i][j] != null){
                    string.append(armario[i][j].toString());
                }
            }
        }
        return string.toString();
    }
    public int getQuantidadGaveta(int cat , int via){
        return  armario[cat][via].getQuantidade();
    }

    public boolean removerMedicamento(String nome){
        for (int i=0; i<20;i++){
            for(int j=0;j<10;j++){
                if (armario[i][j] != null && armario[i][j].removerMedicamento(nome)){
                    return true;
                }
            }
        }
        return false;
    }
}