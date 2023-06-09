package br.com.apiwebflux.apiwebflux.controllers;

import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.apiwebflux.apiwebflux.models.Playlist;
import br.com.apiwebflux.apiwebflux.services.PlaylistService;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@AllArgsConstructor
@RequestMapping("/playlists")
public class PlaylistController {

    private PlaylistService playlistService;

    @GetMapping
    public ResponseEntity<Flux<Playlist>> findAll() {
        return ResponseEntity.ok(playlistService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Mono<Playlist>> findById(@PathVariable String id) {
        return ResponseEntity.ok(playlistService.findById(id));
    }

    @PostMapping
    @Transactional
    public ResponseEntity<Mono<Playlist>> save(@RequestBody Playlist p) {
        return ResponseEntity.ok(playlistService.save(p));
    }

    @Transactional
    @PutMapping("/{id}")
    public ResponseEntity<Mono<Playlist>> update(@PathVariable String id, @RequestBody Playlist p) {
        return ResponseEntity.ok(playlistService.update(id, p));
    }

    @Transactional
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        playlistService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
