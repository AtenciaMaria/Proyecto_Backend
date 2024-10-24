package culturemedia.exception;

import java.text.MessageFormat;

public class VideoNotFoundException extends CultureMediaException {
    public VideoNotFoundException(){super("Video no encontrado");};
    public VideoNotFoundException(String titulo) {
        super(MessageFormat.format("Titulado: {0}", titulo));}
}
