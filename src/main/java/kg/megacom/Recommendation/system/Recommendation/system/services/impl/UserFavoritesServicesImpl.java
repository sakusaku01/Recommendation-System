package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.UserFavoritesMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserFavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.*;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.MusicRepoResponse;
import kg.megacom.Recommendation.system.Recommendation.system.repository.*;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserEntityServices;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserFavoritesServices;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class UserFavoritesServicesImpl implements UserFavoritesServices {
    private final UserFavoritesRepository repository;
    private final UserEntityRepository userEntityRepository;
    private final UserEntityServices services;
    private final MusicServices musicServices;
    private final MusicRepository musicRepository;
    private final AuthorRepository authorRepository;
    private final FavoritesRepository favoritesRepository;
    private final GenreRepository genreRepository;

    public UserFavoritesServicesImpl(UserFavoritesRepository repository, UserEntityRepository userEntityRepository, UserEntityServices services, MusicServices musicServices, MusicRepository musicRepository, AuthorRepository authorRepository, FavoritesRepository favoritesRepository, GenreRepository genreRepository) {
        this.repository = repository;
        this.userEntityRepository = userEntityRepository;
        this.services = services;
        this.musicServices = musicServices;
        this.musicRepository = musicRepository;
        this.authorRepository = authorRepository;
        this.favoritesRepository = favoritesRepository;
        this.genreRepository = genreRepository;
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

    @Override
    public Set<Music> getRecommendation(Long id, int lang) {
        List<Music> musicFormUser = getMusicFromUser(id,lang);
        Set<Music> music1 = null;
        for (Music music:musicFormUser) {
            List<Genre> genres = getGenreFromMusic(music,lang);
            music1 = getMusicFromGenre(genres,lang);
        }
        return music1;
    }
    public Set<Music> getMusicFromGenre(List<Genre> genres, int lang) {
        Set<Music> musics = new HashSet<>();
        for (Genre genre : genres) {
            List<Music> musicList = musicRepository.findMusicByGenre(genre.getId());
            musics.addAll(musicList);
        }
        return musics;
    }

    public List<Music> getMusicFromUser(Long userId, int lang) {
        List<Music> music = musicRepository.findByMusic(userId);
        return music;
    }

    public List<Genre> getGenreFromMusic(Music music, int lang) {
        List<Genre> genres = genreRepository.findByGenre(music.getId());
        return genres;
    }
}
