// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Pessoa pessoa = new Pessoa("052138", "Ana");

        ControleTeleSena controleTeleSena = new ControleTeleSena();
        controleTeleSena.inserirPessoa(pessoa);
        controleTeleSena.comprarTeleSena(pessoa);
        controleTeleSena.comprarTeleSena(pessoa);
        Ganhador[] ganhadores = controleTeleSena.realizarSorteio();
    }
}