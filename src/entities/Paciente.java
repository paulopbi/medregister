package entities;

public class Paciente extends Pessoa{
    private boolean isDoadorDeOrgaos;
    private boolean isAlergico;
    private String preDiagnostico;
    private byte nivelDeUrgencia;

    @Override
    public void alterarDados() {

    }
}
