package com.ndduroc.rocmovies.Services.Interfaces;
import com.ndduroc.rocmovies.entity.Style;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

@Service
public class StyleService {

    @Autowired
    private StyleRepository repo;

    public Flux<Style> getAllStyles() {
        return repo.findAll();
    }
}
