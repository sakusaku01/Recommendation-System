package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import kg.megacom.Recommendation.system.Recommendation.system.model.enums.LikeStatus;
import lombok.*;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Getter
@Setter
public class FavoritesDTO {


    Long id;
    LikeStatus status;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date addDate;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date editDate;
    UserEntityDTO userId;
    MusicDTO musicId;
    boolean isActive;
    String downloadUrl;
}
