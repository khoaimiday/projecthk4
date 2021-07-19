package com.fpt.main.model;

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

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "dishes")
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class Dishes extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String fullName;
	
	private String unit;
	
	private int quantity;
	
	private String note;
	
	private BigDecimal price;
	
	@Column(name = "count_like")
	private int like;
	
	@Column(name = "delivered")
	private int delivered;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "restaurant_id", nullable = true)
	private Restaurant restaurant;
	
	@Column(name = "img_url")
	private String imageURL;
	
	@Column(name = "is_active", columnDefinition = "Bit(1) default true")
	private boolean isActive;

	@OneToMany(mappedBy = "dishes")
	private Collection<Offer> offer;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "dish_category_id", nullable = true)
	private DishCategories dishCategory;
}
