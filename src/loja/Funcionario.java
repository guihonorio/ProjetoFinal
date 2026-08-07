package loja;

public class Funcionario {

    private int id;
    private String nome;
    private String cpf;
    private double salario;
    private String cargo;

    // Construtor
    public Funcionario(int id, String nome, String cpf, double salario, String cargo) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.salario = salario;
        this.cargo = cargo;
    }

    // Getters e Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    // Exibe os dados do funcionário
    public void mostrarDados() {
        System.out.println("===== DADOS DO FUNCIONÁRIO =====");
        System.out.println("ID: " + id);
        System.out.println("Nome: " + nome);
        System.out.println("CPF: " + cpf);
        System.out.printf("Salário: R$ %.2f%n", salario);
        System.out.println("Cargo: " + cargo);
    }
}

