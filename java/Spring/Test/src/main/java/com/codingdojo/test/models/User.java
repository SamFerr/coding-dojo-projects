package com.codingdojo.test.models;

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
import javax.persistence.OneToMany;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Email;

@Entity
@Table(name="users")
public class User {

	@Id
	@GeneratedValue
	private Long id;
	
	@Size(min=3)
	private String name;
	
	@Email
	private String username;
	
	@Size(max=255)
	private String description;
	
	@Size(min=5)
	private String password;
	
	@Transient
	private String passwordConfirmation;
	
	@Column(updatable=false)
	private Date createdAt;
	private Date updatedAt;
	
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(
			name = "users_roles",
			joinColumns = @JoinColumn(name="user_id"),
			inverseJoinColumns = @JoinColumn(name="role_id"))
	private List<Role> roles;
	
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> friends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "friendships", 
    joinColumns = @JoinColumn(name = "friend_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> userFriends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "possible_friendships", 
    joinColumns = @JoinColumn(name = "user_id"), 
    inverseJoinColumns = @JoinColumn(name = "friend_id")
    )
    private List<User> maybeFriends;
    
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
    name = "possible_friendships", 
    joinColumns = @JoinColumn(name = "friend_id"), 
    inverseJoinColumns = @JoinColumn(name = "user_id")
    )
    private List<User> requestingFriends;
	
//    @OneToMany(mappedBy="request", fetch=FetchType.LAZY)
//    private List<User> requestingFriends;
//    
//    @ManyToOne(fetch=FetchType.LAZY)
//    @JoinColumn(name="user_id")
//    private User coolGuy;
    
	public User() {
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getPasswordConfirmation() {
		return passwordConfirmation;
	}

	public void setPasswordConfirmation(String passwordConfirmation) {
		this.passwordConfirmation = passwordConfirmation;
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

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

	public List<User> getFriends() {
		return friends;
	}

	public void setFriends(List<User> friends) {
		this.friends = friends;
	}

	public List<User> getUserFriends() {
		return userFriends;
	}

	public void setUserFriends(List<User> userFriends) {
		this.userFriends = userFriends;
	}

//	public List<User> getRequestingFriends() {
//		return requestingFriends;
//	}
//
//	public void setRequestingFriends(List<User> requestingFriends) {
//		this.requestingFriends = requestingFriends;
//	}
//
//	public User getCoolGuy() {
//		return coolGuy;
//	}
//
//	public void setCoolGuy(User coolGuy) {
//		this.coolGuy = coolGuy;
//	}

	public List<User> getMaybeFriends() {
		return maybeFriends;
	}

	public void setMaybeFriends(List<User> maybeFriends) {
		this.maybeFriends = maybeFriends;
	}

	public List<User> getRequestingFriends() {
		return requestingFriends;
	}

	public void setRequestingFriends(List<User> requestingFriends) {
		this.requestingFriends = requestingFriends;
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
