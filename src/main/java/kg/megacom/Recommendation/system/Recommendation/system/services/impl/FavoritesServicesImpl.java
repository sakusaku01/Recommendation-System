package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.FavoritesMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.FavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.FavoritesRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.FavoritesServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoritesServicesImpl implements FavoritesServices {
    private final FavoritesRepository repository;

    public FavoritesServicesImpl(FavoritesRepository repository) {
        this.repository = repository;
    }

    @Override
    public FavoritesDTO save(FavoritesDTO favoritesDTO, int lang) {
        return FavoritesMapper.INSTANCE.toDto(repository.save(FavoritesMapper.INSTANCE.toEntity(favoritesDTO)));
    }

    @Override
    public FavoritesDTO findById(Long id, int lang) {
        return FavoritesMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<FavoritesDTO> findAll(int lang) {
        return FavoritesMapper.INSTANCE.toDtos(repository.findAll());
    }
}
