package kg.megacom.Recommendation.system.Recommendation.system.model.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@Entity
@FieldDefaults(level = AccessLevel.PRIVATE)
@Table(name = "tb_author")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    String name;
    int age;
    String nominations;
    String country;
    @Temporal(TemporalType.DATE)
    Date addDate;
    @Temporal(TemporalType.DATE)
    Date editDate;
    boolean isActive;

    @PrePersist
    protected void prePersist(){
        this.addDate = new Date();
        this.editDate = new Date();
    }

}
