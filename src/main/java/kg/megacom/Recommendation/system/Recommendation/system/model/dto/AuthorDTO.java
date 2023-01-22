package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

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
    Date addDate;
    Date editDate;

}
