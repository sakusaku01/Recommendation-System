package kg.megacom.Recommendation.system.Recommendation.system.model.entity;

import lombok.AccessLevel;
import lombok.Data;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;

@Data
@Entity
@ToString
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_music_author")
public class MusicAuthor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @ManyToOne
    @JoinColumn(name = "music_id")
    Music musicId;

    @ManyToOne
    @JoinColumn(name = "autor_id")
    Author authorId;
}
