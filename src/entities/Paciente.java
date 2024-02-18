package entities;

import java.time.LocalDate;

public class Paciente extends Pessoa{
    private boolean isDoadorDeOrgaos;
    private boolean isAlergico;
    private String preDiagnostico;
    private int nivelDeUrgencia;

    public Paciente(String nome, String cpf, LocalDate dataDeNascimento, char sexo, String telefone, boolean isDoadorDeOrgaos, boolean isAlergico, String preDiagnostico, int nivelDeUrgencia) {
        super(nome, cpf, dataDeNascimento, sexo, telefone);
        this.isDoadorDeOrgaos = isDoadorDeOrgaos;
        this.isAlergico = isAlergico;
        this.preDiagnostico = preDiagnostico;
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    @Override
    public void alterarDados() {
    }
}
