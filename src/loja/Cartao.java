package loja;

public abstract class Cartao extends Pagamento {

    private String numeroCartao;
    private String nomeTitular;
    private String bandeira;
    private String cvv;

    // Construtor
    public Cartao(int numeroPagamento, double valor,
                  String numeroCartao, String nomeTitular,
                  String bandeira, String cvv) {

        super(numeroPagamento, valor);

        this.numeroCartao = numeroCartao;
        this.nomeTitular = nomeTitular;
        this.bandeira = bandeira;
        this.cvv = cvv;
    }

    // Getters e Setters

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public void setNomeTitular(String nomeTitular) {
        this.nomeTitular = nomeTitular;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    // Validar dados
    protected boolean validarDadosCartao() {

        if (numeroCartao == null || numeroCartao.trim().isEmpty()) {
            System.out.println("Erro: o número do cartão deve ser informado.");
            return false;
        }

        if (nomeTitular == null || nomeTitular.trim().isEmpty()) {
            System.out.println("Erro: o nome do titular deve ser informado.");
            return false;
        }

        if (bandeira == null || bandeira.trim().isEmpty()) {
            System.out.println("Erro: a bandeira do cartão deve ser informada.");
            return false;
        }

        if (cvv == null || cvv.trim().isEmpty()) {
            System.out.println("Erro: o código de segurança (CVV) deve ser informado.");
            return false;
        }

        return true;
    }

    // Mostra os dados do cartão
    protected void mostrarDadosCartao() {

        System.out.println("Número do cartão: " + numeroCartao);
        System.out.println("Nome do titular: " + nomeTitular);
        System.out.println("Bandeira: " + bandeira);
        System.out.println("CVV: " + cvv);
    }
}