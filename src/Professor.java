import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Professor extends Usuario{
    private double salario;
    private Disciplina disciplina;
    public Professor(int matricula, String nome, String cpf, String senha,
                     double salario, Disciplina disciplina) {
        super(matricula, nome, cpf, senha);
        this.salario = salario;
        this.disciplina = disciplina;
    }

    @Override
    public int menu(Scanner scanner) {
        System.out.println("[1] Ver Perfil");
        System.out.println("[2] Alterar Informações");
        System.out.println("[3] Logout");

        System.out.println("\nInforme uma das opções acima: ");
        int opcao = scanner.nextInt();

        return opcao;
    }

    @Override
    public void verPerfil() {
        super.verPerfil();
        System.out.println(
            "Salário: " + this.salario + "\n" +
            "Disciplina: " + this.disciplina.getNome() + "\n"
        );
    }

    @Override
    public void atualizarInformacoes(Scanner scanner) {
        int opcao;

        do {
            Interface.menu(
                    "ATUALIZAR NOME",
                    "ATUALIZAR CPF",
                    "ATUALIZAR SENHA",
                    "ATUALIZAR SALARIO",
                    "ATUALIZAR DISCIPLINA",
                    "SAIR");

            System.out.println("\nDigite uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    scanner.nextLine();
                    String novoNome = scanner.nextLine();
                    super.setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String novoCpf = scanner.next();
                    super.setCpf(novoCpf);
                    break;
                case 3:
                    System.out.print("Digite a nova senha: ");
                    String novaSenha = scanner.nextLine();
                    super.setSenha(novaSenha);
                    break;
                case 4:
                    System.out.print("Digite o novo salário: ");
                    double novoSalario = scanner.nextDouble();
                    this.salario = novoSalario;
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 5);
    }
}
