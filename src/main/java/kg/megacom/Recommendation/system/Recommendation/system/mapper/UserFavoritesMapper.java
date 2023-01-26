package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserFavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserFavorites;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface UserFavoritesMapper extends BaseMapper<UserFavorites, UserFavoritesDTO>{
    UserFavoritesMapper INSTANCE = Mappers.getMapper(UserFavoritesMapper.class);

}
