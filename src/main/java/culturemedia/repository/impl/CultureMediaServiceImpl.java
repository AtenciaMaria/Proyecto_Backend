package culturemedia.repository.impl;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFountException;
import culturemedia.model.Video;
import culturemedia.model.View;
import culturemedia.repository.CultureMediaService;

import java.util.ArrayList;
import java.util.List;

public class CultureMediaServiceImpl implements CultureMediaService {
    private final List<Video> videos = new ArrayList<>();
    private final List<View> views = new ArrayList<>();

    @Override
    public List<Video> listarTodos() {
        return new ArrayList<>(videos);
    }

    @Override
    public Video agregar(Video video) throws DuracionNotValidException {
        if (video.duracion() <=0){
            throw new DuracionNotValidException(video.titulo(),video.duracion());
        }
        videos.add(video);
        return video;
    }

    @Override
    public View agregar(View view) throws VideoNotFountException {
        Video encontrarVideo = videos.stream()
                .filter(p -> p.codigo().equals(view.video().codigo()))
                .findFirst()
                .orElse(null);
        if (encontrarVideo == null){
            throw new VideoNotFountException(view.video().titulo());
        }
        views.add(view);
        return view;
    }
}
