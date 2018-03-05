package com.codingdojo.lookify.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.lookify.models.Song;
import com.codingdojo.lookify.repositories.SongRepository;

@Service
public class SongService {
	
	private final SongRepository songRepository;
	
	public SongService(SongRepository songRepository) {
		this.songRepository = songRepository;
	}

	public List<Song> findAll() {
		return songRepository.findAll();
	}
	
	public List<Song> findTop10ByOrderByRatingDesc(){
		return songRepository.findTop10ByOrderByRatingDesc();
	}

	public void addSong(Song song) {
		songRepository.save(song);
	}

	public void deleteSong(Long id) {
		songRepository.delete(id);
	}

	public Song findSongById(Long id) {
		return songRepository.findOne(id);
	}

	public List<Song> searchByArtist(String artist) {
		return songRepository.findByArtistContaining(artist);
	}

}
