package com.codecool.seriesminiproject.repositories;

import com.codecool.seriesminiproject.entities.Episode;
import com.codecool.seriesminiproject.entities.Season;
import com.codecool.seriesminiproject.entities.Series;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@DataJpaTest
@ActiveProfiles("test")
public class AllRepositoryTest {

    @Autowired SeriesRepository seriesRepository;

    @Autowired SeasonRepository seasonRepository;

    @Autowired EpisodeRepository episodeRepository;

    @Autowired
    TestEntityManager entityManager;

    @Test
    public void saveOneSimple() {
        Series firts = Series.builder()
                .title("Test Serial")
                .build();

        seriesRepository.save(firts);

        List<Series> seriesList = seriesRepository.findAll();
        assertThat(seriesList).hasSize(1);
    }

    @Test
    public void saveSeriesWithoutTitle() throws DataIntegrityViolationException {
        Assertions.assertThrows(DataIntegrityViolationException.class, () -> {
            Series series = Series.builder()
                    .build();

            seriesRepository.save(series);
        });
    }

//    @Test
//    public void
}
