package com.fpt.main.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users",
		uniqueConstraints = {
				@UniqueConstraint(columnNames = "user_name"),
				@UniqueConstraint(columnNames = "email")
		})
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;
	
	@NotBlank
	@Size(max = 20)
	@Column(name = "user_name")
	private String userName;
	
	@NotBlank
	@Size(max = 50)
	@Email
	private String email;
	
	@NotBlank
	@Size(max = 120)
	@JsonIgnore
	private String password;
	
	@Column(name = "full_name")
	@Size(max = 100)
	private String fullName; 

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
	
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private Set<Order> orders = new HashSet<>();
		
//	@OneToMany(mappedBy = "user", cascade = CascadeType.ALL)
//	private Set<Address> addressList = new HashSet<>();
	
	@Fetch(FetchMode.JOIN)
	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable( name = "user_roles", 
				joinColumns = @JoinColumn(name= "user_id"), 
				inverseJoinColumns= @JoinColumn(name="role_id"))
	private Set<Role> roles = new HashSet<>();
	
//	public void addOrder(Order item) {
//		if (item != null) {
//			if (orders == null) {
//				orders = new HashSet<>();
//			}
//		}
//		orders.add(item);
//		item.setUser(this);
//	}
	
//	public void addAddress(Address item) {
//		if (item != null) {
//			if (addressList == null) {
//				addressList = new HashSet<>();
//			}
//		}
//		addressList.add(item);
//		item.setUser(this);
//	}
	
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
