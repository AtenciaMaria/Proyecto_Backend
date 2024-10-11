package culturemedia.exception;

import java.text.MessageFormat;

public class DuracionNotValidException extends CultureMediaException {
    public DuracionNotValidException(String titulo, Double duracion){
        super(MessageFormat.format("La duración {0} del video {1} no es válida", duracion, titulo));
    };
}
