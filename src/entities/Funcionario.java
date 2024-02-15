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
    private LocalDate dataAdmissao;

    public Funcionario() {
    }

    public Funcionario(String nome, String cpf, String rg, String dataDeNascimento, char sexo, String telefone, String profissao, String nivelEscoalaridade) {
        super(nome, cpf, rg, dataDeNascimento, sexo, telefone);
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

    public String formatDataAdmissao() {
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataAdmissao.format(fmt);
    }

    public void cadastrarFuncionario() {
        System.out.println("\n---------- Cadastro De Funcionarios ----------");
        sc = new Scanner(System.in);

        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();
        super.setNome(nome);

        System.out.print("Digite o seu CPF: ");
        String cpf = sc.nextLine();
        super.setCpf(cpf);

        System.out.print("Digite o seu RG: ");
        String rg = sc.nextLine();
        super.setRg(rg);

        System.out.print("Digite a sua data de nascimento: ");
        String nascimento = sc.nextLine();
        super.setDataDeNascimento(nascimento);

        System.out.print("Digite o sexo (M ou F): ");
        char sexo = sc.next().charAt(0);
        super.setSexo(sexo);

        System.out.print("Digite o seu telefone: ");
        sc.nextLine();
        String telefone = sc.nextLine();
        super.setTelefone(telefone);

        System.out.print("Digite a sua profissao: ");
        String profissao = sc.nextLine();
        this.setProfissao(profissao);

        System.out.print("Digite o seu nivel de escolaridade: ");
        String escolaridade = sc.nextLine();
        this.setNivelDeEscolaridade(escolaridade);

        funcionario = new Funcionario(nome, cpf, rg, nascimento, sexo, telefone, profissao, escolaridade);

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
        String cpf = sc.nextLine();
        setCpf(cpf);

        System.out.print("Digite o seu RG: ");
        String rg = sc.nextLine();
        setRg(rg);

        System.out.print("Digite a sua data de nascimento: ");
        String nascimento = sc.nextLine();
        setDataDeNascimento(nascimento);

        System.out.print("Digite o sexo (M ou F): ");
        char sexo = sc.next().charAt(0);
        setSexo(sexo);

        System.out.print("Digite o seu telefone: ");
        sc.nextLine();
        String telefone = sc.nextLine();
        setTelefone(telefone);

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
