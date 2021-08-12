package pt.isep.projectjavaws.exceptions;

public class ConversaoException extends RuntimeException {

    //Quando ocorre algum erro durante a serialização de uma classe este método permite mostrar uma mensagem de erro.
    public ConversaoException(String classe) {
        super("Erro a converter a classe:" + classe);
    }
}
