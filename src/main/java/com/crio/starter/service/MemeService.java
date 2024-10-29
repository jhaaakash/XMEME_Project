package com.crio.starter.service;

import java.util.List;
import com.crio.starter.data.Meme;
import com.crio.starter.exception.InvalidMemeDataException;
import com.crio.starter.exception.MemeAlreadyExistsException;
import com.crio.starter.repository.MemeRepository;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
@Service
public class MemeService {
    private static final Logger logger = LoggerFactory.getLogger(MemeService.class);
    
    @Autowired
    MemeRepository memeRepository;

    public List<Meme> getAllMemes()
    {
        List<Meme> memes = memeRepository.findTop100ByOrderByCreatedDateDesc();
        logger.info("Fetched memes from database: {}", memes.size()); // Log the size of the fetched list
        return memes.isEmpty() ? List.of() : memes; // Ensure it returns an empty list if no memes
    }

    public Meme saveMeme(Meme meme)
    {
        validateMeme(meme);
        Optional<Meme> existingMeme = memeRepository.findByNameAndCaptionAndUrl(meme.getName(), meme.getCaption(), meme.getUrl());
        if (existingMeme.isPresent()) {
            throw new MemeAlreadyExistsException("Meme already exists"); // Custom exception
        }
        return memeRepository.save(meme);
    }

    public Meme getMemebyId(String id)
    {
        return memeRepository.findById(id).orElse(null);
    }

    private void validateMeme(Meme meme) {
        if (meme.getName() == null || meme.getName().isEmpty() ||
            meme.getCaption() == null || meme.getCaption().isEmpty() ||
            meme.getUrl() == null || meme.getUrl().isEmpty()) {
            throw new InvalidMemeDataException("Invalid meme data"); // Custom exception
        }
    }

}
