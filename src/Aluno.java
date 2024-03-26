public class Aluno {
    private int matricula;
    private String nome;
    private String cpf;

    public Aluno(int matricula, String nome, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }
}
