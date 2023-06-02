package br.com.apiwebflux.apiwebflux.services;

import org.springframework.beans.BeanUtils;
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

    public Mono<Playlist> update(String id, Playlist p) {
        return playlistRepository.findById(id).flatMap(existingPlaylist -> {
            BeanUtils.copyProperties(p, existingPlaylist, "id");
            return playlistRepository.save(existingPlaylist);
        });
    }

    public void delete(String id) {
        playlistRepository.findById(id).flatMap(existingPlaylist -> playlistRepository.delete(existingPlaylist));
    }
}
