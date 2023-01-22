package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Author;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface AuthorMapper extends BaseMapper<Author, AuthorDTO>{
    AuthorMapper INSTANCE = Mappers.getMapper(AuthorMapper.class);
}
