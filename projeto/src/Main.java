import models.*;
import repositories.*;
import service.*;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        VeiculoRepository veiculoRepository = new VeiculoRepositoryVetor();
        VeiculoService veiculoService = new VeiculoService(veiculoRepository);

        FuncionarioRepository funcionarioRepository = new FuncionarioRepositoryVetor();
        FuncionarioService funcionarioService = new FuncionarioService(funcionarioRepository);

        AluguelRepository aluguelRepository = new AluguelRepositoryVetor();
        AluguelService alugarService = new AluguelService(aluguelRepository);

        Scanner scanner = new Scanner(System.in);

        int opcao = 0;
        while (opcao != 4) {
            System.out.println("--- Menu Principal ---");
            System.out.println("1. Gerenciar Veículos");
            System.out.println("2. Gerenciar Funcionários");
            System.out.println("3. Sair");
            System.out.println("----------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());

                switch (opcao) {
                    case 1:
                        menuVeiculos(veiculoService, scanner);
                        break;
                    case 2:
                        menuFuncionarios(funcionarioService, scanner);
                        break;
                    /*case 3:
                        menuAluguel(alugarService, scanner);
                        break;*/
                    case 4:
                        System.out.println("Encerrando transmissão.");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
                opcao = 0;
            }
            System.out.println();
        }

        scanner.close();
    }

    private static void menuVeiculos(VeiculoService veiculoService, Scanner scanner) {

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- Gerenciamento de Veículos ---");
            System.out.println("1. Cadastrar Veículo");
            System.out.println("2. Buscar Veículo por Placa");
            System.out.println("3. Deletar Veículo por Placa");
            System.out.println("4. Listar Todos os Veículos");
            System.out.println("5. Editar um Veículo");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        veiculoService.cadastrarVeiculo(veiculoService, scanner);
                        break;
                    case 2:
                        buscarVeiculo(veiculoService, scanner);
                        break;
                    case 3:
                        deletarVeiculo(veiculoService, scanner);
                        break;
                    case 4:
                        listarVeiculo(veiculoService);
                        break;
                    case 5:
                        editarVeiculo(veiculoService, scanner);
                        break;
                    case 6:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
            System.out.println();
        }
    }

    private static void menuFuncionarios(FuncionarioService funcionarioService, Scanner scanner) {

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- Gerenciamento de Funcionários  ---");
            System.out.println("1. Cadastrar Funcionários ");
            System.out.println("2. Buscar Funcionários por Placa");
            System.out.println("3. Deletar Funcionários por CPF");
            System.out.println("4. Listar Todos os Funcionários ");
            System.out.println("5. Editar um Funcionários ");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        cadastrarFuncionario(funcionarioService, scanner);
                        break;
                    case 2:
                        buscarFuncionario(funcionarioService, scanner);
                        break;
                    case 3:
                        deletarFuncionario(funcionarioService, scanner);
                        break;
                    case 4:
                        listarFuncionario(funcionarioService);
                        break;
                    case 5:
                        editarFuncionario(funcionarioService, scanner);
                        break;
                    case 6:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
            System.out.println();
        }
    }

    /*private static void menuAluguel(AluguelService aluguelService, Scanner scanner) {

        int opcao = 0;

        while (opcao != 6) {
            System.out.println("\n--- Gerenciamento de Alugueis ---");
            System.out.println("1. Cadastrar aluguel");
            System.out.println("2. Buscar aluguel por id");
            System.out.println("3. Deletar aluguel por id");
            System.out.println("4. Listar Todos os Alugueis");
            System.out.println("5. Editar Aluguel");
            System.out.println("6. Voltar ao Menu Principal");
            System.out.println("---------------------------------");
            System.out.print("Escolha uma opção: ");

            try {
                opcao = Integer.parseInt(scanner.nextLine());
                switch (opcao) {
                    case 1:
                        cadastrarAluguel(aluguelService, scanner);
                        break;
                    case 2:
                        buscarVeiculo(aluguelService, scanner);
                        break;
                    case 3:
                        deletarVeiculo(aluguelService, scanner);
                        break;
                    case 4:
                        listarVeiculo(aluguelService);
                        break;
                    case 5:
                        editarVeiculo(aluguelService, scanner);
                        break;
                    case 6:
                        System.out.println("Retornando ao menu principal...");
                        break;
                    default:
                        System.out.println("Opção inválida. Tente novamente.");
                }
            }catch (NumberFormatException e){
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }
            System.out.println();
        }
    }


    private static void cadastrarVeiculo(VeiculoService service, Scanner scanner) {
        System.out.println("\n--- Cadastrar Novo Veículo ---");
        System.out.println("Qual tipo de veículo deseja cadastrar?");
        System.out.println("1. Carro");
        System.out.println("2. Caminhão");
        //System.out.println("3. Moto");
        System.out.print("Escolha uma opção: ");

        int tipo = Integer.parseInt(scanner.nextLine());

        System.out.print("Digite a placa do veículo: ");
        String placa = scanner.nextLine();
        System.out.print("Digite o modelo do veículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Digite o ano do veículo (apenas números): ");
        String ano = scanner.nextLine();

        Veiculo novoVeiculo = null;

        switch (tipo) {
            case 1:
                System.out.print("Digite o número de portas: ");
                String portas = (scanner.nextLine());
                novoVeiculo = new Carro(placa, modelo, ano, portas);
                break;
            case 2:
                System.out.print("Digite a carga máxima: ");
                double cargaMax = Double.parseDouble(scanner.nextLine());
                novoVeiculo = new Caminhao(placa, modelo, ano, cargaMax);
                break;
            case 3:
                System.out.print("A moto tem baú? (S/N): ");
                boolean temBau = scanner.nextLine().equalsIgnoreCase("S");
                novoVeiculo = new Moto(placa, modelo, ano, temBau);
                break;
            default:
                System.out.println("Opção de veículo inválida. Cadastro cancelado.");
                return;
        }
    }*/

    private static void buscarVeiculo(VeiculoService service, Scanner scanner) {
        System.out.println("\n--- Buscar Veículo ---");
        System.out.print("Digite a placa do veículo a ser buscado: ");
        String placa = scanner.nextLine();

        Veiculo veiculoEncontrado = service.buscarVeiculo(placa);

        if (veiculoEncontrado != null) {
            System.out.println("Veículo encontrado:");
            System.out.println("  Placa: " + veiculoEncontrado.getPlaca());
        } else {
            System.out.println("Veículo com placa '" + placa + "' não encontrado.");
        }
    }

    private static void deletarVeiculo(VeiculoService service, Scanner scanner) {
        System.out.println("\n--- Deletar Veículo ---");
        System.out.print("Digite a placa do veículo a ser deletado: ");
        String placa = scanner.nextLine();

        Veiculo veiculoParaDeletar = service.buscarVeiculo(placa);

        if (veiculoParaDeletar != null) {
            boolean deletado = service.deletarVeiculo(placa);
            if (deletado) {
                System.out.println("Veículo com placa '" + placa + "' deletado com sucesso.");
            } else {
                System.out.println("Não foi possível deletar o veículo com placa '" + placa + "'.");
            }
        }
    }

    private static void listarVeiculo(VeiculoService service) {
        System.out.println("\n--- Lista de Todos os Veículos ---");

        String todosVeiculos = service.listarVeiculos();

        if (todosVeiculos.isEmpty()) {
            System.out.println("Nenhum veículo cadastrado no sistema.");
        } else {
            System.out.println(todosVeiculos);
        }
    }

    private static void editarVeiculo(VeiculoService service, Scanner scanner) {
        System.out.println("\n--- Editar Veículo ---");
        System.out.print("Digite a placa do veículo a ser editado: ");
        String placa = scanner.nextLine();

        Veiculo veiculoParaEditar = service.editarVeiculo(placa);

        if (veiculoParaEditar != null) {
            System.out.println("Veículo encontrado! Digite os novos dados (ou pressione Enter para manter o atual):");

            System.out.print("Novo modelo (" + veiculoParaEditar.getModelo() + "): ");
            String novoModelo = scanner.nextLine();
            if (!novoModelo.isEmpty()) {
                veiculoParaEditar.setModelo(novoModelo);
            }

            System.out.print("Novo ano (" + veiculoParaEditar.getAno() + "): ");
            String novoAnoStr = scanner.nextLine();
            if (!novoAnoStr.isEmpty()) {
                try {
                    int novoAno = Integer.parseInt(novoAnoStr);
                    veiculoParaEditar.setAno(String.valueOf(novoAno));
                } catch (NumberFormatException e) {
                    System.out.println("Ano inválido. O ano não foi alterado.");
                }
            }

            switch (veiculoParaEditar) {
                case Carro carro -> {
                    System.out.print("Novo número de portas (" + carro.getPortas() + "): ");
                    String novasPortasStr = scanner.nextLine();
                    if (!novasPortasStr.isEmpty()) {
                        try {
                            int novasPortas = Integer.parseInt(novasPortasStr);
                            carro.setPortas(String.valueOf(novasPortas));
                        } catch (NumberFormatException e) {
                            System.out.println("Número de portas inválido. O campo não foi alterado.");
                        }
                    }
                }
                case Caminhao caminhao -> {
                    System.out.print("Nova carga máxima (" + caminhao.getCargaMax() + "): ");
                    String novaCargaStr = scanner.nextLine();
                    if (!novaCargaStr.isEmpty()) {
                        try {
                            double novaCarga = Double.parseDouble(novaCargaStr);
                            caminhao.setCargaMax(String.valueOf(novaCarga));
                        } catch (NumberFormatException e) {
                            System.out.println("Carga máxima inválida. O campo não foi alterado.");
                        }
                    }
                }
                /*case Moto moto -> {
                    System.out.print("A moto tem baú? (S/N) (" + (moto.isTemBau() ? "S" : "N") + "): ");
                    String temBauStr = scanner.nextLine();
                    if (!temBauStr.isEmpty()) {
                        moto.TemBau(temBauStr.equalsIgnoreCase("S"));
                    }
                }*/
                default -> {
                }
            }
            System.out.println("Veículo atualizado com sucesso!");
        } else {
            System.out.println("Veículo com placa '" + placa + "' não encontrado.");
        }
    }

    private static void cadastrarFuncionario(FuncionarioService service, Scanner scanner) {
        System.out.println("\n--- Cadastrar Novo Funcionario ---");
        System.out.print("Digite o nome do Funcionario: ");
        String nome = scanner.nextLine();
        System.out.println("Digite a matricula do Funcionario: ");
        String matricula = scanner.nextLine();
        System.out.println("Digite o cpf do funcionario; ");
        String cpf = scanner.nextLine();

        Funcionario novoFuncionario = new Funcionario(nome, matricula, cpf);

        service.cadastrarFuncionario(novoFuncionario);
        System.out.println("Funcionario de matricula '" + matricula + "' cadastrado com sucesso!");
    }

    private static void buscarFuncionario(FuncionarioService service, Scanner scanner) {
        System.out.println("\n--- Buscar Funcionario ---");
        System.out.print("Digite a matricula do funcionario a ser buscado: ");
        String matricula = scanner.nextLine();

        Funcionario funcionarioEncontrado = service.buscarFuncionario(matricula);

        if (funcionarioEncontrado != null) {
            System.out.println("Funcionario encontrado:");
            System.out.println("  Matricula: " + funcionarioEncontrado.getMatricula());
        } else {
            System.out.println("Funcionario de matricula '" + matricula + "' não encontrado.");
        }
    }

    private static void deletarFuncionario(FuncionarioService service, Scanner scanner) {
        System.out.println("\n--- Deletar Funcionario ---");
        System.out.print("Digite o cpf a ser deletado: ");
        String cpf = scanner.nextLine();

        Funcionario funcionarioParaDeletar = service.buscarFuncionario(cpf);

        if (funcionarioParaDeletar != null) {
            boolean deletado = service.deletarFuncionario(cpf);
            if (deletado) {
                System.out.println("Funcionario com cpf '" + cpf + "' deletado com sucesso.");
            } else {
                System.out.println("Não foi possível deletar funcionario de cpf '" + cpf + "'.");
            }
        }
    }

    private static void listarFuncionario(FuncionarioService service) {
        System.out.println("\n--- Lista de Todos os Funcionarios ---");

        String todosFuncionarios = service.listarFuncionarios();

        if (todosFuncionarios.isEmpty()) {
            System.out.println("Nenhum funcionario cadastrado no sistema.");
        } else {
            System.out.println(todosFuncionarios);
        }
    }

    private static void editarFuncionario(FuncionarioService service, Scanner scanner) {
        System.out.println("\n--- Editar Funcionário ---");
        System.out.print("Digite a matrícula do funcionário a ser editado: ");
        String matricula = scanner.nextLine();

        Funcionario funcionarioParaEditar = service.editarFuncionario(matricula);

        if (funcionarioParaEditar != null) {
            System.out.println("Funcionário encontrado! Digite os novos dados (ou pressione Enter para manter o atual):");

            System.out.print("Novo nome (" + funcionarioParaEditar.getNome() + "): ");
            String novoNome = scanner.nextLine();
            if (!novoNome.isEmpty()) {
                funcionarioParaEditar.setNome(novoNome);
            }

            System.out.println("Funcionário atualizado com sucesso!");
        } else {
            System.out.println("Funcionário com matrícula '" + matricula + "' não encontrado.");
        }
    }
}