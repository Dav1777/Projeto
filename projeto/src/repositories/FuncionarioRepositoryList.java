package repositories;

import models.Funcionario;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class FuncionarioRepositoryList implements FuncionarioRepository {

    private List<Funcionario> funcionarios;

    public void FuncionarioRepositoryList() {
        this.funcionarios = new ArrayList<>();
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        this.funcionarios.add(funcionario);
    }

    public Funcionario buscarFuncionario(String matricula){
        for (Funcionario funcionario : funcionarios){
            if (Objects.equals(funcionario.getMatricula(), matricula)){
                return funcionario;
            }
        }
        return null;
    }

    /*public void deletarFuncionario(String matricula){
        funcionarios.removeIf(funcionario -> funcionario.getMatricula().equals(matricula));
    }*/
    public boolean deletarFuncionario(String matricula){
        boolean removido = false;
        funcionarios.removeIf(funcionario -> funcionario.getMatricula().equals(matricula));
        return removido;
    }

    @Override
    public String listarFuncionarios() {
        return "";
    }

    @Override
    public void editarFuncionario(String funcionario) {

        for (int i = 0; i < funcionarios.size(); i++) {
            if (funcionarios.get(i).getMatricula().equals(funcionario.getMatricula())) {
                funcionarios.set(i, funcionario);
                System.out.println("Funcionário de matrícula " + funcionario.getMatricula() + " atualizado.");
                return;
            }
        }
        System.out.println("Funcionário de matrícula " + funcionario.getMatricula() + " não encontrado para atualização.");
    }
}
