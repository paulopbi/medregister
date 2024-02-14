package entities;

import java.time.Duration;
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

    public Funcionario(String nome, String cpf, String rg, String dataDeNascimento, char sexo, String telefone, String profissao, String nivelEscoalaridade, LocalDate dataAdmissao) {
        super(nome, cpf, rg, dataDeNascimento,sexo,telefone);
        setProfissao(profissao);
        setNivelDeEscolaridade(nivelEscoalaridade);
        setDataAdmissao(dataAdmissao);
    }

    public void setDataAdmissao(LocalDate dataAdmissao) {
        this.dataAdmissao = dataAdmissao;
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

    public String formatDataAdmissao(){
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        return dataAdmissao.format(fmt);
    }

    @Override
    public void alterarDados() {
        sc = new Scanner(System.in);
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

        System.out.print("Digite sua data de admissão (DD/MM/YYYY): ");
        String dataInput = sc.next();
        DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy"); // Formatação da data

        // Gerenciamento de excessões com try-catch
        try {
            // Converte a string para um objeto LocalDate
            LocalDate dataAdmissao = LocalDate.parse(dataInput, fmt);

            // Exibe a data formatada
            System.out.println("Data de admissão: " + dataAdmissao.format(fmt));
            setDataAdmissao(dataAdmissao);

            Duration contratoTime = Duration.between(dataAdmissao.atStartOfDay(), LocalDate.now().atStartOfDay());
            System.out.println("O contrato vigora há: " + contratoTime.toDays() + " dias");
        } catch (java.time.format.DateTimeParseException e) {
            System.out.println("Formato de data inválido. Use o formato dd/MM/yyyy.");
        }

        System.out.print("Digite o seu nível de escolaridade: " + COR_RESET);
        String escolaridade = sc.nextLine();
        setNivelDeEscolaridade(escolaridade);

        System.out.println(COR_VERDE + "\n----Dados Atualizados----");
        System.out.println(super.toString() + "\nProfissao: " + this.getProfissao()
        + "\nNivel de escolaridade: " + this.getNivelDeEscolaridade() + COR_RESET);
    }

    @Override
    public String toString() {
        return super.toString()
                + "\nProfissao: " + this.getProfissao()
                + "\nData de admissão: " + formatDataAdmissao()
                + "\nEscolaridade: " + this.getNivelDeEscolaridade();
    }
}