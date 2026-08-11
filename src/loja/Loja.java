package loja;

import java.util.ArrayList;
import java.util.Scanner;

public class Loja {

    private ArrayList<Funcionario> funcionarios;
    private ArrayList<Pagamento> pagamentos;

public Loja() {
    funcionarios = new ArrayList<>();
    pagamentos = new ArrayList<>();

    Gerente gerenteInicial = new Gerente(
            1,
            "Administrador",
            "123.456.789-00",
            5000.00,
            "Gerente",
            "admin123",
            "Administracao",
            1000.00
    );

    funcionarios.add(gerenteInicial);
}
    private Funcionario realizarLogin(Scanner leia, String cargo) {

    System.out.println("\n===== LOGIN =====");

    System.out.print("ID: ");
    int id = leia.nextInt();
    leia.nextLine();

    System.out.print("Senha: ");
    String senha = leia.nextLine();

    for (Funcionario funcionario : funcionarios) {

        if (funcionario.getId() == id
                && funcionario.getSenha().equals(senha)
                && funcionario.getCargo().equals(cargo)) {

            System.out.println("\nLogin realizado com sucesso!");
            System.out.println("Bem-vindo(a), " + funcionario.getNome() + "!");

            return funcionario;
        }
    }

    System.out.println("\nID, senha ou perfil incorreto.");
    return null;
}
   private void acessarSistema(Scanner leia) {

    int opcao;

    do {

        System.out.println("\n===== ACESSAR SISTEMA =====");
        System.out.println("1 - Gerente");
        System.out.println("2 - Operador de Caixa");
        System.out.println("3 - Voltar");
        System.out.print("Escolha uma opção: ");

        opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:

                Funcionario gerente = realizarLogin(leia, "Gerente");

                if (gerente != null) {
                    menuGerente(leia, gerente);
                }

                break;

            case 2:

                Funcionario operador = realizarLogin(
                        leia,
                        "Operador de Caixa"
                );

                if (operador != null) {
                    menuOperador(leia, operador);
                }

                break;

            case 3:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcao != 3);
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

private void menuGerente(Scanner leia, Funcionario gerente) {

    int opcao;

    do {

        System.out.println("\n===== MENU DO GERENTE =====");
        System.out.println("1 - Cadastrar Funcionário");
        System.out.println("2 - Alterar Funcionário");
        System.out.println("3 - Listar Funcionários");
        System.out.println("4 - Listar Pagamentos");
        System.out.println("5 - Gerar Relatório de Vendas");
        System.out.println("6 - Voltar");
        System.out.print("Escolha uma opção: ");

        opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:
                cadastrarFuncionario(leia);
                break;

            case 2:
                alterarFuncionario(leia);
                break;

            case 3:
                listarFuncionarios();
                break;

            case 4:
                listarPagamentos();
                break;

            case 5:
                gerarRelatorioVendas();
                break;

            case 6:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcao != 6);
}
    
public void iniciar() {

    Scanner leia = new Scanner(System.in);

    int opcao;

    do {

        System.out.println("\n========================================");
        System.out.println("              LOJA JAVAVEIRA");
        System.out.println("========================================");
        System.out.println("1 - Acessar Sistema");
        System.out.println("2 - Sair");
        System.out.print("Escolha uma opção: ");

        opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:
                acessarSistema(leia);
                break;

            case 2:
                System.out.println("Sistema encerrado.");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcao != 2);

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

    System.out.print("Senha: ");
    String senha = leia.nextLine();

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
            senha,
            setor,
            bonus
    );

    adicionarFuncionario(gerente);
}

private void cadastrarFuncionario(Scanner leia) {

    int opcao;

    do {
        System.out.println("\n===== CADASTRAR FUNCIONÁRIO =====");
        System.out.println("1 - Gerente");
        System.out.println("2 - Operador de Caixa");
        System.out.println("3 - Voltar");
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
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcao != 3);
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

    System.out.print("Senha: ");
    String senha = leia.nextLine();

    System.out.print("Número do Caixa: ");
    int numeroCaixa = leia.nextInt();
    leia.nextLine();

    OperadorCaixa operador = new OperadorCaixa(
            id,
            nome,
            cpf,
            salario,
            "Operador de Caixa",
            senha,
            numeroCaixa
    );

    adicionarFuncionario(operador);
}
    
    private void alterarFuncionario(Scanner leia) {

    System.out.println("\n===== ALTERAR FUNCIONÁRIO =====");

    System.out.print("Digite o ID do funcionário: ");
    int id = leia.nextInt();
    leia.nextLine();

    Funcionario funcionarioEncontrado = null;

    for (Funcionario funcionario : funcionarios) {

        if (funcionario.getId() == id) {
            funcionarioEncontrado = funcionario;
            break;
        }
    }

    if (funcionarioEncontrado == null) {
        System.out.println("Funcionário não encontrado.");
        return;
    }

    int opcao;

    do {
        System.out.println("\n===== ALTERAR FUNCIONÁRIO =====");
        System.out.println("Funcionário: " + funcionarioEncontrado.getNome());
        System.out.println("1 - Alterar Nome");
        System.out.println("2 - Alterar CPF");
        System.out.println("3 - Alterar Salário");
        System.out.println("4 - Alterar Cargo");
        System.out.println("5 - Alterar Senha");
        System.out.println("6 - Voltar");
        System.out.print("Escolha uma opção: ");

        opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:
                System.out.print("Novo nome: ");
                String nome = leia.nextLine();
                funcionarioEncontrado.setNome(nome);
                System.out.println("Nome alterado com sucesso!");
                break;

            case 2:
                System.out.print("Novo CPF: ");
                String cpf = leia.nextLine();
                funcionarioEncontrado.setCpf(cpf);
                System.out.println("CPF alterado com sucesso!");
                break;

            case 3:
                System.out.print("Novo salário: ");
                double salario = leia.nextDouble();
                leia.nextLine();
                funcionarioEncontrado.setSalario(salario);
                System.out.println("Salário alterado com sucesso!");
                break;

            case 4:
                System.out.print("Novo cargo: ");
                String cargo = leia.nextLine();
                funcionarioEncontrado.setCargo(cargo);
                System.out.println("Cargo alterado com sucesso!");
                break;

            case 5:
                System.out.print("Nova senha: ");
                String senha = leia.nextLine();
                funcionarioEncontrado.setSenha(senha);
                System.out.println("Senha alterada com sucesso!");
                break;

            case 6:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcao != 6);
}
    
    private void menuOperador(Scanner leia, Funcionario funcionario) {

    OperadorCaixa operador = (OperadorCaixa) funcionario;

    int opcao;

    do {

        System.out.println("\n===== MENU DO OPERADOR DE CAIXA =====");
        System.out.println("1 - Abrir Caixa");
        System.out.println("2 - Realizar Pagamento");
        System.out.println("3 - Fechar Caixa");
        System.out.println("4 - Listar Pagamentos");
        System.out.println("5 - Voltar");
        System.out.print("Escolha uma opção: ");

        opcao = leia.nextInt();
        leia.nextLine();

        switch (opcao) {

            case 1:
                operador.abrirCaixa();
                break;

            case 2:
                realizarPagamento(leia, operador);
                break;

            case 3:
                operador.fecharCaixa();
                break;

            case 4:
                listarPagamentos();
                break;

            case 5:
                System.out.println("Voltando...");
                break;

            default:
                System.out.println("Opção inválida.");
        }

    } while (opcao != 5);
}
    
    private void gerarRelatorioVendas() {

    System.out.println("\n========================================");
    System.out.println("        RELATÓRIO DE VENDAS");
    System.out.println("========================================");

    if (pagamentos.isEmpty()) {
        System.out.println("Nenhuma venda registrada.");
        return;
    }

    double totalVendas = 0;

    for (Pagamento pagamento : pagamentos) {

        pagamento.mostrarPagamento();

        if ("APROVADO".equals(pagamento.getStatus())) {
            totalVendas += pagamento.getValor();
        }

        System.out.println("----------------------------------------");
    }

    System.out.printf("TOTAL DE VENDAS: R$ %.2f%n", totalVendas);
    System.out.println("========================================");
}
    
private void realizarPagamento(Scanner leia, OperadorCaixa operador) {

    if (operador.getStatus().equals("FECHADO")) {
        System.out.println("\nPagamento não realizado.");
        System.out.println("O caixa está fechado.");
        return;
    }

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