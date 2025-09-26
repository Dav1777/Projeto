package service;

import models.Veiculo;
import repositories.VeiculoRepository;

import java.util.Scanner;

public class VeiculoService {

    private final VeiculoRepository repository;

    public VeiculoService(VeiculoRepository repository){
        this.repository = repository;
    }

    public void cadastrarVeiculo(Veiculo veiculo){
        if (veiculo.getPlaca() != null){
            repository.cadastrarVeiculo(veiculo);
        } else {
            System.out.println("Erro: Placa inválida para cadastro.");
        }
    }

    public Veiculo buscarVeiculo(String placa){
        if (placa == null){
            System.out.println("Erro: Placa não pode ser nula ou vazia para busca.");
            return null;
        }
        return repository.buscarVeiculo(placa);
    }

    public boolean deletarVeiculo(String placa){
        if (placa == null || placa.isEmpty()){
            System.out.println("Erro: Placa não pode ser nula ou vazia para deletar.");
            return false;
        }
        boolean deletadoComSucesso = repository.deletarVeiculo(placa);

        if (deletadoComSucesso){
            System.out.println("Veículo com placa " + placa + " deletado com sucesso.");
        }else {
            System.out.println("Erro: Veículo com placa " + placa + " não encontrado para deletar.");
        }
        return deletadoComSucesso;
    }

    public String listarVeiculos(){
        return repository.listarVeiculos();
    }

    public Veiculo editarVeiculo(String veiculo) {
        if (veiculo != null && veiculo.getPlaca() != null && !veiculo.getPlaca().isEmpty()) {
            repository.editarVeiculo(veiculo);
        } else {
            System.out.println("Erro: Dados do veiculo ou placa inválidos para edição.");
        }
        return null;
    }

    public void cadastrarVeiculo(VeiculoService veiculoService, Scanner scanner) {

        if (veiculo.getPlaca() != null){
            repository.cadastrarVeiculo(veiculo);
        } else {
            System.out.println("Erro: Placa inválida para cadastro.");
        }
    }
}
