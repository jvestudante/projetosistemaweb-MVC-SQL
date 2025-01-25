package br.com.musicaapp.musicapp.controller;

import org.springframework.stereotype.Controller;

import br.com.musicaapp.musicapp.repository.AlbumRepository;

@Controller
public class AlbumController {

    private AlbumRepository albumRepository;

    public AlbumController(AlbumRepository albumRepository){
        this.albumRepository = albumRepository;
    }
    
}
