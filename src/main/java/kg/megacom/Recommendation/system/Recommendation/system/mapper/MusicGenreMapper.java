package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicGenreDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.MusicGenre;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MusicGenreMapper extends BaseMapper<MusicGenre, MusicGenreDTO>{
    MusicGenreMapper INSTANCE = Mappers.getMapper(MusicGenreMapper.class);
}
