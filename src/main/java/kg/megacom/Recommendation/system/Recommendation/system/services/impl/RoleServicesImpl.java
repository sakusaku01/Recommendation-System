package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.RoleMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.RoleDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.RoleRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.RoleServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServicesImpl implements RoleServices {
    private final RoleRepository repository;

    public RoleServicesImpl(RoleRepository repository) {
        this.repository = repository;
    }

    @Override
    public RoleDTO save(RoleDTO dto, int lang) {
        return RoleMapper.INSTANCE.toDto(repository.save(RoleMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public RoleDTO findById(Long id, int lang) {
        return RoleMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<RoleDTO> findAll(int lang) {
        return RoleMapper.INSTANCE.toDtos(repository.findAll());
    }
}
