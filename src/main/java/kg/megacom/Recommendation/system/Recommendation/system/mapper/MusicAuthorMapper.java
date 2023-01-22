package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicAuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.MusicAuthor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MusicAuthorMapper extends BaseMapper<MusicAuthor, MusicAuthorDTO>{
    MusicAuthorMapper INSTANCE = Mappers.getMapper(MusicAuthorMapper.class);
}
