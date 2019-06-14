package com.codecool.seriesminiproject.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Episode {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @ManyToOne
    private Season season;

    private LocalDate releaseDate;

    @ElementCollection
    @Singular
    private List<String> stars;
}
