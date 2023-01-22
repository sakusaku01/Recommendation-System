package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.AlbumMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AlbumDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.AlbumRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.AlbumServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AlbumServicesImpl implements AlbumServices {
    private final AlbumRepository repository;

    public AlbumServicesImpl(AlbumRepository repository) {
        this.repository = repository;
    }

    @Override
    public AlbumDTO save(AlbumDTO albumDTO, int lang) {
        return AlbumMapper.INSTANCE.toDto(repository.save(AlbumMapper.INSTANCE.toEntity(albumDTO)));
    }

    @Override
    public AlbumDTO findById(Long id, int lang) {
        return AlbumMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<AlbumDTO> findAll(int lang) {
        return AlbumMapper.INSTANCE.toDtos(repository.findAll());
    }
}
