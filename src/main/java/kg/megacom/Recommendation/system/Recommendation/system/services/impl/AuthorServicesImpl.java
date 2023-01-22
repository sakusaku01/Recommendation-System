package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.AuthorServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServicesImpl implements AuthorServices {
    @Override
    public AuthorDTO save(AuthorDTO authorDTO, int lang) {
        return null;
    }

    @Override
    public AuthorDTO findById(Long id, int lang) {
        return null;
    }

    @Override
    public List<AuthorDTO> findAll(int lang) {
        return null;
    }
}
