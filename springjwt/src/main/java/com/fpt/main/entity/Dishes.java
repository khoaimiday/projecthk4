package com.fpt.main.entity;

import java.math.BigDecimal;
import java.util.Collection;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants.Exclude;


@Entity
@Table(name = "dishes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Dishes extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "quantity", columnDefinition = "int default 0")
	private int quantity;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "rate", columnDefinition = "float default 0.0")
	private float rate;
	
	private BigDecimal price;
	
	@Column(name = "like_number")
	private int like;
	
	@Column(name = "delivered")
	private int delivered;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	@JsonIgnore
	private Restaurant restaurant;
	
	@Column(name = "img_url")
	private String imageURL;
	
	@Column(name = "is_active", columnDefinition = "Bit(1) default true")
	private boolean isActive;

	@OneToMany(mappedBy = "dishes")
	private Collection<Offer> offer;
		
	@OneToMany(mappedBy = "dishes")
	private Collection<Rating> rating;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dish_category_id", nullable = true)
	@JsonIgnore
	private DishCategories dishCategory;

}
