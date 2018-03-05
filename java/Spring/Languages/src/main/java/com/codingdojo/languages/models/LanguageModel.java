package com.codingdojo.languages.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class LanguageModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Column
	@Size(min=2, max=20, message="Language name must be between 2 and 20 characters")
	private String language;
	
	@Column
	@Size(min=2, max=20, message="Creator must be between 2 and 20 characters")
	private String creator;
	
	@Column
	@Size(min=1, message="Version cannot be empty")
	private String version;
	
	@Column(updatable=false)
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date createdAt;
	
	@Column
	@DateTimeFormat(pattern="MM/dd/yyyy HH:mm:ss")
	private Date updatedAt;
	
	
	public LanguageModel() {
	}
	
	public LanguageModel(String language, String creator, String version, Long id, Date createdAt, Date updatedAt) {
		this.language = language;
		this.creator = creator;
		this.version = version;
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
	}
	
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getVersion() {
		return version;
	}
	public void setVersion(String version) {
		this.version = version;
	}
	
	public Long getId() {
		return id;
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
