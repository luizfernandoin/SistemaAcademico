public class Interface {
    public static void menu(String ... mensagem) {
        for (int index = 0; index < mensagem.length; index++) {
            System.out.printf("[%d] %s\n", index+1, mensagem[index]);
        }

        System.out.println("\nInforme uma das opções acima: ");
    }
}
