package br.com.apiwebflux.apiwebflux.repositorys;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

import br.com.apiwebflux.apiwebflux.models.Playlist;

public interface PlaylistRepository extends ReactiveMongoRepository<Playlist, String>{
}
