import java.util.ArrayList;

public class Disciplina {
    private int id;
    private String nome;
    private ArrayList<Aluno> alunosMatriculados;
    private int totNotas;
    private Professor professor;


    public Disciplina(int id, String nome, int totNotas, Professor professor) {
        this.id = id;
        this.nome = nome;
        this.alunosMatriculados = null;
        this.totNotas = totNotas;
        this.professor = professor;
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
