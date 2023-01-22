package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import lombok.*;

import java.util.Date;
@Getter
@Setter
public class MusicGenreDTO {
    Long id;
    Date addDate;
    Date editDate;
    MusicDTO musicId;
    GenreDTO genreId;
}
