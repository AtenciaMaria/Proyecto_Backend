package culturemedia.service;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> listarTodos() throws VideoNotFoundException;
    Video agregar(Video video) throws DuracionNotValidException;
    View agregar(View view) /*throws VideoNotFountException*/;
    List<Video> buscar(String titulo);
}
