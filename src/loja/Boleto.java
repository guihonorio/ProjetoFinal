package loja;

public class Boleto extends Pagamento {

    private String codigoBarras;

    public Boleto(int numeroPagamento, double valor, String codigoBarras) {
        super(numeroPagamento, valor);
        this.codigoBarras = codigoBarras;
    }

    public String getCodigoBarras() {
        return codigoBarras;
    }

    public void setCodigoBarras(String codigoBarras) {
        this.codigoBarras = codigoBarras;
    }

    @Override
    public boolean realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return false;
        }

        if (codigoBarras == null || codigoBarras.trim().isEmpty()) {
            System.out.println("Erro: o código de barras deve ser informado.");
            return false;
        }

        setStatus("APROVADO");

        return true;
    }

    @Override
    public void mostrarPagamento() {

        System.out.println("===== PAGAMENTO POR BOLETO =====");
        System.out.println("Número do pagamento: " + getNumeroPagamento());
        System.out.printf("Valor: R$ %.2f%n", getValor());
        System.out.println("Status: " + getStatus());
        System.out.println("Código de barras: " + codigoBarras);
    }
}