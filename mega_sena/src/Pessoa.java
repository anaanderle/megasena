public class Pessoa {
    private String cpf;
    private String nome;
    private TeleSena[] teleSenas;
    private double valorPremiado;

    public Pessoa(String cpf, String nome) {
        this.cpf = cpf;
        this.nome = nome;
        this.teleSenas = new TeleSena[VariaveisGlobais.quantidadeMaximaTeleSenasPorPessoa];
        this.valorPremiado = 0.0;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public TeleSena[] getTeleSenas() {
        return teleSenas;
    }

    public double getValorPremiado() {
        return valorPremiado;
    }

    public boolean comprarTelesena(TeleSena teleSena){
        for(int i = 0; i < teleSenas.length; i++){
            if(teleSenas[i] == null){
                teleSenas[i] = teleSena;
                return true;
            }
        }

        return false;
    }

    @Override
    public String toString(){
        String retorno = "Pessoa: ";

        retorno += "\nNome: " + nome;
        retorno += "\nValor premiado: " + valorPremiado;
        retorno += "\nTele Senas: \n";

        for (int i = 0; i < teleSenas.length; i++) {
            if(teleSenas[i] != null)
                retorno += teleSenas[i].toString() + "\n";
        }

        return retorno;
    }
}
