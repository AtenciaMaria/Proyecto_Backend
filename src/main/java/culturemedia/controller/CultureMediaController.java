package culturemedia.controller;

import java.text.MessageFormat;
import java.util.*;

import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.service.CultureMediaService;

public class CultureMediaController {

	private final CultureMediaService cultureMediaService;


	public CultureMediaController(CultureMediaService cultureMediaService) {
		this.cultureMediaService = cultureMediaService;
	}


	public List<Video> findAllVideos() throws VideoNotFoundException {
		try{
			List<Video> videos = cultureMediaService.listarTodos();
			return videos;
		}catch (VideoNotFoundException videoNotFoundException){
			throw videoNotFoundException;
		}


	}


}
