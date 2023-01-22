package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MusicServicesImpl implements MusicServices {
    @Override
    public MusicDTO save(MusicDTO musicDTO, int lang) {
        return null;
    }

    @Override
    public MusicDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<MusicDTO> findAll(int lang) {
        return null;
    }
}
