package com.codecool.seriesminiproject;

import com.codecool.seriesminiproject.entities.Channel;
import com.codecool.seriesminiproject.entities.Episode;
import com.codecool.seriesminiproject.entities.Season;
import com.codecool.seriesminiproject.entities.Series;
import com.codecool.seriesminiproject.repositories.SeriesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

import java.time.LocalDate;
import java.util.Arrays;

@SpringBootApplication
public class SeriesMiniProjectApplication {

    @Autowired
    SeriesRepository seriesRepository;

    public static void main(String[] args) {
        SpringApplication.run(SeriesMiniProjectApplication.class, args);
    }

    @Bean
    @Profile("produciton")
    public CommandLineRunner init() {
        return args -> {
            Season chernobyl1 = Season.builder()
                    .title("Chernobyl")
                    .releaseDate(LocalDate.of(2019, 5, 16))
                    .build();

            Season starWars1 = Season.builder()
                    .title("Star Wars")
                    .releaseDate(LocalDate.of(1979,8,16))
                    .build();

            Episode newHope = Episode.builder()
                    .title("A New Hope")
                    .releaseDate(LocalDate.of(1979, 8, 16))
                    .season(starWars1)
                    .starring(Arrays.asList("Mark Hamill", "Harrison Ford", "Carrie Fisher"))
                    .build();

            Episode empireStrikesBack = Episode.builder()
                    .title("The Empire Strikes Back")
                    .releaseDate(LocalDate.of(1982,1,28))
                    .season(starWars1)
                    .starring(Arrays.asList("Mark Hamill", "Harrison Ford", "Carrie Fisher", "Billy Dee Williams"))
                    .build();

            Episode chernobylE1 = Episode.builder()
                    .title("01")
                    .releaseDate(LocalDate.of(2019,5,16))
                    .season(chernobyl1)
                    .starring(Arrays.asList("Jared Harris", "Jessie Buckley", "Stellan Skarsgård"))
                    .build();

            Series chernobyl = Series.builder()
                    .title("Chernobyl")
                    .channel(Channel.HBO)
                    .season(chernobyl1)
                    .build();

            Series starWars = Series.builder()
                    .title("Star Wars")
                    .channel(Channel.CenturyFox)
                    .season(starWars1)
                    .build();

            chernobyl1.setSeries(chernobyl);
            starWars1.setSeries(starWars);

            seriesRepository.save(chernobyl);
            seriesRepository.save(starWars);
        };
    }

}
