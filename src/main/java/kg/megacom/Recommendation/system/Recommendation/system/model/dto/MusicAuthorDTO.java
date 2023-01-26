package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import lombok.*;

@Getter
@Setter
public class MusicAuthorDTO {
    Long id;
    MusicDTO musicId;
    AuthorDTO authorId;
    boolean isActive;
}
