package culturemedia.repository.impl;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.CultureMediaService;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
    }
    @Override
    public List<Video> listarTodos() {
        return this.videoRepository.listarTodos();
    }

    @Override
    public Video agregar(Video video) throws DuracionNotValidException {
        if (video.duracion() <=0){
            throw new DuracionNotValidException(video.titulo(),video.duracion());
        }
        return this.videoRepository.agregarVideo(video);
    }

    @Override
    public View agregar(View view)  {
        return this.viewsRepository.agregar(view);
    }
}
