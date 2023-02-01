package kg.megacom.Recommendation.system.Recommendation.system.model.entity;

import kg.megacom.Recommendation.system.Recommendation.system.model.enums.LikeStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_favorites")
public class Favorites {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Enumerated(value = EnumType.STRING)
    LikeStatus status;
    @Temporal(TemporalType.DATE)
    Date addDate;
    @Temporal(TemporalType.DATE)
    Date editDate;

    @ManyToOne
    @JoinColumn(name = "user_id")
    UserEntity userId;

    @ManyToOne
    @JoinColumn(name = "music_id")
    Music musicId;
    boolean isActive;
    String downloadUrl;

    @PrePersist
    protected void prePersist(){
        this.addDate = new Date();
        this.editDate = new Date();
        this.isActive = true;
    }
}
