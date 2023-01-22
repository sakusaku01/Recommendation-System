package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.GenreDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Genre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface GenreMapper extends BaseMapper<Genre, GenreDTO>{
    GenreMapper INSTANCE = Mappers.getMapper(GenreMapper.class);
}
