package repositories;

import models.Veiculo;

public interface VeiculoRepository {

    void cadastrarVeiculo(Veiculo veiculo);

    Veiculo buscarVeiculo(String id);

    boolean deletarVeiculo(String placa);

    String listarVeiculos();

    void editarVeiculo(String veiculo);
}
