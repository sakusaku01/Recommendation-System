package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;
import lombok.experimental.FieldDefaults;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
public class AuthorDTO {

    Long id;
    String name;
    int age;
    String nominations;
    String country;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date addDate;
    @JsonIgnore
    @Temporal(TemporalType.DATE)
    Date editDate;
    boolean isActive;
}
