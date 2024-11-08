package culturemedia.controller;

import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController(CultureMediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}

	@GetMapping("/videos")
	public List<Video> findAllVideos() throws VideoNotFoundException {
		try{
			List<Video> videos = cultureMediaService.listarTodos();
			return videos;
		}catch (VideoNotFoundException videoNotFoundException){
			throw videoNotFoundException;
		}
	}

	@PostMapping("/videos")
	public Video agregarVideo(@RequestBody Video video){
		cultureMediaService.agregar(video);
		return video;
    }

}
