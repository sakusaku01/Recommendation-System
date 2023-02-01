package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.FavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Favorites;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.stereotype.Service;

@Mapper
public interface FavoritesMapper extends BaseMapper<Favorites, FavoritesDTO>{
    FavoritesMapper INSTANCE = Mappers.getMapper(FavoritesMapper.class);

}
