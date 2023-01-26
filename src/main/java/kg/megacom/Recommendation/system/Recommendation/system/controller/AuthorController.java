package kg.megacom.Recommendation.system.Recommendation.system.controller;

import io.swagger.annotations.Api;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AlbumDTO;
import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AuthorDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.AuthorServices;
import kg.megacom.Recommendation.system.Recommendation.system.swaggerconfig.Swagger2Config;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/au")
@Api(tags = Swagger2Config.Author)
public class AuthorController {
    private final AuthorServices services;

    public AuthorController(AuthorServices services) {
        this.services = services;
    }

    @PostMapping("/save")
    public ResponseEntity<?> save(@RequestBody AuthorDTO dto, int lang){
        try {
            return ResponseEntity.ok(services.save(dto,lang));
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
