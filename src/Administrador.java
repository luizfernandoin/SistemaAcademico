import java.util.ArrayList;
import java.util.Scanner;
import java.util.UUID;

public class Administrador extends Usuario {

    public Administrador(int matricula, String nome, String cpf, String senha) {
        super(matricula, nome, cpf, senha);
    }
    @Override
    public int menu(Scanner scanner) {
        System.out.println("====================");
        System.out.println("[1] Ver perfil");
        System.out.println("[2] Cadastrar Aluno");
        System.out.println("[3] Cadastrar Professor");
        System.out.println("[4] Criar Disciplina");
        System.out.println("[5] Alterar Informações");
        System.out.println("[6] Logout");

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

    public Aluno criarAluno(ArrayList<Usuario> usuarios, Scanner scanner) {
        int matricula;
        ArrayList<Aluno> alunos = getArrayAlunos(usuarios);

        if (!usuarios.isEmpty()) {
            matricula = (usuarios.getLast().getMatricula()) + 1;
        } else {
            matricula = 1;
        }

        System.out.print("Informe o nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe a senha: ");
        String senha = scanner.nextLine();

        Aluno aluno = new Aluno(matricula, nome, cpf, senha);

        return aluno;
    }

    public Professor criarProfessor(ArrayList<Usuario> usuarios, Scanner scanner) {
        int matricula;
        ArrayList<Professor> professores = getArrayProfessores(usuarios);

        if (!usuarios.isEmpty()) {
            matricula = (usuarios.getLast().getMatricula()) + 1;
        } else {
            matricula = 1;
        }

        System.out.print("Informe o nome: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        System.out.print("Informe a senha: ");
        String senha = scanner.nextLine();

        System.out.print("Informe o salário: ");
        double salario = scanner.nextDouble();

        Professor professor = new Professor(matricula, nome, cpf, senha, salario);

        return professor;
    }

    public ArrayList<Professor> getArrayProfessores(ArrayList<Usuario> usuarios) {
        ArrayList<Professor> professores = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            if (usuario instanceof Professor) {
                Professor professor = (Professor) usuario;
                professores.add(professor);
            }
        }

        return professores;
    }

    public ArrayList<Aluno> getArrayAlunos(ArrayList<Usuario> usuarios) {
        ArrayList<Aluno> alunos = new ArrayList<>();

        for (Usuario usuario: usuarios) {
            if (usuario instanceof Aluno) {
                Aluno aluno = (Aluno) usuario;
                alunos.add(aluno);
            }
        }

        return alunos;
    }

    public Disciplina criarDisciplina(ArrayList<Disciplina> disciplinas,
                                      ArrayList<Usuario> usuarios,
                                      Scanner scanner) {
        ArrayList<Professor> professores = getArrayProfessores(usuarios);

        if (professores.size() == 0) {
            return null;
        }

        System.out.println("Nome da disciplina: ");
        scanner.nextLine();
        String nomeDisciplina = scanner.nextLine();

        System.out.println("Total de notas: ");
        int totNotas = scanner.nextInt();


        String[] nomesProfessores = new String[professores.size()];
        for (int i = 0; i < professores.size(); i++) {
            nomesProfessores[i] = professores.get(i).getNome();
        }

        Interface.menu(nomesProfessores);
        System.out.println("\nInforme uma das opções acima: ");
        int opcao = scanner.nextInt();

        Disciplina novaDisciplina = new Disciplina(disciplinas.size(),
                nomeDisciplina, totNotas, professores.get(opcao - 1));

        professores.get(opcao - 1).setDisciplina(novaDisciplina);

        return novaDisciplina;
    }
}
