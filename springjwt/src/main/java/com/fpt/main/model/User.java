package com.fpt.main.model;

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
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "username"),
				@UniqueConstraint(columnNames = "email")
		})
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode(callSuper = true)
@Builder
public class User extends BaseEntity{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(columnDefinition = "nvarchar")
	private String userName;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 120)
	@JsonIgnore
	private String password;
	
	@ManyToOne
	@JoinColumn(name="address_id", nullable=true)
	private Address address;
	
	@Size(max = 15)
	@Column(name = "phone_number")
	private String phoneNumber;

	@Column(name = "is_active", columnDefinition = "Bit(1) default false")
	private boolean isActive;
	
	@Column(name = "avatar")
	private String avatar;
	
	@Size(max = 20)
	@Column(name = "gender")
	private String gender;
	
	@JsonIgnore
	@Column(name = "verifycation_code", updatable = false)
	private String verifycationCode;
	
	@JsonIgnore
	@Column(name = "reset_password_token")
	private String resetPasswordToken;
	

	@Fetch(FetchMode.JOIN)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_roles", 
				joinColumns = @JoinColumn(name= "user_id"), 
				inverseJoinColumns= @JoinColumn(name="role_id"))
	@Builder.Default
	private Set<Role> roles = new HashSet<>();
	
	@Transient
	public String getAvatarImagePath() {
		if (avatar == null || id == null) return null;
		return "/avatar/" + id + "/" + avatar;
	}
	
	//Constructor customized
	public User(String userName, String email, String password) {
		this.userName = userName;
		this.email = email;
		this.password = password;
	}

}
