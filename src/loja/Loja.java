package loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Caixa> caixas;
    private ArrayList<Pagamento> pagamentos;

    // Construtor
    public Loja() {
        funcionarios = new ArrayList<>();
        caixas = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    // Cadastra um funcionário
    public void cadastrarFuncionario(Funcionario funcionario) {
        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

    // Cadastra um caixa
    public void cadastrarCaixa(Caixa caixa) {
        caixas.add(caixa);
        System.out.println("Caixa cadastrado com sucesso!");
    }

    // Cadastra um pagamento
    public void cadastrarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
        System.out.println("Pagamento registrado com sucesso!");
    }

    // Lista todos os funcionários
    public void listarFuncionarios() {

        if (funcionarios.isEmpty()) {
            System.out.println("Nenhum funcionário cadastrado.");
            return;
        }

        System.out.println("\n===== FUNCIONÁRIOS CADASTRADOS =====");

        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDados();
            System.out.println();
        }
    }

    // Lista todos os caixas
    public void listarCaixas() {

        if (caixas.isEmpty()) {
            System.out.println("Nenhum caixa cadastrado.");
            return;
        }

        System.out.println("\n===== CAIXAS CADASTRADOS =====");

        for (Caixa caixa : caixas) {
            caixa.mostrarDados();
            System.out.println();
        }
    }

    // Lista todos os pagamentos
    public void listarPagamentos() {

        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento registrado.");
            return;
        }

        System.out.println("\n===== PAGAMENTOS REGISTRADOS =====");

        for (Pagamento pagamento : pagamentos) {
            pagamento.mostrarPagamento();
            System.out.println();
        }
    }

    // Menu principal
    public void executar() {

        Scanner scanner = new Scanner(System.in);

        int opcao;

        do {
            System.out.println("\n=================================");
            System.out.println("       SISTEMA DE PAGAMENTOS");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar Funcionário");
            System.out.println("2 - Cadastrar Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Listar Caixas");
            System.out.println("6 - Listar Pagamentos");
            System.out.println("7 - Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");

            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n===== CADASTRO DE FUNCIONÁRIO =====");

                    System.out.print("ID: ");
                    int idFuncionario = scanner.nextInt();
                    scanner.nextLine();

                    System.out.print("Nome: ");
                    String nome = scanner.nextLine();

                    System.out.print("CPF: ");
                    String cpf = scanner.nextLine();

                    System.out.print("Salário: ");
                    double salario = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Cargo: ");
                    String cargo = scanner.nextLine();

                    Funcionario funcionario = new Funcionario(
                            idFuncionario,
                            nome,
                            cpf,
                            salario,
                            cargo
                    );

                    cadastrarFuncionario(funcionario);
                    break;

                case 2:

                    if (funcionarios.isEmpty()) {
                        System.out.println(
                                "É necessário cadastrar um funcionário antes de cadastrar um caixa."
                        );
                        break;
                    }

                    System.out.println("\n===== CADASTRO DE CAIXA =====");

                    System.out.println("\nFuncionários disponíveis:");

                    for (Funcionario f : funcionarios) {
                        System.out.println(
                                "ID: " + f.getId()
                                + " | Nome: " + f.getNome()
                        );
                    }

                    System.out.print("Digite o ID do operador: ");
                    int idOperador = scanner.nextInt();

                    Funcionario operador = null;

                    for (Funcionario f : funcionarios) {
                        if (f.getId() == idOperador) {
                            operador = f;
                            break;
                        }
                    }

                    if (operador == null) {
                        System.out.println("Funcionário não encontrado.");
                        break;
                    }

                    Caixa caixa = new Caixa(operador);

                    cadastrarCaixa(caixa);

                    System.out.println("Deseja abrir o caixa agora? (S/N)");
                    String abrir = scanner.next();

                    if (abrir.equalsIgnoreCase("S")) {
                        caixa.abrirCaixa();
                    }

                    break;

                case 3:

                    System.out.println("\n===== REALIZAR PAGAMENTO =====");

                    System.out.print("Número do pagamento: ");
                    int numero = scanner.nextInt();

                    System.out.print("Valor da venda: ");
                    double valor = scanner.nextDouble();
                    scanner.nextLine();

                    System.out.print("Modalidade de pagamento: ");
                    String modalidade = scanner.nextLine();

                    Pagamento pagamento = new Pagamento(
                            numero,
                            valor,
                            modalidade
                    );

                    if (pagamento.realizarPagamento()) {
                        cadastrarPagamento(pagamento);
                    }

                    break;

                case 4:
                    listarFuncionarios();
                    break;

                case 5:
                    listarCaixas();
                    break;

                case 6:
                    listarPagamentos();
                    break;

                case 7:
                    System.out.println("\nSistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 7);

        scanner.close();
    }

    // Main
    public static void main(String[] args) {

        Loja loja = new Loja();

        loja.executar();
    }
}

