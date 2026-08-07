package loja;

public class Caixa {

    private Funcionario operador;
    private String status;

    // Construtor
    public Caixa(Funcionario operador) {
        this.operador = operador;
        this.status = "FECHADO";
    }

    // Getter e Setter do operador

    public Funcionario getOperador() {
        return operador;
    }

    public void setOperador(Funcionario operador) {
        this.operador = operador;
    }

    // Getter do status

    public String getStatus() {
        return status;
    }

    // Abre o caixa
    public void abrirCaixa() {
        status = "ABERTO";
        System.out.println("Caixa aberto com sucesso!");
    }

    // Fecha o caixa
    public void fecharCaixa() {
        status = "FECHADO";
        System.out.println("Caixa fechado com sucesso!");
    }

    // Exibe os dados do caixa
    public void mostrarDados() {
        System.out.println("===== DADOS DO CAIXA =====");
        System.out.println("Operador: " + operador.getNome());
        System.out.println("Status: " + status);
    }
}
