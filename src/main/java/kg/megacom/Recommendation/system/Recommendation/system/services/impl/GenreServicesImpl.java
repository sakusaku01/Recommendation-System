package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.GenreMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.GenreDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.GenreRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.GenreServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServicesImpl implements GenreServices {
    private final GenreRepository repository;

    public GenreServicesImpl(GenreRepository repository) {
        this.repository = repository;
    }

    @Override
    public GenreDTO save(GenreDTO genreDTO, int lang) {
        return GenreMapper.INSTANCE.toDto(repository.save(GenreMapper.INSTANCE.toEntity(genreDTO)));
    }

    @Override
    public GenreDTO findById(Long id, int lang) {
        return GenreMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<GenreDTO> findAll(int lang) {
        return GenreMapper.INSTANCE.toDtos(repository.findAll());
    }
}
