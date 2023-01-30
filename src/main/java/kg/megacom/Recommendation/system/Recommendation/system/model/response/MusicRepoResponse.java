package kg.megacom.Recommendation.system.Recommendation.system.model.response;

import java.util.Date;

public interface MusicRepoResponse {
    String getMusic();
    String getAuthor();
    String getAlbum();
    Date getDate();
    Double getDuration();


}
