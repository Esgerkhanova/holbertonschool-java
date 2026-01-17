package com.song.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SongController {

    @Autowired
    private SongRepository songRepository;

    @GetMapping("/welcome")
    public String welcomeMessage() {
        return "WELCOME TO THE SONG API";
    }

    @GetMapping("/allSongs")
    public List<Song> getAllSongs() {
        return songRepository.getAllSongs();
    }

    @GetMapping("/findSong/{id}")
    public Song findSongById(@PathVariable Integer id) {
        return songRepository.getSongById(id);
    }

    @PostMapping(path = "/addSong", consumes = "application/json", produces = "application/json")
    public Song addSong(@RequestBody Song song) {
        songRepository.addSong(song);
        return song;
    }

    @PutMapping(path = "/updateSong", consumes = "application/json", produces = "application/json")
    public Song updateSong(@RequestBody Song song) {
        songRepository.updateSong(song);
        return song;
    }

    @DeleteMapping(path = "/removeSong", consumes = "application/json")
    public void deleteSong(@RequestBody Song song) {
        songRepository.removeSong(song);
    }
}
