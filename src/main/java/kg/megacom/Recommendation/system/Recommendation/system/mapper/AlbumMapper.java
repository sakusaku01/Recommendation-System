package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AlbumDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Album;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
@Mapper
public interface AlbumMapper extends BaseMapper<Album, AlbumDTO>{
    AlbumMapper INSTANCE = Mappers.getMapper(AlbumMapper.class);
}
