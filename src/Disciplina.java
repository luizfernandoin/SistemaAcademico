import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome;
    private ArrayList<Aluno> alunosMatriculados;


    public Disciplina(int id, String nome) {
        this.id = id;
        this.nome = nome;
        this.alunosMatriculados = null;
    }

    public void matricularAluno(Aluno aluno) {
        alunosMatriculados.add(aluno);
    }

    public void listarAlunosMatriculados() {
        Aluno.listarAlunos(alunosMatriculados);
    }

    public int getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ArrayList<Aluno> getAlunosMatriculados() {
        return alunosMatriculados;
    }
}
