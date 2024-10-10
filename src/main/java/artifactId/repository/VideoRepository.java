package artifactId.repository;

import artifactId.model.Video;

import java.util.List;

public interface VideoRepository {
    List<Video> listarTodos();
    Video agregarVideo(Video video);
    List<Video> buscar(String titulo);
    List<Video> buscar(Double desdeDuracion, Double hastaDuracion);
}

