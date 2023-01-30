package kg.megacom.Recommendation.system.Recommendation.system.services;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserFavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserFavorites;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;

import java.util.List;

public interface UserFavoritesServices extends BaseServices<UserFavoritesDTO>{
    List<UserFavorites> putThreeAuthors(Long id, List<Long> ids, int lang);
}
