package kg.megacom.Recommendation.system.Recommendation.system.model.request;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.FieldDefaults;

import java.util.Set;

@Getter
@Setter
@FieldDefaults(level = AccessLevel.PRIVATE)
public class SignUpRequest {
    String username;
    String email;
    String password;
    String gender;

    boolean isActive;
    int age;
    Set<String> roles;

}
