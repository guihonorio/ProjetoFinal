package loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamento> pagamentos;

    // Construtor
    public Loja() {
        funcionarios = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }

    // Cadastra um funcionário na lista
    public boolean adicionarFuncionario(Funcionario funcionario) {

        // Verifica se já existe funcionário com o mesmo ID
        for (Funcionario f : funcionarios) {
            if (f.getId() == funcionario.getId()) {
                System.out.println("Erro: já existe um funcionário com esse ID.");
                return false;
            }
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");

        return true;
    }

    // Lista todos os funcionários
    public void listarFuncionarios() {

        if (funcionarios.isEmpty()) {
            System.out.println("Não existem funcionários cadastrados.");
            return;
        }

        System.out.println("\n===== FUNCIONÁRIOS CADASTRADOS =====");

        for (Funcionario funcionario : funcionarios) {
            funcionario.mostrarDados();
            System.out.println();
        }
    }

    // Cadastra um pagamento
    public void adicionarPagamento(Pagamento pagamento) {
        pagamentos.add(pagamento);
    }

    // Lista todos os pagamentos
    public void listarPagamentos() {

        if (pagamentos.isEmpty()) {
            System.out.println("Não existem pagamentos cadastrados.");
            return;
        }

        System.out.println("\n===== PAGAMENTOS REALIZADOS =====");

        for (Pagamento pagamento : pagamentos) {
            pagamento.mostrarPagamento();
            System.out.println();
        }
    }

    // Menu principal
    public void executar() {

        Scanner leia = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n=================================");
            System.out.println("       SISTEMA DA LOJA");
            System.out.println("=================================");
            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Cadastrar Operador de Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Listar Pagamentos");
            System.out.println("6 - Sair");
            System.out.println("=================================");
            System.out.print("Escolha uma opção: ");

            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {

                case 1:

                    System.out.println("\n===== CADASTRO DE GERENTE =====");

                    System.out.print("ID: ");
                    int idGerente = leia.nextInt();
                    leia.nextLine();

                    System.out.print("Nome: ");
                    String nomeGerente = leia.nextLine();

                    System.out.print("CPF: ");
                    String cpfGerente = leia.nextLine();

                    System.out.print("Salário: ");
                    double salarioGerente = leia.nextDouble();
                    leia.nextLine();

                    System.out.print("Setor: ");
                    String setor = leia.nextLine();

                    System.out.print("Bônus: ");
                    double bonus = leia.nextDouble();
                    leia.nextLine();

                    Gerente gerente = new Gerente(
                            idGerente,
                            nomeGerente,
                            cpfGerente,
                            salarioGerente,
                            "Gerente",
                            setor,
                            bonus
                    );

                    adicionarFuncionario(gerente);

                    break;

                case 2:

                    System.out.println("\n===== CADASTRO DE OPERADOR DE CAIXA =====");

                    System.out.print("ID: ");
                    int idOperador = leia.nextInt();
                    leia.nextLine();

                    System.out.print("Nome: ");
                    String nomeOperador = leia.nextLine();

                    System.out.print("CPF: ");
                    String cpfOperador = leia.nextLine();

                    System.out.print("Salário: ");
                    double salarioOperador = leia.nextDouble();

                    System.out.print("Número do Caixa: ");
                    int numeroCaixa = leia.nextInt();
                    leia.nextLine();

                    OperadorCaixa operador = new OperadorCaixa(
                            idOperador,
                            nomeOperador,
                            cpfOperador,
                            salarioOperador,
                            "Operador de Caixa",
                            numeroCaixa
                    );

                    adicionarFuncionario(operador);

                    break;

                case 3:

                    System.out.println("\n===== REALIZAR PAGAMENTO =====");

                    System.out.print("Número do pagamento: ");
                    int numeroPagamento = leia.nextInt();

                    System.out.print("Valor: ");
                    double valor = leia.nextDouble();
                    leia.nextLine();

                    System.out.print("Modalidade de pagamento: ");
                    String modalidade = leia.nextLine();

                    Pagamento pagamento = new Pagamento(
                            numeroPagamento,
                            valor,
                            modalidade
                    );

                    if (pagamento.realizarPagamento()) {
                        adicionarPagamento(pagamento);
                        System.out.println("Pagamento realizado com sucesso!");
                    }

                    break;

                case 4:

                    listarFuncionarios();

                    break;

                case 5:

                    listarPagamentos();

                    break;

                case 6:

                    System.out.println("Sistema encerrado. Até logo!");

                    break;

                default:

                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 6);

        leia.close();
    }

    // Método principal
    public static void main(String[] args) {

        Loja loja = new Loja();

        loja.executar();
    }
}