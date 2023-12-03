public class Util {
    public static int sorteiaNumero(){
        return (int) (Math.random() * VariaveisGlobais.maiorNumeroSorteado + 1);
    }

    public static boolean verificaNumeroExiste(int[] array, int numero){
        for (int i = 0; i < array.length; i++) {
            if(array[i] == numero){
                return true;
            }
        }
        return false;
    }

    public static String conjuntoToString(int[] array){
        String retorno = "";

        for(int i = 0; i < array.length; i++){
            if(array[i] != 0)
                retorno += array[i] + "  ";
        }

        return retorno;
    }

    public static void delay(int tempo){
        try {
            Thread.sleep(tempo);
        } catch (InterruptedException e) {
            System.out.println("Ops, parece que aconteceu um problema com a Tele Sena!");
        }
    }
}
