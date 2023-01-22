package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.GenreDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.GenreServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class GenreServicesImpl implements GenreServices {
    @Override
    public GenreDTO save(GenreDTO genreDTO, int lang) {
        return null;
    }

    @Override
    public GenreDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<GenreDTO> findAll(int lang) {
        return null;
    }
}
