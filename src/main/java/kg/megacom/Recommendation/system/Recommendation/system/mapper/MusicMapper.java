package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MusicMapper extends BaseMapper<Music, MusicDTO>{
    MusicMapper INSTANCE = Mappers.getMapper(MusicMapper.class);
}
