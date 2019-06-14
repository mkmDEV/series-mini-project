package com.codecool.seriesminiproject.repositories;

import com.codecool.seriesminiproject.entities.Series;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SeriesRepository extends JpaRepository<Series, Long> {
}
