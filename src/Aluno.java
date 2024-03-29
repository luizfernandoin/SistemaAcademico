import java.util.ArrayList;
import java.util.Scanner;

public class Aluno extends Usuario {
    private double cre;
    private ArrayList<Disciplina> disciplinas;


    public Aluno(int matricula, String nome, String cpf, String senha) {
        super(matricula, nome, cpf, senha);
        this.cre = 0.0;
        this.disciplinas = null;
    }

    @Override
    public int menu(String ... mensagem) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("[01] Ver perfil");
        System.out.println("[02] Boletim");
        System.out.println("[03] Alterar informações");

        System.out.println("\nInforme uma das opções acima: ");
        int opcao = scanner.nextInt();

        return opcao;
    }

    static public Aluno criarAluno(ArrayList<Aluno> alunos) {
        System.out.println("Chegou aqui");
        Scanner scanner = new Scanner(System.in);

        int matricula;
        if (!alunos.isEmpty()) {
            matricula = (alunos.get(alunos.size() - 1).getMatricula()) + 1;
        } else {
            matricula = 1;
        }

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        Aluno aluno = new Aluno(matricula, nome, cpf, "123");

        return aluno;
    }

    static public Aluno updateAluno(Aluno aluno) {
        int opcao;

        do {
            Interface.menu(
                    "ATUALIZAR NOME",
                    "ATUALIZAR CPF",
                    "SAIR");

            System.out.println("\nDigite uma opção: ");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.print("Digite o novo nome: ");
                    scanner.nextLine();
                    String novoNome = scanner.nextLine();
                    aluno.setNome(novoNome);
                    break;
                case 2:
                    System.out.print("Digite o novo CPF: ");
                    String novoCpf = scanner.next();
                    aluno.setCpf(novoCpf);
                    break;
                default:
                    System.out.println("Opção inválida.");

            }
        } while (opcao != 3);


        return aluno;
    }

    static public void listarAlunos(ArrayList<Aluno> alunos) {
        for(Aluno aluno: alunos) {
            aluno.informacoes();
        }
    }

    public void informacoes() {
        System.out.println("============");
        System.out.println(
            "Aluno: " + super.getNome()+"\n" +
            "CPF: " + super.getCpf()+"\n" +
            "Matricula: " + super.getMatricula()+"\n" +
            "CRE: " + this.cre
        );}

    public double getCre() {
        return cre;
    }

    public void setCre(double cre) {
        this.cre = cre;
    }

    public ArrayList<Disciplina> getDisciplinas() {
        return disciplinas;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
