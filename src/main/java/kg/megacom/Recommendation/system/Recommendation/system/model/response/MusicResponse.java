package kg.megacom.Recommendation.system.Recommendation.system.model.response;

import kg.megacom.Recommendation.system.Recommendation.system.model.enums.LikeStatus;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Getter
@Setter
public class MusicResponse {
    String music;
    String album;
    String author;
    Date addDate;
    Double duration;
    int orderNum;

}
