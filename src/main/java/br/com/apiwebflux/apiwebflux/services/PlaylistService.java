package br.com.apiwebflux.apiwebflux.services;

import org.springframework.stereotype.Service;

import br.com.apiwebflux.apiwebflux.models.Playlist;
import br.com.apiwebflux.apiwebflux.repositorys.PlaylistRepository;
import lombok.AllArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@AllArgsConstructor
public class PlaylistService {

    private PlaylistRepository playlistRepository;

    public Flux<Playlist> findAll() {
        return playlistRepository.findAll();
    }

    public Mono<Playlist> findById(String id) {
        return playlistRepository.findById(id);
    }

    public Mono<Playlist> save(Playlist p) {
        return this.playlistRepository.save(p);
    }
}
