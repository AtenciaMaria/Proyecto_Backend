package culturemedia.repository;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFountException;
import culturemedia.model.Video;
import culturemedia.model.View;

import java.util.List;

public interface CultureMediaService {
    List<Video> listarTodos();
    Video agregar(Video video) throws DuracionNotValidException;
    View agregar(View view) throws VideoNotFountException;
}
