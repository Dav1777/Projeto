package repositories;

import models.Funcionario;

public interface FuncionarioRepository {

    void cadastrarFuncionario (Funcionario funcionario);

    Funcionario buscarFuncionario (String id);

    boolean deletarFuncionario(String id);

    String listarFuncionarios();

    void editarFuncionario(String funcionario);
}
