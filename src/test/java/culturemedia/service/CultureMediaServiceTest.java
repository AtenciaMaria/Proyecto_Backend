package culturemedia.service;

import culturemedia.exception.DuracionNotValidException;
import culturemedia.exception.VideoNotFoundException;
import culturemedia.model.Video;
import culturemedia.repository.VideoRepository;
import culturemedia.repository.ViewsRepository;
import culturemedia.service.impl.CultureMediaServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.doReturn;

class CultureMediaServiceTest {

    private CultureMediaService cultureMediaService;

    @Mock
    private VideoRepository videoRepository;
    @Mock
    private ViewsRepository viewsRepository;


    @BeforeEach
    void init(){
        MockitoAnnotations.initMocks(this);
        cultureMediaService = new CultureMediaServiceImpl(videoRepository , viewsRepository);
    }


    @Test
    void when_FindAll_all_videos_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("03", "Título 3", "----", 4.4),
                new Video("04", "Título 4", "----", 3.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)))
                .when(videoRepository).listarTodos();
        List<Video> videos = cultureMediaService.listarTodos( );
        assertFalse(videos.isEmpty());
    }

    @Test
    void when_FindAll_does_not_find_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(new ArrayList<>()).when(videoRepository).listarTodos();
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.listarTodos());
    }

    @Test
    void when_FindByTitle_only_videos_which_contains_the_word_in_the_title_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(List.of(new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)))
                .when(videoRepository).buscar("Clic");

        List<Video> videos = cultureMediaService.buscar( "Clic" );
        assertFalse(videos.isEmpty());
    }

    @Test
    void when_FindByTitle_does_not_match_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(new ArrayList<>()).when(videoRepository).buscar("No coincide");
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.buscar("No coincide"));
    }

    @Test
    void when_FindByDuration_only_videos_between_the_range_should_be_returned_successfully() throws VideoNotFoundException {
        doReturn(List.of(new Video("01", "Título 1", "----", 4.5),
                new Video("02", "Título 2", "----", 5.5),
                new Video("05", "Clic 5", "----", 5.7),
                new Video("06", "Clic 6", "----", 5.1)))
                .when(videoRepository).buscar(4.5, 5.7 );
        List<Video> videos = cultureMediaService.buscar( 4.5, 5.7 );
        assertFalse(videos.isEmpty());
    }

    @Test
    void when_FindByDuration_does_not_match_any_video_an_VideoNotFoundException_should_be_thrown_successfully() {
        doReturn(new ArrayList<>()).when(videoRepository).buscar(7.0,8.0);
        assertThrows(VideoNotFoundException.class, () -> cultureMediaService.buscar(7.0,8.0) );
    }
}