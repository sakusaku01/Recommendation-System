package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.FavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.FavoritesServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoritesServicesImpl implements FavoritesServices {
    @Override
    public FavoritesDTO save(FavoritesDTO favoritesDTO, int lang) {
        return null;
    }

    @Override
    public FavoritesDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<FavoritesDTO> findAll(int lang) {
        return null;
    }
}
