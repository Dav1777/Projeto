package models;

public class Carro extends Veiculo{

    private String portas;

    public Carro(String placa, String modelo, String ano, String portas) {
        super(placa, modelo, ano);
        this.portas = portas;
    }

    //public Carro(){};

    public String getPortas() {
        return portas;
    }

    public void setPortas(String portas) {
        this.portas = portas;
    }



        @Override
        public String toString() {
            return super.toString() +
                    " Carro{" +
                    "Portas ='" + portas +
                    '}';
        }

}
