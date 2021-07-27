package com.fpt.main.entity;

import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Restaurant extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@NotBlank
	@Column(name = "full_name")
	private String fullName;
	
	@Column(name = "email")
	@Size(max = 50)
	@Email
	private String email;
	
	@Column(name = "rate", columnDefinition = "float default 0.0")
	private float rate;
	
	@Column(name = "phone_number")
	private String phoneNumber;
	
	@Column(name = "img_url")
	private String imageURL;
	
	@Column(name = "is_active", columnDefinition = "Bit(1) default true")
	private boolean isActive;
	
	@OneToMany(mappedBy = "restaurant", fetch = FetchType.LAZY)
	@JsonIgnore
	private List<Dishes> dishesList;
	
	@OneToMany(mappedBy = "restaurant")
	private Collection<Offer> offerList;
	
	@OneToOne
	@JoinColumn(name = "address_id",  nullable = true)
	private Address address;
	
}
