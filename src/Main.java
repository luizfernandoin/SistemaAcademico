import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        Disciplina disciplina = new Disciplina(1, "Português", 3);

        usuarios.add(new Professor(1, "Professor", "1", "123", 1300.00, disciplina));
        usuarios.add(new Aluno(2, "Luiz", "2", "123"));

        int opcao;
        Usuario usuarioLogado = null;

        do {
            if (usuarioLogado == null) {
                usuarioLogado = Usuario.login(usuarios, scanner);
            }

            opcao = usuarioLogado.menu(scanner);

            switch (opcao) {
                case 1:
                    usuarioLogado.verPerfil();

                    break;
                case 2:
                    if (usuarioLogado instanceof Aluno) {
                        ((Aluno) usuarioLogado).boletim();
                    } else if (usuarioLogado instanceof Professor) {
                        System.out.println("pass");
                    } else if (usuarioLogado instanceof Administrador) {
                        disciplinas.add(((Administrador) usuarioLogado).criarDisciplina(
                                disciplinas, scanner));
                    }

                    break;
                case 3:
                    usuarioLogado.atualizarInformacoes(scanner);

//                    System.out.print("\nInforme a matricula: ");
//                    matricula = scanner.nextInt();
//
//                    for (Aluno aluno: alunos) {
//                        if (aluno.getMatricula() == matricula) {
//                            aluno.informacoes();
//                        }
//                    }
                    break;
                case 4:
                    usuarioLogado = null;
//                    System.out.print("\nMatricula que deseja excluir: ");
//                    matricula = scanner.nextInt();
//
//                    for (int aluno = 0; aluno < alunos.size(); aluno++) {
//                        if (alunos.get(aluno).getMatricula() == matricula) {
//                            alunos.remove(aluno);
//                        }
//                    }
                    break;
            }
        } while (opcao != 5);
    }
}