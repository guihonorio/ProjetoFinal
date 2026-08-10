package loja;

public class CartaoDebito extends Cartao {

    private double saldoDisponivel;
    private String senha;

    public CartaoDebito(int numeroPagamento, double valor,
                        String numeroCartao, String nomeTitular,
                        String bandeira, String cvv,
                        double saldoDisponivel, String senha) {

        super(numeroPagamento, valor, numeroCartao, nomeTitular, bandeira, cvv);

        this.saldoDisponivel = saldoDisponivel;
        this.senha = senha;
    }

    public double getSaldoDisponivel() {
        return saldoDisponivel;
    }

    public void setSaldoDisponivel(double saldoDisponivel) {
        this.saldoDisponivel = saldoDisponivel;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
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

        if (senha == null || senha.trim().isEmpty()) {
            System.out.println("Erro: a senha do cartão deve ser informada.");
            return false;
        }

        if (saldoDisponivel < getValor()) {
            System.out.println("Pagamento não aprovado: saldo insuficiente.");
            return false;
        }

        saldoDisponivel -= getValor();

        setStatus("APROVADO");

        return true;
    }

    @Override
    public void mostrarPagamento() {

        System.out.println("===== PAGAMENTO COM CARTÃO DE DÉBITO =====");

        System.out.println("Número do pagamento: " + getNumeroPagamento());
        System.out.printf("Valor: R$ %.2f%n", getValor());
        System.out.println("Status: " + getStatus());

        mostrarDadosCartao();

        System.out.printf("Saldo disponível: R$ %.2f%n", saldoDisponivel);
        System.out.println("Senha: " + senha);
    }
}