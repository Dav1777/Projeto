package models;

public abstract class Veiculo {
    private String placa;
    private String modelo;
    private String ano;
    private boolean emUso;

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public Veiculo (String placa, String modelo, String ano){
        this.placa = placa;
        this.modelo = modelo;
        this.ano = ano;
        this.emUso = false;
    }

    public Veiculo(String placa){
        this.placa = placa;
    };

    public String getPlaca() {
        return placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getAno() {
        return ano;
    }

    public void setAno(String ano) {
        this.ano = ano;
    }

    public boolean isEmUso() {
        return emUso;
    }

    public void setEmUso(boolean emUso) {
        this.emUso = emUso;
    }

    @Override
    public String toString() {
        return "Veiculo{" +
                "placa='" + placa + '\'' +
                ", modelo='" + modelo + '\'' +
                ", ano=" + ano +
                ", emUso=" +emUso +
                '}';
    }
    }


