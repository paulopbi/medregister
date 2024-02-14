package entities;

public abstract class Pessoa {
    protected long id;
    private String nome;
    private String cpf;
    private String rg;
    private String dataDeNascimento;
    private char sexo;
    private String telefone;



    public Pessoa(){}
    public Pessoa(String nome, String cpf, String rg, String dataDeNascimento, char sexo, String telefone) {
        this.setNome(nome);
        this.setCpf(cpf);
        this.setRg(rg);
        this.setDataDeNascimento(dataDeNascimento);
        this.setSexo(sexo);
        this.setTelefone(telefone);
    }

    public abstract void alterarDados();

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
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

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    @Override
    public String toString() {
        return "Nome: " + this.getNome() + "\nCpf: " + this.getCpf() + "\nRG: " + this.getRg()
                + "\nData de nascimento: " + this.getDataDeNascimento() + "\nSexo: " + this.getSexo()
                + "\nTelefone: " + this.getTelefone();
    }
}
