public class Disciplina {
    private int id;
    private String nome;


    private  double notaFinal;


    public Disciplina(int id, String nome, double notaFinal) {
        this.id = id;
        this.nome = nome;
        this.notaFinal = notaFinal;
    }


    public int getId() {
        return id;
    }


    public void setId(int id) {
        this.id = id;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public double getNotaFinal() {
        return notaFinal;
    }


    public void setNotaFinal(double notaFinal) {
        this.notaFinal = notaFinal;
    }
}
