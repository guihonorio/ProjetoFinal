package loja;

public class Pix extends Pagamento {

    private String chavePix;

    // Construtor
    public Pix(int numeroPagamento, double valor, String chavePix) {
        super(numeroPagamento, valor);
        this.chavePix = chavePix;
    }

    // Getter e Setter

    public String getChavePix() {
        return chavePix;
    }

    public void setChavePix(String chavePix) {
        this.chavePix = chavePix;
    }

    // Pagamento via PIX
    @Override
    public boolean realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return false;
        }

        if (chavePix == null || chavePix.trim().isEmpty()) {
            System.out.println("Erro: a chave PIX deve ser informada.");
            return false;
        }

        setStatus("APROVADO");

        return true;
    }

    // Dados do pagamento
    @Override
    public void mostrarPagamento() {

        System.out.println("===== PAGAMENTO PIX =====");
        System.out.println("Número do pagamento: " + getNumeroPagamento());
        System.out.printf("Valor: R$ %.2f%n", getValor());
        System.out.println("Status: " + getStatus());
        System.out.println("Chave PIX: " + chavePix);
    }
}