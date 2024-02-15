package application;

import entities.Funcionario;
import util.Personalizacao;

import java.util.Locale;
import java.util.Scanner;

import static util.Personalizacao.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // declaração das classes, apontando para null
        Personalizacao personalizacao;
        Funcionario funcionario;

        logoAscii();

        int opcao = 0;
        do {
            System.out.println(COR_AZUL + "\nMenu de opcoes");
            System.out.println( "1 - Cadastrar Funcionarios" + "\t\t\t\t2 - Cadastrar Pacientes");
            System.out.println("3 - Mostrar Funcionarios Cadastrados" + "\t4 - Mostrar Pacientes Cadastrados");
            System.out.println("5 - Sair" + COR_RESET);

            System.out.print("\nDigite uma opcao: ");
            opcao = sc.nextInt();
            sc.nextLine();

            //switch case do menu
            switch (opcao) {
                case 1:
                    funcionario = new Funcionario();
                    funcionario.cadastrarFuncionario();

                    System.out.print("\nDeseja alterar os dados (S ou N)? ");
                    char resposta = sc.next().charAt(0);

                    if(resposta == 's' || resposta == 'S') {
                        funcionario.alterarDados();
                    } else {
                        System.out.println("Os dados permanecerao os mesmos!");
                    }
                    break;

            }
           } while (opcao != 5);

        sc.close();

    }
}
