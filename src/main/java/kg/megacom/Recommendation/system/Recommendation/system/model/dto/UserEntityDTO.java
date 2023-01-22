package kg.megacom.Recommendation.system.Recommendation.system.model.dto;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.*;

import java.util.Date;
import java.util.Set;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntityDTO {

    Long id;
    String name;
    String email;
    String password;
    String gender;

    boolean isActive;
    int age;
    @JsonIgnore
    Date addDate;
    @JsonIgnore
    Date editDate;

    Set<String> roles;



}
