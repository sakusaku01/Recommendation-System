package kg.megacom.Recommendation.system.Recommendation.system.services;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserEntityDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.request.SignUpRequest;
import org.springframework.http.ResponseEntity;


public interface UserEntityServices extends BaseServices<UserEntityDTO>{
    UserEntityDTO createRegister(SignUpRequest request);
}
