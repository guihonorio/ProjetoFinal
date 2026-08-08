package loja;

public class OperadorCaixa extends Funcionario {

    private int numeroCaixa;
    private String statusCaixa;

    // Construtor
    public OperadorCaixa(int id, String nome, String cpf, double salario, String cargo,
                         int numeroCaixa) {

        super(id, nome, cpf, salario, cargo);

        this.numeroCaixa = numeroCaixa;
        this.statusCaixa = "FECHADO";
    }

    // Getters e Setters

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public String getStatusCaixa() {
        return statusCaixa;
    }

    // Abre o caixa
    public void abrirCaixa() {
        statusCaixa = "ABERTO";
        System.out.println("Caixa " + numeroCaixa + " aberto com sucesso!");
    }

    // Fecha o caixa
    public void fecharCaixa() {
        statusCaixa = "FECHADO";
        System.out.println("Caixa " + numeroCaixa + " fechado com sucesso!");
    }

    // Mostra os dados do operador e do caixa
    @Override
    public void mostrarDados() {

        System.out.println("===== DADOS DO OPERADOR DE CAIXA =====");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.printf("Salário: R$ %.2f%n", getSalario());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Número do Caixa: " + numeroCaixa);
        System.out.println("Status do Caixa: " + statusCaixa);
    }
}