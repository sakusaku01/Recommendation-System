package kg.megacom.Recommendation.system.Recommendation.system.controller;

import kg.megacom.Recommendation.system.Recommendation.system.model.dto.AlbumDTO;
import kg.megacom.Recommendation.system.Recommendation.system.services.AlbumServices;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/al")
public class AlbumController {
    private final AlbumServices services;

    public AlbumController(AlbumServices services) {
        this.services = services;
    }
    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> save(@RequestBody AlbumDTO dto,int lang){
        try {
            return ResponseEntity.ok(services.save(dto,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(), HttpStatus.I_AM_A_TEAPOT);
        }
    }

    @GetMapping("/get")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<?> findById(@RequestParam Long id,int lang){
        try {
            return ResponseEntity.ok(services.findById(id,lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/get/all")
    @PreAuthorize("hasRole('ADMIN') or hasRole('USER')")
    public ResponseEntity<?> findAll(@RequestParam int lang){
        try {
            return ResponseEntity.ok(services.findAll(lang));
        }catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.I_AM_A_TEAPOT);
        }
    }
}
