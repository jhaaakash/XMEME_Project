package com.crio.starter.controller;

import java.util.List;
import com.crio.starter.data.Meme;
import com.crio.starter.exception.InvalidMemeDataException;
import com.crio.starter.exception.MemeAlreadyExistsException;
import com.crio.starter.service.MemeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/memes")
public class MemeController {
    
    @Autowired
    private MemeService memeService;

    @PostMapping
    public ResponseEntity<?> createMeme(@RequestBody Meme meme)
    {
        try {
            Meme savedMeme = memeService.saveMeme(meme);
            return new ResponseEntity<Meme>(savedMeme, HttpStatus.CREATED);
        } catch (MemeAlreadyExistsException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        } catch (InvalidMemeDataException e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping
    public ResponseEntity<List<Meme>> getAllMeme()
    {
        List<Meme> memes = memeService.getAllMemes();
        return new ResponseEntity<>(memes, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Meme> getMemeById(@PathVariable String id)
    {
        Meme meme =memeService.getMemebyId(id);
        if(meme ==null)
        {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(meme, HttpStatus.OK);
    }


    

}
