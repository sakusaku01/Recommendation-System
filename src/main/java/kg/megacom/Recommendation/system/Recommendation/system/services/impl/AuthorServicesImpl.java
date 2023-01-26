package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.AuthorMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.repository.AuthorRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.AuthorServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorServicesImpl implements AuthorServices {
    private final AuthorRepository repository;

    public AuthorServicesImpl(AuthorRepository repository) {
        this.repository = repository;
    }

    @Override
    public AuthorDTO save(AuthorDTO authorDTO, int lang) {
        return AuthorMapper.INSTANCE.toDto(repository.save(AuthorMapper.INSTANCE.toEntity(authorDTO)));
    }

    @Override
    public AuthorDTO findById(Long id, int lang) {
        return AuthorMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<AuthorDTO> findAll(int lang) {
        return AuthorMapper.INSTANCE.toDtos(repository.findAll());
    }
}
