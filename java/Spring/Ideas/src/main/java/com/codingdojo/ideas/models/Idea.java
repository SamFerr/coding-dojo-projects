package com.codingdojo.ideas.models;

import java.util.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="ideas")
public class Idea {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1)
	private String content;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "likes",
			joinColumns = @JoinColumn(name="idea_id"),
			inverseJoinColumns = @JoinColumn(name="user_id"))
	private List<User> likers;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name="user_id")
	private User creator;
	
	public Idea(){
	}
	
	public Long getId() {
		return id;
	}



	public void setId(Long id) {
		this.id = id;
	}



	public String getContent() {
		return content;
	}



	public void setContent(String content) {
		this.content = content;
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
	

	public List<User> getLikers() {
		return likers;
	}

	public void setLikers(List<User> likers) {
		this.likers = likers;
	}

	public User getCreator() {
		return creator;
	}

	public void setCreator(User creator) {
		this.creator = creator;
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
