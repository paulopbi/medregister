package util;

public class Personalizacao {
    public static final String COR_RESET = "\u001b[0m";
    public static final String COR_AMARELA = "\u001b[33m";
    public static final String COR_VERDE = "\u001b[32m";
    public static final String COR_AZUL = "\u001b[34m";
    public static final String COR_ROXA = "\u001b[35m";
    public static final String COR_VERMELHA = "\u001b[31m";

    public static void logoAscii() {
        System.out.println(COR_AZUL + " __  __          _ _____            _     _            ");
        System.out.println("|  \\/  |        | |  __ \\          (_)   | |           ");
        System.out.println("| \\  / | ___  __| | |__) |___  __ _ _ ___| |_ ___ _ __ ");
        System.out.println("| |\\/| |/ _ \\/ _` |  _  // _ \\/ _` | / __| __/ _ \\ '__|");
        System.out.println("| |  | |  __/ (_| | | \\ \\  __/ (_| | \\__ \\ ||  __/ |   ");
        System.out.println("|_|  |_|\\___|\\__,_|_|  \\_\\___|\\__, |_|___/\\__\\___|_|   ");
        System.out.println("                               __/ |                   ");
        System.out.println("                              |___/                    ");
        System.out.println(COR_RESET + "\nRepositorio: https://github.com/paulopbi/medregister");
    }
}
