package service;

import models.Funcionario;
import repositories.FuncionarioRepository;

public class FuncionarioService {

    private final FuncionarioRepository repository;

    public FuncionarioService(FuncionarioRepository repository){
        this.repository = repository;
    }

    public void cadastrarFuncionario(Funcionario funcionario){
        if (funcionario.getMatricula() != null){
            repository.cadastrarFuncionario(funcionario);
        }else {
            System.out.println("Erro: Matricula inválida para cadastro.");
        }
    }

    public Funcionario buscarFuncionario(String matricula){
        if (matricula == null){
            System.out.println("Erro: Matricula não pode ser nula para busca.");
            return null;
        }
        return repository.buscarFuncionario(matricula);
    }

    public boolean deletarFuncionario(String matricula){
        if (matricula == null || matricula.isEmpty()){
            System.out.println("Erro: Matricula não pode ser nulo para deletar.");
            return false;
        }
        boolean deletadoComSucesso = repository.deletarFuncionario(matricula);

        if (deletadoComSucesso){
            System.out.println("Funcionario de cpf " + matricula + "deletado com sucesso.");
        }else {
            System.out.println("Erro: Funcionário de cpf " + matricula + " não encontrado,");
        }
        return deletadoComSucesso;
    }

    public String listarFuncionarios(){
        return repository.listarFuncionarios();
    }

    public Funcionario editarFuncionario(String funcionario) {
        if (!(funcionario == null || funcionario.getMatricula() == null || funcionario.getMatricula().isEmpty())) {
            repository.editarFuncionario(funcionario);
        } else {
            System.out.println("Erro: Dados do funcionário ou matrícula inválidos para edição.");
        }
        return null;
    }
}
