package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.RoleDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface RoleMapper extends BaseMapper<Role, RoleDTO>{
    RoleMapper INSTANCE = Mappers.getMapper(RoleMapper.class);
}
