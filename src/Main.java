import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opcao = 3;
        ArrayList<Aluno> alunos = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

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
                    Aluno novoAluno = Aluno.criarAluno(alunos);
                    alunos.add(novoAluno);

                    Aluno.listarAlunos(alunos);

                    break;
                case 2:
                    System.out.print("Matrícula do estudante que deseja alterar: ");
                    int matricula = scanner.nextInt();

                    Aluno alunoAtualizavel = null;
                    for (Aluno aluno: alunos) {
                        if (aluno.getMatricula() == matricula) {
                            alunoAtualizavel = aluno;
                        }
                    }

                    if (alunoAtualizavel != null) {
                        Aluno.updateAluno(alunoAtualizavel);
                    }

                    break;
                case 3:
                    System.out.print("\nInforme a matricula: ");
                    matricula = scanner.nextInt();

                    for (Aluno aluno: alunos) {
                        if (aluno.getMatricula() == matricula) {
                            aluno.informacoes();
                        }
                    }
                    break;
                case 4:
                    System.out.print("\nMatricula que deseja excluir: ");
                    matricula = scanner.nextInt();

                    for (int aluno = 0; aluno < alunos.size(); aluno++) {
                        if (alunos.get(aluno).getMatricula() == matricula) {
                            alunos.remove(aluno);
                        }
                    }
                    break;
            }
        } while (opcao != 5);
    }
}