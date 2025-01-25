package br.com.musicaapp.musicapp.controller;

import org.springframework.stereotype.Controller;

import br.com.musicaapp.musicapp.repository.MusicoRepository;

@Controller
public class MusicoController {

    private MusicoRepository musicoRepository;

    public MusicoController(MusicoRepository musicoRepository){
        this.musicoRepository = musicoRepository;
    }
    
}
