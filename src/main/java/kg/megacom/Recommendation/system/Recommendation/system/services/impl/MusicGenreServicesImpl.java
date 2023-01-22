package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicGenreDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicGenreServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicGenreServicesImpl implements MusicGenreServices {
    @Override
    public MusicGenreDTO save(MusicGenreDTO musicGenreDTO, int lang) {
        return null;
    }

    @Override
    public MusicGenreDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<MusicGenreDTO> findAll(int lang) {
        return null;
    }
}
