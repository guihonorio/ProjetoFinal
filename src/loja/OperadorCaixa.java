package loja;

public class OperadorCaixa extends Funcionario {

    private int numeroCaixa;
    private String status;

    public OperadorCaixa(int id, String nome, String cpf, double salario,
                         String cargo, String senha, int numeroCaixa) {

        super(id, nome, cpf, salario, cargo, senha);

        this.numeroCaixa = numeroCaixa;
        this.status = "FECHADO";
    }

    public int getNumeroCaixa() {
        return numeroCaixa;
    }

    public void setNumeroCaixa(int numeroCaixa) {
        this.numeroCaixa = numeroCaixa;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public void abrirCaixa() {

        if (status.equals("FECHADO")) {
            status = "ABERTO";
            System.out.println("Caixa aberto com sucesso!");
        } else {
            System.out.println("O caixa já está aberto.");
        }
    }

    public void fecharCaixa() {

        if (status.equals("ABERTO")) {
            status = "FECHADO";
            System.out.println("Caixa fechado com sucesso!");
        } else {
            System.out.println("O caixa já está fechado.");
        }
    }

    @Override
    public void mostrarDados() {

        System.out.println("===== DADOS DO OPERADOR DE CAIXA =====");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.printf("Salário: R$ %.2f%n", getSalario());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Número do Caixa: " + numeroCaixa);
        System.out.println("Status do Caixa: " + status);
    }
}