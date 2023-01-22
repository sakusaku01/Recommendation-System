package kg.megacom.Recommendation.system.Recommendation.system.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Data
@Entity
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_music")
public class Music {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    String file;
    @Temporal(TemporalType.DATE)
    Date year;

    @Temporal(TemporalType.DATE)
    Date addDate;
    @Temporal(TemporalType.DATE)
    Date editDate;

    @ManyToOne
    @JoinColumn(name = "album_id")
    Album albumId;

    

}
