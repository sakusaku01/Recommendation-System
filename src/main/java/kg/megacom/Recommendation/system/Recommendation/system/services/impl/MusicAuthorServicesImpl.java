package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.MusicAuthorMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicAuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.MusicAuthorRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicAuthorServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicAuthorServicesImpl implements MusicAuthorServices {
    private final MusicAuthorRepository repository;

    public MusicAuthorServicesImpl(MusicAuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public MusicAuthorDTO save(MusicAuthorDTO dto, int lang) {
        return MusicAuthorMapper.INSTANCE.toDto(repository.save(MusicAuthorMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public MusicAuthorDTO findById(Long id, int lang) {
        return MusicAuthorMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<MusicAuthorDTO> findAll(int lang) {
        return MusicAuthorMapper.INSTANCE.toDtos(repository.findAll());
    }
}
