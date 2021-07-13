package com.fpt.main.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;


@Entity
@Table(name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email")
		})
public class User {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	private String userName;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 120)
	@JsonIgnore
	private String password;
	
	private String address;
	
	@Size(max = 15)
	private String phoneNumber;

	private boolean isActive;
	
	private String avatar;
	
	@Size(max = 20)
	private String gender;
	
	@JsonIgnore
	@Column(updatable = false)
	private String verifycationCode;
	
	@Column(updatable = false)
	private Date createdTime;
	
	@Fetch(FetchMode.JOIN)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_roles", 
				joinColumns = @JoinColumn(name= "user_id"), 
				inverseJoinColumns= @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
	public User() {}

	public User(String username, String email, String password) {
		this.userName = username;
		this.email = email;
		this.password = password;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return userName;
	}

	public void setUsername(String username) {
		this.userName = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Role> getRoles() {
		return roles;
	}

	public void setRoles(Set<Role> roles) {
		this.roles = roles;
	}	
	
	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getPhonenumber() {
		return phoneNumber;
	}

	public void setPhonenumber(String phonenumber) {
		this.phoneNumber = phonenumber;
	}

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public boolean isActive() {
		return isActive;
	}

	public void setActive(boolean isactive) {
		this.isActive = isactive;
	}

	public String getVerifycationCode() {
		return verifycationCode;
	}

	public void setVerifycationCode(String verifycationCode) {
		this.verifycationCode = verifycationCode;
	}
	
}
