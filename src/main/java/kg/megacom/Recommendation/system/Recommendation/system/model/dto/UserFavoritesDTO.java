package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import kg.megacom.Recommendation.system.Recommendation.system.model.entity.Author;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserEntity;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class UserFavoritesDTO {

    Long id;

    Author authorId;

    UserEntity userEntityId;
}
