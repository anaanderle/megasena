public class ControleTeleSena {
    private Pessoa[] pessoas;
    private TeleSena[] teleSenas;
    private TeleSena[] teleSenasDisponiveis;
    private int[] numerosSorteados;

    public ControleTeleSena() {
        this.pessoas = new Pessoa[VariaveisGlobais.quantidadeMaximaPessoasSorteio];
        this.teleSenas = new TeleSena[300];
        this.teleSenasDisponiveis = new TeleSena[300];
        this.numerosSorteados = new int[VariaveisGlobais.maiorNumeroSorteado];
        gerarTeleSenas();
    }

    public Pessoa[] getPessoas() {
        return pessoas;
    }

    public TeleSena[] getTeleSenas() {
        return teleSenas;
    }

    public TeleSena[] getTeleSenasDisponiveis() {
        return teleSenasDisponiveis;
    }

    private void gerarTeleSenas(){
        for(int i = 0; i < teleSenas.length; i++){
            TeleSena teleSena = new TeleSena();
            teleSenas[i] = teleSena;
            teleSenasDisponiveis[i] = teleSena;
        }
    }

    public boolean inserirPessoa(Pessoa pessoa){
        for(int i = 0; i < pessoas.length; i++){
            if(pessoas[i] == null){
                pessoas[i] = pessoa;
                return true;
            }
        }

        return false;
    }

    public boolean comprarTeleSena(Pessoa pessoa){
        for(int i = 0; i < pessoas.length; i++){
            if(pessoas[i] != null && pessoas[i].getCpf().equals(pessoa.getCpf())){
                for(int j = 0; j < teleSenasDisponiveis.length; j++){
                    if(teleSenasDisponiveis[j] != null){
                        boolean isTeleSenaComprada = pessoas[i].comprarTelesena(teleSenasDisponiveis[j]);

                        if(isTeleSenaComprada){
                            teleSenasDisponiveis[j] = null;
                            return true;
                        }
                    }
                }
            }
        }

        return false;
    }

    public Ganhador[] realizarSorteio(){
        Ganhador[] ganhadores = new Ganhador[VariaveisGlobais.quantidadeMaximaPessoasSorteio];
        int quantidadeGanhadores = 0;

        for (int i = 0; i < VariaveisGlobais.quantidadeNumerosTeleSena; i++) {
            int numeroSorteado = Util.sorteiaNumero();

            if(!Util.verificaNumeroExiste(numerosSorteados, numeroSorteado))
                numerosSorteados[i] = numeroSorteado;
            else
                i--;
        }

        ganhadores = verificaGanhadores();

        for(int i = 0; i < ganhadores.length; i++){
            if(ganhadores[i] != null){
                System.out.println("Vencedor de primeira.");
                quantidadeGanhadores++;
            }
        }

        System.out.println("Números sorteados: " + Util.conjuntoToString(numerosSorteados));
        System.out.println("Ganhadores: " + quantidadeGanhadores);

        if(quantidadeGanhadores != 0){
            return ganhadores;
        }

        for (int i = VariaveisGlobais.quantidadeNumerosTeleSena; i < VariaveisGlobais.maiorNumeroSorteado; i++){
            int numeroSorteado = Util.sorteiaNumero();

            if(!Util.verificaNumeroExiste(numerosSorteados, numeroSorteado)) {
                numerosSorteados[i] = numeroSorteado;
                ganhadores = verificaGanhadores();
                for(int j = 0; j < ganhadores.length; j++){
                    if(ganhadores[j] != null){
                        System.out.println("Vencedor.");
                        quantidadeGanhadores++;
                    }
                }
                System.out.println("Números sorteados: " + Util.conjuntoToString(numerosSorteados));
                System.out.println("Ganhadores: " + quantidadeGanhadores);
                if(quantidadeGanhadores != 0)
                    return ganhadores;
            }else
                i--;
        }

        return ganhadores;
    }

    private Ganhador[] verificaGanhadores(){
        Ganhador[] ganhadores = new Ganhador[VariaveisGlobais.quantidadeMaximaPessoasSorteio];

        for(int i = 0; i < pessoas.length; i++){
            if(pessoas[i] != null){
                for(int j = 0; j < pessoas[i].getTeleSenas().length; j++){
                    if(pessoas[i].getTeleSenas()[j] != null){
                        int[] numeros1 = pessoas[i].getTeleSenas()[j].getNumeros1();
                        int[] numeros2 = pessoas[i].getTeleSenas()[j].getNumeros2();
                        int acertos1 = 0;
                        int acertos2 = 0;

                        for(int k = 0; k < numeros1.length; k++){
                            if(Util.verificaNumeroExiste(numerosSorteados, numeros1[k]))
                                acertos1++;
                        }

                        for(int k = 0; k < numeros2.length; k++){
                            if(Util.verificaNumeroExiste(numerosSorteados, numeros2[k]))
                                acertos2++;
                        }

                        System.out.println("Numero de acertos: " + acertos1 + " e " + acertos2);

                        if(acertos1 == VariaveisGlobais.quantidadeNumerosTeleSena || acertos2 == VariaveisGlobais.quantidadeNumerosTeleSena){
                            boolean ganhadorInserido = false;

                            for(int k = 0; k < ganhadores.length; k++){
                                if(ganhadores[k] != null && ganhadores[k].getPessoa().getCpf().equals(pessoas[i].getCpf())) {
                                    ganhadores[k].incrementarVitorias();
                                    ganhadorInserido = true;
                                    break;
                                }
                            }

                            if(!ganhadorInserido) {
                                for (int k = 0; k < ganhadores.length; k++) {
                                    if (ganhadores[k] == null) {
                                        ganhadores[k] = new Ganhador(pessoas[i]);
                                        break;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }

        return ganhadores;
    }

    @Override
    public String toString(){
        String retorno = "Controle tele sena:";

        retorno += "\nPessoas: \n";

        for (int i = 0; i < pessoas.length; i++){
            if(pessoas[i] != null)
                retorno += pessoas[i].toString() + "\n";
        }

        retorno += "Tele senas: \n";

        for (int i = 0; i < teleSenas.length; i++){
            if(teleSenas[i] != null)
                retorno += teleSenas[i].toString() + "\n";
        }

        return retorno;
    }
}
