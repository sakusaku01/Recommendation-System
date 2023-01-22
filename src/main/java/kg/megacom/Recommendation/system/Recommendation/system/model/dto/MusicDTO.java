package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
public class MusicDTO {
    Long id;
    String name;
    String file;
    Date year;
    Date addDate;
    Date editDate;
    AlbumDTO albumId;

    

}
