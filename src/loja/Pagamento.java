package loja;

public class Pagamento {

    private int numero;
    private double valor;
    private String modalidade;
    private String status;

    // Construtor
    public Pagamento(int numero, double valor, String modalidade) {
        this.numero = numero;
        this.valor = valor;
        this.modalidade = modalidade;
        this.status = "PENDENTE";
    }

    // Getters e Setters

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getModalidade() {
        return modalidade;
    }

    public void setModalidade(String modalidade) {
        this.modalidade = modalidade;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    // Realiza o pagamento
    public boolean realizarPagamento() {

        if (valor <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return false;
        }

        if (modalidade == null || modalidade.trim().isEmpty()) {
            System.out.println("Erro: informe uma modalidade de pagamento.");
            return false;
        }

        status = "APROVADO";

        System.out.println("Pagamento realizado com sucesso!");

        return true;
    }

    // Exibe os dados do pagamento
    public void mostrarPagamento() {
        System.out.println("===== DADOS DO PAGAMENTO =====");
        System.out.println("Número: " + numero);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Modalidade: " + modalidade);
        System.out.println("Status: " + status);
    }
}

