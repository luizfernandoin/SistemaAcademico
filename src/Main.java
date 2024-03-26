import java.util.ArrayList;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opcao = 3;
        ArrayList<Aluno> alunos = new ArrayList<>();

        do {
            Interface.menu(
                    "ADICIONAR ESTUDANTE",
                    "ATUALIZAR DADOS",
                    "PESQUISAR ESTUDANTE",
                    "EXCLUIR ESTUDANTE",
                    "SAIR");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    Aluno aluno = Aluno.criarAluno();
                    alunos.add(aluno);
                    break;
                case 2:
                    System.out.print("\nInforme a matricula: ");
                    int matricula = scanner.nextInt();

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula() == matricula) {
                            Aluno alunoNovo = Aluno.criarAluno();
                            alunos.get(i).setMatricula(alunoNovo.getMatricula());
                            alunos.get(i).setNome(alunoNovo.getNome());
                            alunos.get(i).setCpf(alunoNovo.getCpf());
                        }
                    }
                    break;
                case 3:
                    System.out.print("\nInforme a matricula: ");
                    matricula = scanner.nextInt();

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula() == matricula) {
                            alunos.get(i).informacoes();
                        }
                    }
                    break;
                case 4:
                    System.out.print("\nMatricula que deseja excluir: ");
                    matricula = scanner.nextInt();

                    for (int i = 0; i < alunos.size(); i++) {
                        if (alunos.get(i).getMatricula() == matricula) {
                            alunos.remove(i);
                        }
                    }
                    break;
            }
        } while (opcao != 5);
    }
}