import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        int opcao = 3;

        do {
            Interface.menu(
                    "ADICIONAR ESTUDANTE",
                    "ATUALIZAR DADOS",
                    "PESQUISAR ESTUDANTE",
                    "SAIR");
            Scanner scanner = new Scanner(System.in);
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Adicionar Estudante");
                    break;
                case 2:
                    System.out.println("Atualizar Dados");
                    break;
                case 3:
                    System.out.println("Pesquisar Estudante");
                    break;
            }
        } while (opcao != 4);
    }
}