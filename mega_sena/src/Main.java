public class Main {
    public static void main(String[] args) {
        ControleTeleSena controleTeleSena = new ControleTeleSena();

        String[] nomesFemininos = {"Ana", "Larissa", "Amanda", "Beatriz", "Eduarda", "Mariana", "Natália", "Sabrina", "Talita", "Vitória"};
        String[] nomesMasculinos = {"Bruno", "Carlos", "Daniel", "Eduardo", "Felipe", "Gustavo", "Henrique", "Igor", "João", "Pedro"};

        for(int i = 0; i < VariaveisGlobais.quantidadeMaximaPessoasSorteio; i++) {
            String nome = "";
            int num1 = (int) (Math.random() * 10);
            int num2 = (int) (Math.random() * 10);

            if(i % 2 == 0){
                nome = nomesFemininos[num1] + " " + nomesFemininos[num2];
            } else{
                nome = nomesMasculinos[num1] + " " + nomesMasculinos[num2];
            }

            Pessoa pessoaAtual = new Pessoa(String.valueOf(i + 1), nome);

            controleTeleSena.inserirPessoa(pessoaAtual);

            int numeroTeleSenaCompradas = (int) (Math.random() * 15 + 1);

            for(int j = 0; j < numeroTeleSenaCompradas; j++){
                controleTeleSena.comprarTeleSena(pessoaAtual);
            }
        }

        controleTeleSena.realizarSorteio();
    }
}