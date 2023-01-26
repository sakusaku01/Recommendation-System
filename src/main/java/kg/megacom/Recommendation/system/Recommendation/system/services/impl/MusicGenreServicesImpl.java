package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.MusicGenreMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicGenreDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.MusicGenreRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicGenreServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicGenreServicesImpl implements MusicGenreServices {
    private final MusicGenreRepository repository;

    public MusicGenreServicesImpl(MusicGenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public MusicGenreDTO save(MusicGenreDTO dto, int lang) {
        return MusicGenreMapper.INSTANCE.toDto(repository.save(MusicGenreMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public MusicGenreDTO findById(Long id, int lang) {
        return MusicGenreMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<MusicGenreDTO> findAll(int lang) {
        return MusicGenreMapper.INSTANCE.toDtos(repository.findAll());
    }
}
