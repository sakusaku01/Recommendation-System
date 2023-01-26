package kg.megacom.Recommendation.system.Recommendation.system.model.entity;

import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_album")
public class Album {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int countMusic;
    String image;
    @Temporal(TemporalType.DATE)
    Date year;
    @Temporal(TemporalType.DATE)
    Date addDate;
    @Temporal(TemporalType.DATE)
    Date editDate;
    boolean isActive;
    @PrePersist
    protected void onCreate(){
        this.addDate = new Date();
        this.editDate = null;
    }
}
