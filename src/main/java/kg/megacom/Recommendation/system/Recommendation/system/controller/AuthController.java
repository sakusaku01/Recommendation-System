package kg.megacom.Recommendation.system.Recommendation.system.controller;

import kg.megacom.Recommendation.system.Recommendation.system.model.JwtUtils;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserEntityDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.entity.UserEntity;
import kg.megacom.Recommendation.system.Recommendation.system.model.request.LoginRequest;
import kg.megacom.Recommendation.system.Recommendation.system.model.request.SignUpRequest;
import kg.megacom.Recommendation.system.Recommendation.system.repository.UserEntityRepository;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserEntityServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.Map;
@RestController()
@RequestMapping("/api/v1/auth")
public class AuthController {
    private final AuthenticationManager authenticationManager;
    private final UserEntityRepository userRepository;
    private final JwtUtils utils;

    private final UserEntityServices services;

    public AuthController(AuthenticationManager authenticationManager, UserEntityRepository userRepository, JwtUtils utils, UserEntityServices services) {
        this.authenticationManager = authenticationManager;
        this.userRepository = userRepository;
        this.utils = utils;
        this.services = services;
    }

    @PostMapping("/login")
    public ResponseEntity<?> authenticate(@RequestBody LoginRequest request){
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(request.getEmail() , request.getPassword()));
            UserEntity user = userRepository.findByEmail(request.getEmail()).orElseThrow(()->new UsernameNotFoundException("User doesn't exists"));
            String token = utils.createToken(authentication);
            Map<Object ,Object> response = new HashMap<>();
            response.put("email",request.getEmail());
            response.put("token",token);
            return ResponseEntity.ok(response);

        }catch (AuthenticationException e){
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }
    @PostMapping("/signup")
    public ResponseEntity<?> register(@RequestBody UserEntityDTO dto){
        try {
            return ResponseEntity.ok(services.createRegister(dto));
        }catch (AuthenticationException e){
            return new ResponseEntity<>("Invalid email/password combination", HttpStatus.FORBIDDEN);
        }
    }

    @PostMapping("/logout")
    public void logout(HttpServletRequest request , HttpServletResponse response){
        SecurityContextLogoutHandler handler = new SecurityContextLogoutHandler();
        handler.logout(request,response,null);
    }
}
