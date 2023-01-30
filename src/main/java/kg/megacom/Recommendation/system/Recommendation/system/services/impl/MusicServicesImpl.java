package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.MusicMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.repository.MusicRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.ArrayList;
import java.util.List;

import static kg.megacom.Recommendation.system.Recommendation.system.repository.MusicRepository.*;

@Service
public class MusicServicesImpl implements MusicServices {
    private final MusicRepository repository;

    public MusicServicesImpl(MusicRepository repository) {
        this.repository = repository;
    }

    @Override
    public MusicDTO save(MusicDTO musicDTO, int lang) {
        return MusicMapper.INSTANCE.toDto(repository.save(MusicMapper.INSTANCE.toEntity(musicDTO)));
    }

    @Override
    public MusicDTO findById(Long id, int lang) {
        return MusicMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }
    @Override
    public List<MusicRepoResponse> findResponse(String authorName, int lang) {
        List<MusicRepoResponse> musicRepoResponses = new ArrayList<>();
        List<MusicRepoResponse> repoResponse = repository
                .findMusicRepo(authorName);

        return repoResponse;
    }

    @Override
    public List<MusicRepoResponse>  findByName(String name, int lang) {
        return repository.findByName(name);
    }

    @Override
    public List<Music>  findByAuthorName(String name, int lang) {
        return repository.findByAuthorName(name);
    }
    @Override
    public List<?> getFilter(String author, int lang) {
        return repository.findAll(hasGenre(author));
    }

    @Override
    public List<MusicDTO> findAll(int lang) {
        return MusicMapper.INSTANCE.toDtos(repository.findAll());
    }

    @PersistenceContext()
    private EntityManager entityManager;


}
