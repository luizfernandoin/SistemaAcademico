import java.util.ArrayList;
import java.util.Scanner;

public class Administrador extends Usuario {

    public Administrador(int matricula, String nome, String cpf, String senha) {
        super(matricula, nome, cpf, senha);
    }
    @Override
    public int menu(Scanner scanner) {
        System.out.println("[1] Ver perfil");
        System.out.println("[2] Cadastrar Aluno");
        System.out.println("[2] Cadastrar Aluno");
        System.out.println("[2] Criar Disciplina");
        System.out.println("[3] Alterar Informações");
        System.out.println("[4] Logout");

        System.out.println("\nInforme uma das opções acima: ");
        int opcao = scanner.nextInt();

        return opcao;
    }

    @Override
    public void atualizarInformacoes(Scanner scanner) {
        int opcao;

        do {
            Interface.menu(
                    "ATUALIZAR NOME",
                    "ATUALIZAR CPF",
                    "ATUALIZAR SENHA",
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
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 4);
    }

    public Disciplina criarDisciplina(ArrayList<Disciplina> disciplinas, Scanner scanner) {
        System.out.println("Nome da disciplina: ");
        String nomeDisciplina = scanner.nextLine();

        System.out.println("Total de notas: ");
        int totNotas = scanner.nextInt();

        Disciplina novaDisciplina = new Disciplina(disciplinas.size(), nomeDisciplina, totNotas);

        return novaDisciplina;
    }
}
