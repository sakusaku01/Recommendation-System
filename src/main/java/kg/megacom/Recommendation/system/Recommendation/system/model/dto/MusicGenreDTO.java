package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;
@Getter
@Setter
public class MusicGenreDTO {
    Long id;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date addDate;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date editDate;
    MusicDTO musicId;
    GenreDTO genreId;
}
