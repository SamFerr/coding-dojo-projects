package com.codingdojo.overflow.models;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.validation.constraints.Size;

@Entity
@Table(name="answers")
public class AnswersModel {

		@Id
		@GeneratedValue
		private Long id;
		
		@Size(min=1, message="Answer must be present")
		private String answer;
		
		@Column(updatable=false)
		private Date createdAt;
		
		private Date updatedAt;
		
		@ManyToOne(fetch = FetchType.LAZY)
		@JoinColumn(name="question_id")
		private QuestionsModel question;
		
		public AnswersModel() {
		}
		
		
		public Long getId() {
			return id;
		}


		public void setId(Long id) {
			this.id = id;
		}


		public String getAnswer() {
			return answer;
		}


		public void setAnswer(String answer) {
			this.answer = answer;
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


		public QuestionsModel getQuestion() {
			return question;
		}


		public void setQuestion(QuestionsModel question) {
			this.question = question;
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
