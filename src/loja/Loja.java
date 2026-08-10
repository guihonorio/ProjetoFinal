package loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamento> pagamentos;

    public Loja() {
        funcionarios = new ArrayList<>();
        pagamentos = new ArrayList<>();
    }
    
    public void adicionarFuncionario(Funcionario funcionario) {

        for (Funcionario f : funcionarios) {

            if (f.getId() == funcionario.getId()) {
                System.out.println("Erro: já existe um funcionário com esse ID.");
                return;
            }
        }

        funcionarios.add(funcionario);
        System.out.println("Funcionário cadastrado com sucesso!");
    }

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

    public void adicionarPagamento(Pagamento pagamento) {

        pagamentos.add(pagamento);

        System.out.println("Pagamento registrado com sucesso!");
    }

    public void listarPagamentos() {

        if (pagamentos.isEmpty()) {
            System.out.println("Nenhum pagamento cadastrado.");
            return;
        }

        System.out.println("\n===== PAGAMENTOS REGISTRADOS =====");

        for (Pagamento pagamento : pagamentos) {
            pagamento.mostrarPagamento();
            System.out.println();
        }
    }

    public void iniciar() {

        Scanner leia = new Scanner(System.in);

        int opcao;

        do {

            System.out.println("\n===== BEM VINDO AO PDV =====");
            System.out.println("1 - Cadastrar Gerente");
            System.out.println("2 - Cadastrar Operador de Caixa");
            System.out.println("3 - Realizar Pagamento");
            System.out.println("4 - Listar Funcionários");
            System.out.println("5 - Listar Pagamentos");
            System.out.println("6 - Sair");
            System.out.print("Escolha uma opção: ");

            opcao = leia.nextInt();
            leia.nextLine();

            switch (opcao) {

                case 1:
                    cadastrarGerente(leia);
                    break;

                case 2:
                    cadastrarOperadorCaixa(leia);
                    break;

                case 3:
                    realizarPagamento(leia);
                    break;

                case 4:
                    listarFuncionarios();
                    break;

                case 5:
                    listarPagamentos();
                    break;

                case 6:
                    System.out.println("Sistema encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 6);

        leia.close();
    }

    private void cadastrarGerente(Scanner leia) {

        System.out.println("\n===== CADASTRO DE GERENTE =====");

        System.out.print("ID: ");
        int id = leia.nextInt();
        leia.nextLine();

        System.out.print("Nome: ");
        String nome = leia.nextLine();

        System.out.print("CPF: ");
        String cpf = leia.nextLine();

        System.out.print("Salário: ");
        double salario = leia.nextDouble();
        leia.nextLine();

        System.out.print("Setor: ");
        String setor = leia.nextLine();

        System.out.print("Bônus: ");
        double bonus = leia.nextDouble();
        leia.nextLine();

        Gerente gerente = new Gerente(
                id,
                nome,
                cpf,
                salario,
                "Gerente",
                setor,
                bonus
        );

        adicionarFuncionario(gerente);
    }

    private void cadastrarOperadorCaixa(Scanner leia) {

        System.out.println("\n===== CADASTRO DE OPERADOR DE CAIXA =====");

        System.out.print("ID: ");
        int id = leia.nextInt();
        leia.nextLine();

        System.out.print("Nome: ");
        String nome = leia.nextLine();

        System.out.print("CPF: ");
        String cpf = leia.nextLine();

        System.out.print("Salário: ");
        double salario = leia.nextDouble();
        leia.nextLine();

        System.out.print("Número do Caixa: ");
        int numeroCaixa = leia.nextInt();
        leia.nextLine();

        OperadorCaixa operador = new OperadorCaixa(
                id,
                nome,
                cpf,
                salario,
                "Operador de Caixa",
                numeroCaixa
        );

        adicionarFuncionario(operador);
    }

    private void realizarPagamento(Scanner leia) {

        System.out.println("\n===== FORMA DE PAGAMENTO =====");
        System.out.println("1 - PIX");
        System.out.println("2 - Boleto");
        System.out.println("3 - Cartão");
        System.out.print("Escolha uma opção: ");

        int opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:
                realizarPix(leia);
                break;

            case 2:
                realizarBoleto(leia);
                break;

            case 3:
                realizarCartao(leia);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private void realizarPix(Scanner leia) {

        System.out.println("\n===== PAGAMENTO PIX =====");

        System.out.print("Número do pagamento: ");
        int numero = leia.nextInt();

        System.out.print("Valor: ");
        double valor = leia.nextDouble();
        leia.nextLine();

        System.out.print("Chave PIX: ");
        String chavePix = leia.nextLine();

        Pix pix = new Pix(numero, valor, chavePix);

        if (pix.realizarPagamento()) {

            adicionarPagamento(pix);

            System.out.println("\nPagamento aprovado!");
            pix.mostrarPagamento();
        }
    }

    private void realizarBoleto(Scanner leia) {

        System.out.println("\n===== PAGAMENTO POR BOLETO =====");

        System.out.print("Número do pagamento: ");
        int numero = leia.nextInt();

        System.out.print("Valor: ");
        double valor = leia.nextDouble();
        leia.nextLine();

        System.out.print("Código de barras: ");
        String codigoBarras = leia.nextLine();

        Boleto boleto = new Boleto(
                numero,
                valor,
                codigoBarras
        );

        if (boleto.realizarPagamento()) {

            adicionarPagamento(boleto);

            System.out.println("\nPagamento aprovado!");
            boleto.mostrarPagamento();
        }
    }

    private void realizarCartao(Scanner leia) {

        System.out.println("\n===== TIPO DE CARTÃO =====");
        System.out.println("1 - Débito");
        System.out.println("2 - Crédito");
        System.out.print("Escolha uma opção: ");

        int opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:
                realizarDebito(leia);
                break;

            case 2:
                realizarCredito(leia);
                break;

            default:
                System.out.println("Opção inválida.");
        }
    }

    private void realizarDebito(Scanner leia) {

        System.out.println("\n===== PAGAMENTO COM CARTÃO DE DÉBITO =====");

        System.out.print("Número do pagamento: ");
        int numero = leia.nextInt();

        System.out.print("Valor: ");
        double valor = leia.nextDouble();
        leia.nextLine();

        System.out.print("Número do cartão: ");
        String numeroCartao = leia.nextLine();

        System.out.print("Nome do titular: ");
        String nomeTitular = leia.nextLine();

        System.out.print("Bandeira: ");
        String bandeira = leia.nextLine();

        System.out.print("CVV: ");
        String cvv = leia.nextLine();

        System.out.print("Saldo disponível: ");
        double saldo = leia.nextDouble();
        leia.nextLine();

        System.out.print("Senha: ");
        String senha = leia.nextLine();

        CartaoDebito debito = new CartaoDebito(
                numero,
                valor,
                numeroCartao,
                nomeTitular,
                bandeira,
                cvv,
                saldo,
                senha
        );

        if (debito.realizarPagamento()) {

            adicionarPagamento(debito);

            System.out.println("\nPagamento aprovado!");
            debito.mostrarPagamento();
        }
    }

    private void realizarCredito(Scanner leia) {

        System.out.println("\n===== PAGAMENTO COM CARTÃO DE CRÉDITO =====");

        System.out.print("Número do pagamento: ");
        int numero = leia.nextInt();

        System.out.print("Valor: ");
        double valor = leia.nextDouble();
        leia.nextLine();

        System.out.print("Número do cartão: ");
        String numeroCartao = leia.nextLine();

        System.out.print("Nome do titular: ");
        String nomeTitular = leia.nextLine();

        System.out.print("Bandeira: ");
        String bandeira = leia.nextLine();

        System.out.print("CVV: ");
        String cvv = leia.nextLine();

        System.out.print("Limite disponível: ");
        double limite = leia.nextDouble();
        leia.nextLine();

        System.out.println("\n1 - À vista");
        System.out.println("2 - Parcelado");
        System.out.print("Escolha uma opção: ");

        int tipoPagamento = leia.nextInt();

        CartaoCredito credito;

        if (tipoPagamento == 1) {

            credito = new CartaoCredito(
                    numero,
                    valor,
                    numeroCartao,
                    nomeTitular,
                    bandeira,
                    cvv,
                    limite
            );

        } else if (tipoPagamento == 2) {

            System.out.print("Quantidade de parcelas: ");
            int parcelas = leia.nextInt();

            credito = new CartaoCredito(
                    numero,
                    valor,
                    numeroCartao,
                    nomeTitular,
                    bandeira,
                    cvv,
                    limite,
                    parcelas
            );

        } else {

            System.out.println("Opção inválida.");
            return;
        }

        if (credito.realizarPagamento()) {

            adicionarPagamento(credito);

            System.out.println("\nPagamento aprovado!");
            credito.mostrarPagamento();
        }
    }
}