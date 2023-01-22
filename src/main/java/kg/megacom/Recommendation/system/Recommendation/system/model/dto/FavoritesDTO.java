package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import kg.megacom.Recommendation.system.Recommendation.system.model.enums.LikeStatus;
import lombok.*;

import java.util.Date;

@Getter
@Setter
public class FavoritesDTO {


    Long id;
    LikeStatus status;
    Date addDate;
    Date editDate;
    UserEntityDTO userId;
    MusicDTO musicId;
}
