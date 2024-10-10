package artifactId.model;

import java.time.LocalDateTime;

public record View(String usuario, LocalDateTime fechaHora, Integer edad, Video video){
}
