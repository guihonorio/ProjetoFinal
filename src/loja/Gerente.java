package loja;

public class Gerente extends Funcionario {

    private String setor;
    private double bonus;

    public Gerente(int id, String nome, String cpf, double salario, String cargo,
                   String setor, double bonus) {

        super(id, nome, cpf, salario, cargo);

        this.setor = setor;
        this.bonus = bonus;
    }

    public String getSetor() {
        return setor;
    }

    public void setSetor(String setor) {
        this.setor = setor;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    @Override
    public void mostrarDados() {

        System.out.println("===== DADOS DO GERENTE =====");
        System.out.println("ID: " + getId());
        System.out.println("Nome: " + getNome());
        System.out.println("CPF: " + getCpf());
        System.out.printf("Salário: R$ %.2f%n", getSalario());
        System.out.println("Cargo: " + getCargo());
        System.out.println("Setor: " + setor);
        System.out.printf("Bônus: R$ %.2f%n", bonus);
    }
}