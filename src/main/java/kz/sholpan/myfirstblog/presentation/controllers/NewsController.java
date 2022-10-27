package kz.sholpan.myfirstblog.presentation.controllers;

import kz.sholpan.myfirstblog.domain.news.model.News;
import kz.sholpan.myfirstblog.domain.news.repository.NewsRepository;
import kz.sholpan.myfirstblog.presentation.dtos.NewsDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Date;
import java.util.Optional;

@RestController
public class NewsController {

    @Autowired
    private NewsRepository newsRepository;

    @PostMapping("/news")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNews(@RequestBody NewsDto newsDto) {
        News news = new News(null, newsDto.getTitle(), newsDto.getText(),
                new Date(), newsDto.getAuthorFullName());
        newsRepository.save(news);
    }

    @GetMapping("/news")
    public Iterable<News> getNews(@PageableDefault Pageable pageable) {
        return newsRepository.findAll(pageable);
    }

    @GetMapping("/news/{id}")
    public Optional<News> getById(@PathVariable Long id) {
        return newsRepository.findById(id);
    }

    @PutMapping("/news/{id}")
    public void update(@PathVariable Long id, @RequestBody NewsDto updatedNewsDto) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "News not found!");
        }
        News n = optionalNews.get();
        n.setTitle(updatedNewsDto.getTitle());
        n.setText(updatedNewsDto.getText());
        n.setAuthorFullName(updatedNewsDto.getAuthorFullName());

        newsRepository.save(n);
    }

    @DeleteMapping("/news/{id}")
    public void delete(@PathVariable Long id) {
        Optional<News> optionalNews = newsRepository.findById(id);
        if (optionalNews.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "News not found!");

        }
        newsRepository.deleteById(id);
    }

}
