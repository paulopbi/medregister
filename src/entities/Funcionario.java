package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

import static util.Personalizacao.*;

public class Funcionario extends Pessoa {
    // declaração das classes, apontando para null
    Scanner sc;
    Funcionario funcionario;
    private String profissao;
    private String nivelDeEscolaridade;

    DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, LocalDate dataDeNascimento, char sexo, String telefone, String profissao, String nivelEscoalaridade) {
        super(nome, cpf, dataDeNascimento, sexo, telefone);
        this.setProfissao(profissao);
        this.setNivelDeEscolaridade(nivelEscoalaridade);
    }

    public String getProfissao() {
        return profissao;
    }

    public void setProfissao(String profissao) {
        this.profissao = profissao;
    }

    public String getNivelDeEscolaridade() {
        return nivelDeEscolaridade;
    }

    public void setNivelDeEscolaridade(String nivelDeEscolaridade) {
        this.nivelDeEscolaridade = nivelDeEscolaridade;
    }

    public void cadastrarFuncionario() {
        System.out.println("\n---------- Cadastro De Funcionarios ----------");
        sc = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();
        super.setNome(nome);

        System.out.print("Digite o seu CPF: ");
        String cpf = sc.next();
        validaCPF(cpf, sc);
        sc.nextLine(); // Consome quebra de linha

        System.out.print("Digite a sua data de nascimento (no formato DD/MM/YYYY): ");
        boolean validBirthday = false; // Variável sentinela pra que o loop da entrada do aniversário funcione corretamente
        LocalDate dataDeNascimento = null; // Inicializa como null

        while(!validBirthday) {
            try {
                // Converte a string para LocalDate usando o formatador
                String nascimento = sc.nextLine();
                dataDeNascimento = LocalDate.parse(nascimento, fmt);
                validBirthday = true;
            } catch (Exception e) {
                System.out.println("Formato de data inválido. Use o formato DD-MM-YYYY.");
            }
        }

        System.out.print("Digite o sexo (M ou F): ");
        char sexo = sc.next().charAt(0);
        super.setSexo(sexo);

        System.out.print("Digite o seu telefone: ");
        sc.nextLine(); // Consume quebra de linha
        String telefone = sc.next();
        validaTelefone(telefone, sc);
        sc.nextLine(); // Consume quebra de linha

        System.out.print("Digite a sua profissao: ");
        String profissao = sc.nextLine();
        this.setProfissao(profissao);

        System.out.print("Digite o seu nivel de escolaridade: ");
        String escolaridade = sc.nextLine();
        this.setNivelDeEscolaridade(escolaridade);

        funcionario = new Funcionario(nome, cpf, dataDeNascimento, sexo, telefone, profissao, escolaridade);

        System.out.println(COR_VERDE + "\n[+] Dados Cadastrados" + COR_RESET);
        System.out.println(funcionario + "\nProfissao: " + this.getProfissao() + "\nEscolaridade: " + this.getNivelDeEscolaridade());
    }

    @Override
    public void alterarDados() {
        sc = new Scanner(System.in);
        System.out.println(COR_AMARELA + "\n[ATENCAO] Alteracao de dados" + COR_RESET);
        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();
        setNome(nome);

        System.out.print("Digite o seu CPF: ");
        String cpf = sc.next();
        validaCPF(cpf, sc);
        sc.nextLine(); // Consome quebra de linha

        System.out.print("Digite a sua data de nascimento (no formato DD/MM/YYYY): ");
        boolean validBirthday = false; // Variável sentinela pra que o loop da entrada do aniversário funcione corretamente

        while(!validBirthday) {
            try {
                // Converte a string para LocalDate usando o formatador
                String nascimento = sc.nextLine();
                LocalDate dataDeNascimento = LocalDate.parse(nascimento, fmt);
                setDataDeNascimento(dataDeNascimento);
                validBirthday = true;
            } catch (Exception e) {
                System.out.println("Formato de data inválido. Use o formato DD/MM/YYYY.");

                System.out.print("Digite novamente a sua data de nascimento: ");
            }
        }

        System.out.print("Digite o sexo (M ou F): ");
        char sexo = sc.next().charAt(0);
        setSexo(sexo);

        System.out.print("Digite o seu telefone: ");
        sc.nextLine(); // Consume quebra de linha
        String telefone = sc.next();
        validaTelefone(telefone, sc);
        sc.nextLine(); // Consume quebra de linha

        System.out.print("Digite a sua profissao: ");
        String profissao = sc.nextLine();
        setProfissao(profissao);

        System.out.print("Digite o seu nivel de escolaridade: ");
        String escolaridade = sc.nextLine();
        setNivelDeEscolaridade(escolaridade);

        System.out.println(COR_VERDE + "\n[+] Dados Atualizados" + COR_RESET);
        System.out.println(super.toString() + "\nProfissao: " + this.getProfissao() + "\nEscolaridade: " + this.getNivelDeEscolaridade());
    }
}
