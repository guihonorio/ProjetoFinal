package loja;

public class Pagamento {

    private int numeroPagamento;
    private double valor;
    private String modalidadePagamento;
    private String status;

    // Construtor
    public Pagamento(int numeroPagamento, double valor, String modalidadePagamento) {
        this.numeroPagamento = numeroPagamento;
        this.valor = valor;
        this.modalidadePagamento = modalidadePagamento;
        this.status = "PENDENTE";
    }

    // Getters e Setters

    public int getNumeroPagamento() {
        return numeroPagamento;
    }

    public void setNumeroPagamento(int numeroPagamento) {
        this.numeroPagamento = numeroPagamento;
    }

    public double getValor() {
        return valor;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }

    public String getModalidadePagamento() {
        return modalidadePagamento;
    }

    public void setModalidadePagamento(String modalidadePagamento) {
        this.modalidadePagamento = modalidadePagamento;
    }

    public String getStatus() {
        return status;
    }

    // Realiza o pagamento
    public boolean realizarPagamento() {

        if (valor <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return false;
        }

        if (modalidadePagamento == null || modalidadePagamento.trim().isEmpty()) {
            System.out.println("Erro: informe uma modalidade de pagamento.");
            return false;
        }

        status = "APROVADO";

        return true;
    }

    // Mostra os dados do pagamento
    public void mostrarPagamento() {

        System.out.println("===== DADOS DO PAGAMENTO =====");
        System.out.println("Número do pagamento: " + numeroPagamento);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Modalidade: " + modalidadePagamento);
        System.out.println("Status: " + status);
    }
}