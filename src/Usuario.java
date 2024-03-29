import java.util.ArrayList;
import java.util.Scanner;

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

    public abstract int menu(Scanner scanner);

    public boolean autenticar(String senha) {
        return this.senha.equals(senha);
    }

    public void verPerfil() {
        System.out.println("============");
        System.out.println(
            "Nome: " + this.getNome()+"\n" +
            "CPF: " + this.getCpf()+"\n" +
            "Matricula: " + this.getMatricula()
        );
    }

    public static Usuario login(ArrayList<Usuario> usuarios, Scanner scanner) {
        Usuario usuarioLogado = null;
        int matricula;
        String senha;

        do {
            System.out.print("Matrícula: ");
            matricula = scanner.nextInt();
            System.out.print("Senha: ");
            scanner.nextLine();
            senha = scanner.nextLine();

            for (Usuario usuario: usuarios) {
                if (usuario.getMatricula() == matricula && usuario.autenticar(senha)) {
                    return usuario;
                }
            }
        } while (usuarioLogado == null);

        return null;
    }


    public abstract void atualizarInformacoes(Scanner scanner);

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
