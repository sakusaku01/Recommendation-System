package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
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
    @Temporal(TemporalType.DATE)
    Date year;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date addDate;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date editDate;
    boolean isActive;

}
