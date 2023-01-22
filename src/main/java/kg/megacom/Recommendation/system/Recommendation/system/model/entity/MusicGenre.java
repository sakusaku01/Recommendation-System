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
@Table(name = "tb_music_genre")
public class MusicGenre {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    @Temporal(TemporalType.DATE)
    Date addDate;
    @Temporal(TemporalType.DATE)
    Date editDate;

    @ManyToOne
    @JoinColumn(name = "music_id")
    Music musicId;

    @ManyToOne
    @JoinColumn(name = "genre_id")
    Genre genreId;
}
