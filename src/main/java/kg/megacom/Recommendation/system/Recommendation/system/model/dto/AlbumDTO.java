package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class AlbumDTO {
    Long id;
    String name;
    int countMusic;
    String image;
    Date year;
    Date addDate;
    Date editDate;

}
