import java.util.ArrayList;
import java.util.Scanner;

public class Aluno {
    private int matricula;
    private String nome;
    private String cpf;
    private double cre;


    public Aluno(int matricula, String nome, String cpf) {
        this.matricula = matricula;
        this.nome = nome;
        this.cpf = cpf;
        this.cre = 0.0;
    }

    static public Aluno criarAluno() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Informe a matricula: ");
        int matricula = scanner.nextInt();
        scanner.nextLine();

        System.out.print("Informe o nome: ");
        String nome = scanner.nextLine();

        System.out.print("Informe o CPF: ");
        String cpf = scanner.nextLine();

        Aluno aluno = new Aluno(matricula, nome, cpf);

        return aluno;
    }

    public void informacoes() {
        System.out.println(
                "Aluno: "+this.nome+"\n" +
                "CPF: "+this.cpf+"\n" +
                "Matricula: "+this.matricula+"\n" +
                "CRE: " + this.cre
        );
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
