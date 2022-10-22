package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.AllArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("animes")
@Log4j2
@AllArgsConstructor
public class AnimeController {

    private AnimeService animeService;
    private DateUtil dateUtil;


    //localhost:8080/anime/list
    @GetMapping
    public ResponseEntity<List<Anime>> listAll(){
        log.info(dateUtil.formatLocalDateTimeToDataBaseStyle(LocalDateTime.now()));
        return  ResponseEntity.ok(animeService.list());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Anime> findByID(@PathVariable Long id){
        return ResponseEntity.ok(animeService.findById(id));
    }
}