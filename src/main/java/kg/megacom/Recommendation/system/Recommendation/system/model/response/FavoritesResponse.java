package kg.megacom.Recommendation.system.Recommendation.system.model.response;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;


public interface FavoritesResponse {
    String getMusic();
    String getAuthor();
    String getAlbum();
    Date getDate();
    Double getDuration();
    String getDownloadUrl();
}
