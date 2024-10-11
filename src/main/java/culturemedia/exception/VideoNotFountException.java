package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFountException extends CultureMediaException {
    public VideoNotFountException(){super("Video no encontrado");};
    public VideoNotFountException(String titulo) {
        super(MessageFormat.format("Titulado: {0}", titulo));}
}
