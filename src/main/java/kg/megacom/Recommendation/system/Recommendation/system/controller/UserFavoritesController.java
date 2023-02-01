package kg.megacom.Recommendation.system.Recommendation.system.controller;

import io.swagger.annotations.Api;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.UserFavoritesDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.UserFavoritesServices;
import kg.megacom.Recommendation.system.Recommendation.system.swaggerconfig.Swagger2Config;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/userF")
@Api(tags = Swagger2Config.UserFavorites)
public class UserFavoritesController {
    private final UserFavoritesServices services;

    public UserFavoritesController(UserFavoritesServices services) {
        this.services = services;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody UserFavoritesDTO dto, int lang){
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/put/three")
    public ResponseEntity<?> putThreeAuthors(@RequestParam(name = "your id") Long id ,
                                             @RequestParam(name = "author id") List<Long> ids, int lang){
        try {
            return ResponseEntity.ok(services.putThreeAuthors(id,ids,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/get/rec/fav")
    public ResponseEntity<?> getRecommendation(@RequestParam(name = "your id") Long id ,int lang){
        try {
            return ResponseEntity.ok(services.getRecommendation(id,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }


    @GetMapping("/get")
    public ResponseEntity<?> findById(@RequestParam Long id,int lang){
        try {
            return ResponseEntity.ok(services.findById(id,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/all")
    public ResponseEntity<?> findAll(@RequestParam int lang){
        try {
            return ResponseEntity.ok(services.findAll(lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
