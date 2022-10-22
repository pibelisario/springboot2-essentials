package academy.devdojo.springboot2.service;

import academy.devdojo.springboot2.domain.Anime;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class AnimeService {

    private List<Anime> animes = List.of(new Anime(0L, "DBZ"), new Anime(1L, "Naturo"), new Anime(2L,"Hunter"));

    public List<Anime> list(){
        return animes;
    }

    public Anime findById(Long id) {
        return animes.stream()
                .filter(animes -> animes.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.BAD_REQUEST, "Id not found"));
    }
}
