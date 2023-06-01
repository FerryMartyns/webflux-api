package br.com.apiwebflux.apiwebflux.models;

import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Document
@AllArgsConstructor
@NoArgsConstructor
public class Playlist {

    @Transient
    public static final String SEQUENCE_NAME = "users_sequence";

    @Id
    private String id;
    private String name;
}
