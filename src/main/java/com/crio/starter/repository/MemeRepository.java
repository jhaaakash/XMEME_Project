package com.crio.starter.repository;

import java.util.List;
import java.util.Optional;
import com.crio.starter.data.Meme;
import org.springframework.data.domain.Pageable;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface MemeRepository extends MongoRepository<Meme, String> {

    Optional<Meme> findByNameAndCaptionAndUrl(String name, String caption, String url);
    List<Meme> findTop100ByOrderByCreatedDateDesc();
}
