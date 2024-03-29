public abstract class Usuario {
    private int matricula;
    private String nome;
    private String cpf;
//    private String email;
    private String senha;

    public Usuario(int matricula, String nome, String cpf, String senha) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.senha = senha;
    }

    public abstract int menu(String ... mensagem);

    public int getMatricula() {
        return matricula;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
