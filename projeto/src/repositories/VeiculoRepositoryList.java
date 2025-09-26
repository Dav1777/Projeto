package repositories;

import models.Veiculo;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class VeiculoRepositoryList implements VeiculoRepository{

    private List<Veiculo> veiculos;

    public void VeiculosRepositoryList(){
        this.veiculos = new ArrayList<>();
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        this.veiculos.add(veiculo);
    }

    public Veiculo buscarVeiculo(String placa){
        for (Veiculo veiculo : veiculos){
            if (Objects.equals(veiculo.getPlaca(), placa)){
                return veiculo;
            }
        }
        return null;
    }

    public boolean deletarVeiculo(String placa){
        /*boolean removido = false;
        veiculos.removeIf(veiculo -> veiculo.getPlaca().equals(placa));
        return removido;*/
        return veiculos.removeIf(veiculo -> veiculo.getPlaca().equals(placa));

    }

    @Override
    public String listarVeiculos() {
        return "";
    }

    @Override
    public void editarVeiculo(String veiculo) {

        for (int i = 0; i < veiculos.size(); i++) {
            if (veiculos.get(i).getPlaca().equals(veiculo.getPlaca())) {
                veiculos.set(i, veiculo);
                System.out.println("Veiculo de placa " + veiculo.getPlaca() + " atualizado.");
                return;
            }
        }
        System.out.println("Veiculo de placa " + veiculo.getPlaca() + " não encontrado para atualização.");
    }
}
