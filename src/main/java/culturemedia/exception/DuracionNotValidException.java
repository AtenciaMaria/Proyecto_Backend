package culturemedia.exception;

import java.text.MessageFormat;

public class DuracionNotValidException extends CultureMediaException {
    public DuracionNotValidException(String titulo, Double duracion){
        super("Duración no válida");
    };
}
