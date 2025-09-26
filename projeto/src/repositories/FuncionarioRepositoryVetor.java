package repositories;

import models.Funcionario;

import java.util.Arrays;

public class FuncionarioRepositoryVetor implements FuncionarioRepository {

    private Funcionario[] funcionarios;

    public FuncionarioRepositoryVetor(){
        this.funcionarios = new Funcionario[20];
    }

    @Override
    public void cadastrarFuncionario(Funcionario funcionario){
        for (int i = 0; i < funcionarios.length; i++){
            if (funcionarios[i] == null){
                funcionarios[i] = funcionario;
                break;
            }
        }
    }

    @Override
    public Funcionario buscarFuncionario(String matricula){

        for (int i = 0; i < funcionarios.length; i++){
            /*if (funcionarios[i].getMatricula().equals(matricula)){
                return  funcionarios[i];
            }*/ if (funcionarios[i] != null && funcionarios[i].getMatricula().equals(matricula)){
                return funcionarios[i];
            }
        }
        return null;
    }

    @Override
    public boolean deletarFuncionario(String cpf){
        for (int i = 0; i < funcionarios.length; i++){
            /*if (funcionarios[i].getMatricula().equals(matricula)){
                funcionarios[i] = null;
                break;*/
            if(funcionarios[i] != null && funcionarios[i].getMatricula().equals(cpf)){
                funcionarios[i] = null;
                return true;
            }
        }
        return false;
    }

    @Override
    public String listarFuncionarios(){
        return Arrays.toString(this.funcionarios);
    }

    @Override
    public void editarFuncionario(String funcionario) {
        for (int i = 0; i < funcionarios.length; i++) {
            if (funcionarios[i] != null && funcionarios[i].getMatricula().equals(funcionario.getMatricula())) {
                funcionarios[i] = funcionario;
                System.out.println("Funcionário de matrícula " + funcionario.getMatricula() + " atualizado com sucesso!");
                return;
            }
        }
        System.out.println("Funcionário de matrícula " + funcionario.getMatricula() + " não encontrado para atualização.");
    }
}
