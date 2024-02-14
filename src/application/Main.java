package application;

import entities.Funcionario;
import util.Personalizacao;

import java.time.Duration;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import static util.Personalizacao.*;

public class Main {
    public static void main(String[] args) {
        Locale.setDefault(Locale.US);
        Scanner sc = new Scanner(System.in);

        // declaração das classes, apontando para null
        Personalizacao personalizacao;
        List<Funcionario> funcionariosList = new ArrayList<>();

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
                    System.out.println("\n---------- Cadastro De Funcionarios ----------");
                    sc = new Scanner(System.in);
                    sc = new Scanner(System.in);
                    System.out.print("Digite o seu nome: ");
                    String nome = sc.nextLine();

                    System.out.print("Digite o seu CPF: ");
                    String cpf = sc.nextLine();

                    System.out.print("Digite o seu RG: ");
                    String rg = sc.nextLine();

                    System.out.print("Digite a sua data de nascimento: ");
                    String nascimento = sc.nextLine();

                    System.out.print("Digite o sexo (M ou F): ");
                    char sexo = sc.next().charAt(0);

                    System.out.print("Digite o seu telefone: ");
                    sc.nextLine();
                    String telefone = sc.nextLine();

                    System.out.print("Digite a sua profissao: ");
                    String profissao = sc.nextLine();

                    System.out.print("Digite sua data de admissão (DD/MM/YYYY): ");
                    String dataInput = sc.next();
                    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatação da data
                    sc.nextLine(); // Consome quebra de linha

                    // Gerenciamento de excessões com try-catch
                    LocalDate dataAdmissao;
                    try {
                        // Converte a string para um objeto LocalDate
                        dataAdmissao = LocalDate.parse(dataInput, fmt);

                        // Exibe a data formatada
                        System.out.println("Data de admissão: " + dataAdmissao.format(fmt));

                        Duration contratoTime = Duration.between(dataAdmissao.atStartOfDay(), LocalDate.now().atStartOfDay());
                        System.out.println("O contrato vigora há: " + contratoTime.toDays() + " dias");

                        System.out.print("Digite o seu nível de escolaridade: " + COR_RESET);
                        String escolaridade = sc.nextLine();

                        funcionariosList.add(new Funcionario(nome, cpf, rg, nascimento, sexo, telefone, profissao, escolaridade, dataAdmissao));
                    } catch (java.time.format.DateTimeParseException e) {
                        System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
                    }

                    System.out.println(COR_VERDE + "\n[+] Dados Cadastrados");
                    System.out.println(funcionariosList.getLast() + COR_RESET);

                    System.out.print("\nDeseja alterar do funcionario (S ou N)? ");
                    char respostaFuncionario = sc.next().charAt(0);

                    if (respostaFuncionario == 's' || respostaFuncionario == 'S') {
                        System.out.println(COR_VERMELHA + "\n----ATENCAO - Alteracao de dados----");
                        funcionariosList.getLast().alterarDados();
                    } else {
                        System.out.println("\n[+] Os dados permanecerao os mesmos!");
                    }
                    break;

            }
           } while (opcao != 5);

        sc.close();

    }
}
