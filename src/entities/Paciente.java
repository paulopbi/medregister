package entities;

public class Paciente extends Pessoa{
    private boolean isDoadorDeOrgaos;
    private boolean isAlergico;
    private String preDiagnostico;
    private int nivelDeUrgencia;

    public Paciente(String nome, String cpf, String rg, String dataDeNascimento, char sexo, int telefone, boolean isDoadorDeOrgaos, boolean isAlergico, String preDiagnostico, int nivelDeUrgencia) {
        super(nome, cpf, rg, dataDeNascimento, sexo, telefone);
        this.isDoadorDeOrgaos = isDoadorDeOrgaos;
        this.isAlergico = isAlergico;
        this.preDiagnostico = preDiagnostico;
        this.nivelDeUrgencia = nivelDeUrgencia;
    }

    @Override
    public void alterarDados() {

    }
}
