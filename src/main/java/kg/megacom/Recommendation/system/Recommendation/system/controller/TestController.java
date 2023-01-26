package kg.megacom.Recommendation.system.Recommendation.system.controller;

import kg.megacom.Recommendation.system.Recommendation.system.services.MusicServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/v1/test")
public class TestController {
    private final MusicServices services;

    public TestController(MusicServices services) {
        this.services = services;
    }

    @PostMapping("/getResponse")
    public ResponseEntity<?> getResponse(@RequestBody String authorName , int lang){
        try {
            return ResponseEntity.ok(services.findResponse(authorName,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
