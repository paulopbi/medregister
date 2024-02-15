package entities;

import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Pessoa {
    private String nome;
    private String cpf;
    private String rg;
    private String dataDeNascimento;
    private char sexo;
    private int telefone;

    public Pessoa() {
    }

    public Pessoa(String nome, String cpf, String rg, String dataDeNascimento, char sexo, int telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setDataDeNascimento(dataDeNascimento);
        this.setSexo(sexo);
        this.setTelefone(telefone);
    }

    public abstract void alterarDados();

    public void validaTelefone(int telefone, Scanner sc){
        boolean entradaValida = false; // Variável sentinela para fazer a checagem do loop

        while(!entradaValida) {
            try{
                if (Integer.toString(telefone).length() == 11) {
                    setTelefone(telefone);
                    entradaValida = true;
                } else {
                    System.out.println("O número de telefone deve ter exatamente 11 dígitos.");
                }
            } catch (InputMismatchException e) {
                // Captura a exceção se a entrada não for um número inteiro
                System.out.println("Entrada inválida. Por favor, insira um dado válido.");

                // Limpa o buffer se a próxima entrada não for um número inteiro
                if(!sc.hasNextInt()){
                    sc.nextLine();
                }

                telefone = sc.nextInt();
            }
        }
    }

    public void validaCPF(String CPF, Scanner sc) {
        boolean entradaValida = false;
        int soma1 = 0, soma2 = 0;
        int resto1, resto2;

        while (!entradaValida) {
            boolean todosIguais = true;

            // Verifica se todos os dígitos são iguais
            char primeiroCaractere = CPF.charAt(0);
            for (int i = 1; i < CPF.length(); i++) {
                char caractere = CPF.charAt(i);

                // Verifica se o caractere é um dígito
                if (Character.isDigit(caractere)) {
                    if (caractere != primeiroCaractere) {
                        todosIguais = false;
                    }
                }
            }

            if (!todosIguais) {
                while (!entradaValida) {
                    // Remove a máscara do CPF
                    String cpfSemMascara = CPF.replaceAll("[^0-9]", "");

                    // Verifica se o CPF sem máscara possui 11 dígitos
                    if (cpfSemMascara.length() == 11) {
                        // Restante da lógica de validação do CPF

                        // VERIFICAÇÃO DO PRIMEIRO DÍGITO
                        for (int i = 0; i < 9; i++) {
                            char caractere = cpfSemMascara.charAt(i);
                            soma1 += Character.getNumericValue(caractere) * (10 - i);
                        }

                        resto1 = (soma1 * 10) % 11;
                        if (resto1 == 10) {
                            resto1 = 0;
                        }

                        if (resto1 == Character.getNumericValue(cpfSemMascara.charAt(9))) {
                            // VERIFICAÇÃO DO SEGUNDO DÍGITO
                            for (int i = 0; i < 10; i++) {
                                char caractere = cpfSemMascara.charAt(i);
                                soma2 += Character.getNumericValue(caractere) * (11 - i);
                            }

                            resto2 = (soma2 * 10) % 11;
                            if (resto2 == 10) {
                                resto2 = 0;
                            }

                            if (resto2 == Character.getNumericValue(cpfSemMascara.charAt(10))) {
                                // CHECAGENS BEM-SUCEDIDAS
                                entradaValida = true;
                                setCpf(CPF);
                            } else {
                                // Falha na verificação do segundo dígito
                                System.out.println("CPF inválido.");
                            }
                        } else {
                            // Falha na verificação do primeiro dígito
                            System.out.println("CPF inválido.");
                        }
                    } else {
                        System.out.println("Formato ou entrada inválidos. O CPF deve conter 11 dígitos.");
                        System.out.println("Digite novamente: ");
                        if (!sc.hasNext()) {
                            sc.nextLine(); // Limpa buffer
                        }
                        CPF = sc.next();
                    }
                }
            } else {
                System.out.println("Digitos do CPF são todos iguais.");
            }

            if(!entradaValida) {
                // Solicita novo CPF
                System.out.println("Digite novamente: ");
                if (!sc.hasNext()) {
                    sc.nextLine(); // Limpa buffer
                }
                CPF = sc.next();
            }
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getRg() {
        return rg;
    }

    public void setRg(String rg) {
        this.rg = rg;
    }

    public String getDataDeNascimento() {
        return dataDeNascimento;
    }

    public void setDataDeNascimento(String dataDeNascimento) {
        this.dataDeNascimento = dataDeNascimento;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public int getTelefone() {
        return telefone;
    }

    public void setTelefone(int telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCpf: " + this.getCpf() + "\nRG: " + this.getRg() + "\nData de nascimento: " + this.getDataDeNascimento() + "\nSexo: " + this.getSexo() + "\nTelefone: " + this.getTelefone();
    }
}
