package culturemedia.service;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> listarTodos() throws VideoNotFoundException;
    Video agregar(Video video);
    View agregar(View view);
    List<Video> buscar(String titulo) throws VideoNotFoundException;
    List<Video> buscar(Double desdeDuracion, Double hastaDuracion)throws VideoNotFoundException;
}
