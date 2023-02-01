package kg.megacom.Recommendation.system.Recommendation.system.services.impl;

import kg.megacom.Recommendation.system.Recommendation.system.mapper.FavoritesMapper;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.FavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.MusicDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserEntityDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.enums.LikeStatus;
import kg.megacom.Recommendation.system.Recommendation.system.model.response.FavoritesResponse;
import kg.megacom.Recommendation.system.Recommendation.system.repository.FavoritesRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.FavoritesServices;
import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserEntityServices;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FavoritesServicesImpl implements FavoritesServices {
    private final FavoritesRepository repository;

    private final MusicServices services;
    private final UserEntityServices userServices;

    public FavoritesServicesImpl(FavoritesRepository repository, MusicServices services, UserEntityServices userServices) {
        this.repository = repository;
        this.services = services;
        this.userServices = userServices;
    }

    @Override
    public FavoritesDTO save(FavoritesDTO favoritesDTO, int lang) {
        return FavoritesMapper.INSTANCE.toDto(repository.save(FavoritesMapper.INSTANCE.toEntity(favoritesDTO)));
    }

    @Override
    public FavoritesDTO findById(Long id, int lang) {
        return FavoritesMapper.INSTANCE.toDto(repository.findById(id).orElseThrow(()->new RuntimeException("Альбом под таким id не найден")));
    }

    @Override
    public List<FavoritesDTO> findAll(int lang) {
        return FavoritesMapper.INSTANCE.toDtos(repository.findAll());
    }

    @Override
    public String myFavorites(Long musicId, Long userId, LikeStatus likeStatus, int lang) {
        MusicDTO dto = services.findById(musicId,lang);
        UserEntityDTO user = userServices.findById(userId,lang);
        FavoritesDTO favoritesDTO = new FavoritesDTO();
        favoritesDTO.setStatus(likeStatus);
        favoritesDTO.setMusicId(dto);
        favoritesDTO.setUserId(user);
        favoritesDTO.setDownloadUrl(dto.getFile());
        save(favoritesDTO,lang);

        return favoritesDTO.getDownloadUrl();
    }

}
