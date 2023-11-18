public class Ganhador{
    private Pessoa pessoa;
    private int quantidadeVitorias;

   public Ganhador(Pessoa pessoa) {
        this.pessoa = pessoa;
        this.quantidadeVitorias = 1;
    }

    public Pessoa getPessoa() {
        return pessoa;
    }

    public int getQuantidadeVitorias() {
        return quantidadeVitorias;
    }

    public void incrementarVitorias(){
       quantidadeVitorias++;
    }
}




