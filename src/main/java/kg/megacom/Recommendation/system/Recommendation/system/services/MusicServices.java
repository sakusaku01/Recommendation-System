package kg.megacom.Recommendation.system.Recommendation.system.services;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicResponse;

import java.util.List;

public interface MusicServices extends BaseServices<MusicDTO>{

    List<MusicRepoResponse> findResponse(String authorName, int lang);
}
