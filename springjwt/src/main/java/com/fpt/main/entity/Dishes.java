package com.fpt.main.entity;

import java.math.BigDecimal;
import java.util.Collection;
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
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "unit")
	private String unit;
	
	@Column(name = "quantity", columnDefinition = "int default 0")
	private int quantity;
	
	@Column(name = "rate", columnDefinition = "float default 0.0")
	private float rate;

	@Column(name = "price")
	private BigDecimal price;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = false)
	@JsonIgnore
	private Restaurant restaurant;
	
	@Column(name = "img_url")
	private String imageURL;
	
	@Column(name = "is_active", columnDefinition = "Bit(1) default true")
	private boolean isActive;

	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "dishes")
	private Set<Offer> offerList = new HashSet<>();
		
	@OneToMany(cascade = CascadeType.ALL ,mappedBy = "dishes")
	private Set<Rating> ratingList = new HashSet<Rating>();
	
	@ManyToOne
	@JoinColumn(name = "dish_category_id")
	private DishCategories dishCategory;

	public void addOffer(Offer item) {
		if (item != null) {
			if (offerList == null) {
				offerList = new HashSet<>();
			}
		}
		offerList.add(item);
		item.setDishes(this);
	}
	
	public void addRating(Rating item) {
		if (item != null) {
			if (ratingList == null) {
				ratingList = new HashSet<>();
			}
		}
		ratingList.add(item);
		item.setDishes(this);
	}
}
