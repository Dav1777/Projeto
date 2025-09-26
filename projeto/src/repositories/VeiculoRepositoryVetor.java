package repositories;

import models.Veiculo;

import java.util.Arrays;

public class VeiculoRepositoryVetor implements VeiculoRepository {

    private Veiculo[] veiculos;

    public VeiculoRepositoryVetor(){
        this.veiculos = new Veiculo[10];
    }

    @Override
    public void cadastrarVeiculo(Veiculo veiculo){
        for (int i = 0; i < veiculos.length; i++){
            if (veiculos[i] == null){
                veiculos[i] = veiculo;
                break;
            }
        }
    }

    @Override
    public Veiculo buscarVeiculo(String placa){

        for (int i = 0; i < veiculos.length; i++){
            /*if (veiculos[i].getPlaca().equals(placa)){
                return veiculos[i];
            }*/
            if (veiculos[i] != null && veiculos[i].getPlaca().equals(placa)){
                return veiculos[i];
            }
        }
        return null;
    }

    @Override
    public boolean deletarVeiculo(String placa) {
        for (int i = 0; i < veiculos.length; i++){
            /*if(veiculos[i].getPlaca().equals(placa)){
                veiculos[i] = null;
                break;*/
            if(veiculos[i] != null && veiculos[i].getPlaca().equals(placa)){
                veiculos[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String listarVeiculos(){
        return Arrays.toString(this.veiculos);
    }

    @Override
    public void editarVeiculo(String veiculo) {
        for (int i = 0; i < veiculos.length; i++) {
            if (veiculos[i] != null && veiculos[i].getPlaca().equals(veiculo.getPlaca())) {
                veiculos[i] = veiculo;
                System.out.println("Veiculo de placa " + veiculo.getPlaca() + " atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Veiculo de placa " + veiculo.getPlaca() + " não encontrado para atualização.");
    }
}