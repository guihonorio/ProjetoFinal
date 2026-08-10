package loja;

public class CartaoCredito extends Cartao {

    private double limiteDisponivel;
    private int quantidadeParcelas;


    public CartaoCredito(int numeroPagamento, double valor,
                         String numeroCartao, String nomeTitular,
                         String bandeira, String cvv,
                         double limiteDisponivel) {

        super(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv);

        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeParcelas = 1;
    }

    public CartaoCredito(int numeroPagamento, double valor,
                         String numeroCartao, String nomeTitular,
                         String bandeira, String cvv,
                         double limiteDisponivel,
                         int quantidadeParcelas) {

        super(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv);

        this.limiteDisponivel = limiteDisponivel;
        this.quantidadeParcelas = quantidadeParcelas;
    }

    public double getLimiteDisponivel() {
        return limiteDisponivel;
    }

    public void setLimiteDisponivel(double limiteDisponivel) {
        this.limiteDisponivel = limiteDisponivel;
    }

    public int getQuantidadeParcelas() {
        return quantidadeParcelas;
    }

    public void setQuantidadeParcelas(int quantidadeParcelas) {
        this.quantidadeParcelas = quantidadeParcelas;
    }

    @Override
    public boolean realizarPagamento() {

        if (getValor() <= 0) {
            System.out.println("Erro: o valor do pagamento deve ser maior que zero.");
            return false;
        }

        if (!validarDadosCartao()) {
            return false;
        }

        if (quantidadeParcelas <= 0) {
            System.out.println("Erro: a quantidade de parcelas deve ser maior que zero.");
            return false;
        }

        if (limiteDisponivel < getValor()) {
            System.out.println("Pagamento não aprovado: limite insuficiente.");
            return false;
        }

        limiteDisponivel -= getValor();

        setStatus("APROVADO");

        return true;
    }

    @Override
    public void mostrarPagamento() {

        System.out.println("===== PAGAMENTO COM CARTÃO DE CRÉDITO =====");

        System.out.println("Número do pagamento: " + getNumeroPagamento());
        System.out.printf("Valor total da compra: R$ %.2f%n", getValor());
        System.out.println("Status: " + getStatus());

        mostrarDadosCartao();

        System.out.printf("Limite disponível: R$ %.2f%n", limiteDisponivel);

        if (quantidadeParcelas == 1) {

            System.out.println("Pagamento: À vista");

        } else {

            double valorParcela = getValor() / quantidadeParcelas;

            System.out.println("Quantidade de parcelas: " + quantidadeParcelas);
            System.out.printf("Valor de cada parcela: R$ %.2f%n", valorParcela);
        }
    }
}