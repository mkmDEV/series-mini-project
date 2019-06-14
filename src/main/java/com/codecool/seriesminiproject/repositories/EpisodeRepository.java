package com.codecool.seriesminiproject.repositories;

import com.codecool.seriesminiproject.entities.Episode;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EpisodeRepository extends JpaRepository<Episode, Long> {
}
