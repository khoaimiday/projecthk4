package com.fpt.main.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
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

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "restaurants")
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
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private Set<Dishes> dishesList = new HashSet<>();
	
	@OneToMany(cascade = CascadeType.ALL, mappedBy = "restaurant")
	private Set<Offer> offerList = new HashSet<Offer>();
	
	@OneToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;
	
	public void addDishes(Dishes item) {		
		if (item != null) {
			if (dishesList == null) {
				dishesList = new HashSet();
			}
		}		
		dishesList.add(item);
		item.setRestaurant(this);
	}
	
	public void addOffer(Offer item) {
		if (item !=null) {
			offerList = new HashSet<Offer>();
		}		
		offerList.add(item);
		item.setRestaurant(this);
	}
	
}
