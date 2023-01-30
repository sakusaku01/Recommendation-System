package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.UserFavoritesMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserFavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Author;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Music;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserEntity;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserFavorites;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicResponse;
import kg.megacom.Recommendation.system.Recommendation.system.repository.AuthorRepository;
import kg.megacom.Recommendation.system.Recommendation.system.repository.UserEntityRepository;
import kg.megacom.Recommendation.system.Recommendation.system.repository.UserFavoritesRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserEntityServices;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserFavoritesServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UserFavoritesServicesImpl implements UserFavoritesServices {
    private final UserFavoritesRepository repository;
    private final UserEntityRepository userEntityRepository;
    private final UserEntityServices services;
    private final MusicServices musicServices;

    private final AuthorRepository authorRepository;

    public UserFavoritesServicesImpl(UserFavoritesRepository repository, UserEntityRepository userEntityRepository, UserEntityServices services, MusicServices musicServices, AuthorRepository authorRepository) {
        this.repository = repository;
        this.userEntityRepository = userEntityRepository;
        this.services = services;
        this.musicServices = musicServices;
        this.authorRepository = authorRepository;
    }

    @Override
    public UserFavoritesDTO save(UserFavoritesDTO dto, int lang) {
        return UserFavoritesMapper.INSTANCE.toDto(repository.save(UserFavoritesMapper.INSTANCE.toEntity(dto)));
    }

    @Override
    public UserFavoritesDTO findById(Long id, int lang) {
        return UserFavoritesMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<UserFavoritesDTO> findAll(int lang) {
        return UserFavoritesMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public List<UserFavorites> putThreeAuthors(Long id,List<Long> ids, int lang) {
        UserEntity userEntity = userEntityRepository.findById(id).orElseThrow(()->new RuntimeException("User под таким id не найден"));

//        List<Author> authors = new ArrayList<>();

        for (int i = 0; i < ids.size(); i++) {
            UserFavorites userFavorites = new UserFavorites();
            Author author = authorRepository.findById(ids.get(i).longValue())
                    .orElseThrow(()->new RuntimeException("Author под таким id не найден"));
            userFavorites.setAuthorId(author);
            userFavorites.setUserEntityId(userEntity);
//            authors.add(author);
            repository.save(userFavorites);
        }
        return UserFavoritesMapper.INSTANCE.toEntities(findAll(lang));
//        List<MusicRepoResponse> repoResponses = new ArrayList<>();
//        for (int i = 0; i < authors.size(); i++) {
//            repoResponses = musicServices.findResponse(authors.get(i).getName(),lang);
//        }
//        return repoResponses;
    }
}
