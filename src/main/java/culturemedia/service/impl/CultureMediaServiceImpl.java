package culturemedia.service.impl;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.service.CultureMediaService;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;

import java.util.ArrayList;
import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {

    private final VideoRepository videoRepository;
    private final ViewsRepository viewsRepository;
    private final List<Video> videos;

    public CultureMediaServiceImpl(VideoRepository videoRepository, ViewsRepository viewsRepository) {
        this.videoRepository = videoRepository;
        this.viewsRepository = viewsRepository;
        videos = new ArrayList<>();
    }

    @Override
    public List<Video> listarTodos() throws VideoNotFoundException {
        List<Video> videos = videoRepository.listarTodos();
        if (videos.isEmpty()) {
            throw new VideoNotFoundException();
        }
        return videos;
    }


    public Video agregar(Video video) throws DuracionNotValidException{
        if (video.duracion() <=0){
            throw new DuracionNotValidException(video.titulo(),video.duracion());
        }
        return this.videoRepository.agregarVideo(video);
    }

    @Override
    public View agregar(View view)  {
        return this.viewsRepository.agregar(view);
    }

    @Override
    public List<Video> buscar(String titulo) {
        List<Video> filteredVideos = null;
        for (Video video : videos) {
            if (video.titulo().toLowerCase().contains(titulo.toLowerCase())) {
                if (filteredVideos == null) {
                    filteredVideos = new ArrayList<Video>();
                }
                filteredVideos.add(video);
            }
        }
        return filteredVideos;
    }
}
