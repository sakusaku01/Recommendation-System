package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.PopularMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.PopularDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.PopularRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.PopularServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PopularServicesImpl implements PopularServices {
    private final PopularRepository repository;

    public PopularServicesImpl(PopularRepository repository) {
        this.repository = repository;
    }

    @Override
    public PopularDTO save(PopularDTO dto, int lang) {
        return PopularMapper.INSTANCE.toDto(repository.save(PopularMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public PopularDTO findById(Long id, int lang) {
        return PopularMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<PopularDTO> findAll(int lang) {
        return PopularMapper.INSTANCE.toDtos(repository.findAll());
    }
}
