package com.codingdojo.lookify.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="lookify")
public class Song {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=5, message="The title must be at least 5 characters long")
	private String title;
	
	@Column
	@Size(min=5, message="Artist must be 5 characters long")
	private String artist;
	
	@Column
	@Min(1)
	@Max(10)
	private int rating;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	public Song() {
	}
	
	public Song(String title, String artist, int rating, Long id, Date createdAt, Date updatedAt) {
		this.title = title;
		this.artist = artist;
		this.rating = rating;
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
    public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getArtist() {
		return artist;
	}
	public void setArtist(String artist) {
		this.artist = artist;
	}
	public int getRating() {
		return rating;
	}
	public void setRating(int rating) {
		this.rating = rating;
	}
	public Date getCreatedAt() {
		return createdAt;
	}
	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	public Date getUpdatedAt() {
		return updatedAt;
	}
	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}
	@PrePersist
    protected void onCreate(){
        this.createdAt = new Date();
    }
    @PreUpdate
    protected void onUpdate(){
        this.updatedAt = new Date();
    }
	

}
