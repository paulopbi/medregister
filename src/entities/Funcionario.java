package entities;

import java.util.Scanner;

import static util.Personalizacao.*;

public class Funcionario extends Pessoa {
    // declaração das classes, apontando para null
    Scanner sc;
    Funcionario funcionario;
    private String profissao;
    private String nivelDeEscolaridade;

    public Funcionario(String nome, String cpf, String rg, String dataDeNascimento, char sexo, String telefone, String profissao, String nivelEscoalaridade) {
        super(nome, cpf, rg, dataDeNascimento,sexo,telefone);
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

    @Override
    public void alterarDados() {
        sc = new Scanner(System.in);
        System.out.println(COR_VERMELHA + "\n----ATENCAO - Alteracao de dados----");
        System.out.print("Digite o seu nome: ");
        String nome = sc.nextLine();
        this.setNome(nome);

        System.out.print("Digite o seu CPF: ");
        String cpf = sc.nextLine();
        this.setCpf(cpf);

        System.out.print("Digite o seu RG: ");
        String rg = sc.nextLine();
        this.setRg(rg);

        System.out.print("Digite a sua data de nascimento: ");
        String nascimento = sc.nextLine();
        this.setDataDeNascimento(nascimento);

        System.out.print("Digite o sexo (M ou F): ");
        char sexo = sc.next().charAt(0);
        this.setSexo(sexo);

        System.out.print("Digite o seu telefone: ");
        sc.nextLine();
        String telefone = sc.nextLine();
        this.setTelefone(telefone);

        System.out.print("Digite a sua profissao: ");
        String profissao = sc.nextLine();
        this.setProfissao(profissao);

        System.out.print("Digite o seu nivel de escolaridade: " + COR_RESET);
        String escolaridade = sc.nextLine();
        this.setNivelDeEscolaridade(escolaridade);

        System.out.println(COR_VERDE + "\n----Dados Atualizados----");
        System.out.println(super.toString() + "\nProfissao: " + this.getProfissao()
        + "\nNivel de escolaridade: " + this.getNivelDeEscolaridade() + COR_RESET);
    }

    @Override
    public String toString() {
        return super.toString() + "\nProfissao: " + this.getProfissao()
                + "\nEscolaridade: " + this.getNivelDeEscolaridade();
    }
}
