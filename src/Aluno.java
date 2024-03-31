import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Aluno extends Usuario {
    private double cre;
    private ArrayList<Disciplina> disciplinas;


    public Aluno(int matricula, String nome, String cpf, String senha) {
        super(matricula, nome, cpf, senha);
        this.cre = 0.0;
        this.disciplinas = new ArrayList<>();
    }

    @Override
    public int menu(Scanner scanner) {
        System.out.println("====================");
        System.out.println("[1] Ver perfil");
        System.out.println("[2] Boletim");
        System.out.println("[3] Alterar Informações");
        System.out.println("[4] Matricular-se em Disciplina");
        System.out.println("[5] Logout");

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
                    scanner.nextLine();
                    String novaSenha = scanner.nextLine();
                    super.setSenha(novaSenha);
                    break;
            }
        } while (opcao != 4);
    }

    static public void listarAlunos(ArrayList<Aluno> alunos) {
        for(Aluno aluno: alunos) {
            aluno.verPerfil();
        }
    }

    @Override
    public void verPerfil() {
        super.verPerfil();
        System.out.println(
            "CRE: " + this.cre + "\n" +
            "Disciplinas: " + Arrays.toString(getDisciplinas()) + "\n"
        );
    }

    public void boletim() {
        Disciplina[] disciplinasArray = getDisciplinas();

        for (int i = 0; i < disciplinasArray.length; i++) {
            System.out.println("==========");
            System.out.println(disciplinasArray[i].getNome());
        }

    }

    public void matricularEmDisciplina(Disciplina disciplina) {
        this.disciplinas.add(disciplina);
        System.out.println("Chegou aqui");
        disciplina.matricularAluno(this);
    }

    public double getCre() {
        return cre;
    }

    public void setCre(double cre) {
        this.cre = cre;
    }

    public Disciplina[] getDisciplinas() {
        Disciplina[] disciplinasRetorno = new Disciplina[this.disciplinas.size()];


        for (int i = 0; i < this.disciplinas.size(); i++) {
            disciplinasRetorno[i] = this.disciplinas.get(i);
        }

        return disciplinasRetorno;
    }

    public void setDisciplinas(ArrayList<Disciplina> disciplinas) {
        this.disciplinas = disciplinas;
    }
}
