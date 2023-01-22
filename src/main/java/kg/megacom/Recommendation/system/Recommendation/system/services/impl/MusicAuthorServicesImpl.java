package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicAuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicAuthorServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicAuthorServicesImpl implements MusicAuthorServices {
    @Override
    public MusicAuthorDTO save(MusicAuthorDTO musicAuthorDTO, int lang) {
        return null;
    }

    @Override
    public MusicAuthorDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<MusicAuthorDTO> findAll(int lang) {
        return null;
    }
}
