import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Disciplina> disciplinas = new ArrayList<>();

        usuarios.add(new Administrador(1, "ADM", "111.111.111-11", "1"));

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
                        usuarioLogado.atualizarInformacoes(scanner);
                    } else if (usuarioLogado instanceof Administrador) {
                        Aluno novoAluno = ((Administrador) usuarioLogado).criarAluno(
                                usuarios, scanner);

                        usuarios.add(novoAluno);
                    }

                    break;
                case 3:
                    if (usuarioLogado instanceof Aluno) {
                        usuarioLogado.atualizarInformacoes(scanner);
                    } else if (usuarioLogado instanceof Professor) {
                        usuarioLogado = null;
                    } else if (usuarioLogado instanceof Administrador) {
                        Professor novoProfessor = ((Administrador) usuarioLogado).criarProfessor(
                                usuarios, scanner);

                        usuarios.add(novoProfessor);
                    }

                    break;
                case 4:
                    if (usuarioLogado instanceof Aluno) {
                        String[] nomesDisciplinas = new String[disciplinas.size()];
                        for (int i = 0; i < disciplinas.size(); i++) {
                            nomesDisciplinas[i] = disciplinas.get(i).getNome();
                        }

                        Interface.menu(nomesDisciplinas);

                        System.out.println("\nMatricular-se em qual disciplina: ");
                        opcao = scanner.nextInt();

                        ((Aluno) usuarioLogado).matricularEmDisciplina(disciplinas.get(opcao-1));
                    } else if (usuarioLogado instanceof Administrador) {
                        Disciplina novaDisciplina = ((Administrador) usuarioLogado).criarDisciplina(
                                disciplinas, usuarios, scanner);

                        if (novaDisciplina != null) {
                            disciplinas.add(novaDisciplina);
                        } else {
                            System.out.println("Precisa-se cadastrar um professor antes!");
                        }
                    }

                    break;
                case 5:
                    if (usuarioLogado instanceof Aluno) {
                        usuarioLogado = null;
                    } else if (usuarioLogado instanceof Administrador) {
                        usuarioLogado.atualizarInformacoes(scanner);
                    }

                    break;
                case 6:
                    if (usuarioLogado instanceof Administrador) {
                        usuarioLogado = null;
                    }

                    break;
            }
        } while (opcao != 7);
    }
}