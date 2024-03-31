public class Interface {
    public static void menu(String ... mensagem) {
        System.out.println("====================");
        for (int index = 0; index < mensagem.length; index++) {
            System.out.printf("[%d] %s\n", index+1, mensagem[index]);
        }
    }
}
