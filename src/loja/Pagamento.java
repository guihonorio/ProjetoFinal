package loja;

public abstract class Pagamento {

    private int numeroPagamento;
    private double valor;
    private String status;

    public Pagamento(int numeroPagamento, double valor) {
        this.numeroPagamento = numeroPagamento;
        this.valor = valor;
        this.status = "PENDENTE";
    }

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

    public String getStatus() {
        return status;
    }

    protected void setStatus(String status) {
        this.status = status;
    }

    public abstract boolean realizarPagamento();

    public void mostrarPagamento() {

        System.out.println("===== DADOS DO PAGAMENTO =====");
        System.out.println("Número do pagamento: " + numeroPagamento);
        System.out.printf("Valor: R$ %.2f%n", valor);
        System.out.println("Status: " + status);
    }
}