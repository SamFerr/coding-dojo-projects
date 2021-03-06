package com.codingdojo.overflow.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="questions")
public class QuestionsModel {
	
	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=1, message="You have to ask a question...")
	private String question;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(
			name = "tags_questions",
			joinColumns = @JoinColumn(name = "question_id"),
			inverseJoinColumns = @JoinColumn(name="tag_id")
	)
	
	@OneToMany(mappedBy="question", fetch = FetchType.LAZY)
	private List<AnswersModel> answers;
	
    @Size(max=3, message="Cannot have more than 3 tags")
    private List<TagsModel> tags;
	
	public QuestionsModel() {
	}
	
	
	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public String getQuestion() {
		return question;
	}


	public void setQuestion(String question) {
		this.question = question;
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


	public List<AnswersModel> getAnswers() {
		return answers;
	}


	public void setAnswers(List<AnswersModel> answers) {
		this.answers = answers;
	}


	public List<TagsModel> getTags() {
		return tags;
	}


	public void setTags(List<TagsModel> tags) {
		this.tags = tags;
	}


	@PrePersist
	void createdAt() {
		this.createdAt = new Date();
	}
	
	@PreUpdate
	void updatedAt() {
		this.updatedAt = new Date();
	}
}
