package models;

public class Funcionario {
    private String nome;
    private final String matricula;
    private final String cpf;
    //private boolean CNH;

    public Funcionario (String nome, String matricula, String cpf){
        this.nome = nome;
        this.matricula = matricula;
        this.cpf = cpf;
        //this.CNH = temCNH;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getMatricula() {
        return matricula;
    }

    /*public boolean isCNH() {
        return CNH;
    }*/

    public String getCpf() {
        return cpf;
    }

    /*public void setCNH(boolean CNH) {
        this.CNH = CNH;
    }*/

    @Override
    public String toString() {
        return "Funcionario{" +
                "Nome='" + nome + '\'' +
                ", Matricula='" + matricula + '\'' +
                ", CPF='" + cpf + '\'' +
                '}';
    }
}
