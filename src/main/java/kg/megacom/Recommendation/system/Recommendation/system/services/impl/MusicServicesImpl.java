package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.MusicMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Author;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.MusicAuthor;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.repository.AuthorRepository;
import kg.megacom.Recommendation.system.Recommendation.system.repository.MusicRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.*;
import java.util.ArrayList;
import java.util.List;

@Service
public class MusicServicesImpl implements MusicServices {
    private final MusicRepository repository;
    private final AuthorRepository authorRepository;

    public MusicServicesImpl(MusicRepository repository, AuthorRepository authorRepository) {
        this.repository = repository;
        this.authorRepository = authorRepository;
    }

    @Override
    public MusicDTO save(MusicDTO musicDTO, int lang) {
        return MusicMapper.INSTANCE.toDto(repository.save(MusicMapper.INSTANCE.toEntity(musicDTO)));
    }

    @Override
    public MusicDTO findById(Long id, int lang) {
        return MusicMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Музыка под таким id не найдена")));
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

    @PersistenceContext()
    private EntityManager em;

    @Override
    public List<?> getFilter(String author, String music, String genre, int lang) {
        int count = 0;
        int orderCount = 0;

        StringBuilder sqlCode =
                new StringBuilder("select distinct m from Music m" +
                        " left join fetch m.authors a");

        if(author != null){
            Author author1 = authorRepository.findByName(author);

            if (count != 0) {
                sqlCode.append(" and");
                sqlCode.append(" m.authors =");
                sqlCode.append(author1);
            }else {
                sqlCode.append(" where a.authorId =");
                sqlCode.append(author1.getId());
            }
            count++;

        }
        return em.createQuery(sqlCode.toString()).getResultList();
    }

    @Override
    public List<MusicDTO> findAll(int lang) {
        return MusicMapper.INSTANCE.toDtos(repository.findAll());
    }

}
