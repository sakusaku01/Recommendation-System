package kg.megacom.Recommendation.system.Recommendation.system.model.entity;

import kg.megacom.Recommendation.system.Recommendation.system.model.enums.RoleStatus;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_popular")
public class Popular {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    int orderNum;
    @Temporal(TemporalType.DATE)
    Date addDate;
    @OneToOne
    @JoinColumn(name = "music_id")
    Music musicId;
}
