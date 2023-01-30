package kg.megacom.Recommendation.system.Recommendation.system.services;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;

import java.math.BigDecimal;
import java.util.List;

public interface MusicServices extends BaseServices<MusicDTO>{

    List<MusicRepoResponse> findResponse(String authorName, int lang);

    List<MusicRepoResponse> findByName(String name, int lang);

    List<Music>  findByAuthorName(String name, int lang);

    List<?> getFilter(String author, int lang);

}
