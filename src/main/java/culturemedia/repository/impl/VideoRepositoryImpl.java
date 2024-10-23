package culturemedia.repository.impl;
import java.util.ArrayList;
import java.util.List;

import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;

public class VideoRepositoryImpl implements VideoRepository {

	private final List<Video> videos;

	public VideoRepositoryImpl() {
		videos = new ArrayList<>();
	}

	@Override
	public List<Video> listarTodos() {
		return videos;
	}

	@Override
	public Video agregarVideo(Video video) {
		this.videos.add( video );
		return video;
	}

	@Override
	public List<Video> buscar(String title) {
		List<Video> filteredVideos = null;
		for ( Video video : videos ) {
			if(title.equals( video.titulo() )){
				if(filteredVideos == null){
					filteredVideos = new ArrayList<Video>();
				}
				filteredVideos.add(video);
			}
		}
		return filteredVideos;
	}

	@Override
	public List<Video> buscar(Double fromDuration, Double toDuration) {
		List<Video> filteredVideos = new ArrayList<Video>();
		for ( Video video : videos ) {
			if(video.duracion()> fromDuration && video.duracion()< toDuration){
				filteredVideos.add(video);
			}
		}
		return filteredVideos;
	}
}
