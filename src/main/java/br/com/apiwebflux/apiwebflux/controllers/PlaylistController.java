package br.com.apiwebflux.apiwebflux.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiwebflux.apiwebflux.models.Playlist;
import br.com.apiwebflux.apiwebflux.services.PlaylistService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;

@RestController
@AllArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {
    
    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<Flux<Playlist>> findAll() {
        return ResponseEntity.ok(playlistService.findAll());
    }
}
