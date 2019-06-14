package com.codecool.seriesminiproject.entities;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Season {

    @Id
    @GeneratedValue
    private long id;

    private String title;

    @Transient
    private int numberOfEpisodes;

    private LocalDate releaseDate;

    @Singular
    @OneToMany(mappedBy = "season", cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
    @EqualsAndHashCode.Exclude
    private Set<Episode> episodes;

    @ManyToOne
    private Series series;

    public void countEposiodes() {
        if (episodes.size() != 0) {
            numberOfEpisodes = episodes.size();
        }
    }
}
