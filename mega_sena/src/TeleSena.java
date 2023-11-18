public class TeleSena {
    private double valorVenda;
    private int[] numeros1;
    private int[] numeros2;

    public TeleSena() {
        this.valorVenda = 10.00;
        this.numeros1 = new int[VariaveisGlobais.quantidadeNumerosTeleSena];
        this.numeros2 = new int[VariaveisGlobais.quantidadeNumerosTeleSena];

        preencheArray(numeros1);
        preencheArray(numeros2);
    }

    public double getValorVenda() {
        return valorVenda;
    }

    public int[] getNumeros1() {
        return numeros1;
    }

    public int[] getNumeros2() {
        return numeros2;
    }

    public void preencheArray(int[] array){
        for (int i = 0; i < array.length; i++) {
            int numeroSorteado = Util.sorteiaNumero();

            if(!Util.verificaNumeroExiste(array, numeroSorteado))
                array[i] = numeroSorteado;
            else
                i--;
        }
    }

    @Override
    public String toString(){
        String retorno = "Tele Sena:";

        retorno += "\nPrimeiro conjunto de números:\n";
        retorno += Util.conjuntoToString(numeros1);

        retorno += "\nSegundo conjunto de números:\n";
        retorno += Util.conjuntoToString(numeros2);

        return retorno;
    }
}