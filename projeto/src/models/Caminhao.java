package models;

public class Caminhao extends Veiculo {

    private String cargaMax;

    public Caminhao(String placa, String modelo, String ano, double cargaMax){
        super(placa, modelo, ano);
        this.cargaMax = cargaMax;
    }

    //public Caminhao(){};

    public String getCargaMax() {
        return cargaMax;
    }

    public void setCargaMax(String cargaMax) {
        this.cargaMax = cargaMax;
    }

    @Override
    public String toString() {
        return super.toString() +
                " Caminhao{" +
                "Carga max='" + cargaMax +
                '}';
    }
    }

