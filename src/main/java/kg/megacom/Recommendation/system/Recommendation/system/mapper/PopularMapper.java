package kg.megacom.Recommendation.system.Recommendation.system.mapper;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.PopularDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Popular;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PopularMapper extends BaseMapper<Popular, PopularDTO>{
    PopularMapper INSTANCE = Mappers.getMapper(PopularMapper.class);

}
