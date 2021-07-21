package com.fpt.main.entity;

import java.math.BigDecimal;
import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "offers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Offer extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "code")
	private String code;
	
	@Column(name = "actived_date")
	private LocalDateTime activedDate;
	
	@Column(name = "expired_date")
	private LocalDateTime expiredDate;
	
	@Column(name = "discount_percent")
	private int discount;
	
	@Column(name = "price_promo")
	private BigDecimal pricePromo;
	
	@Column(name = "img_url")
	private String imageURL;
	
	@ManyToOne
	@JoinColumn(name = "restaurant_id", nullable = true)
	@JsonIgnore
	private Restaurant restaurant;
	
	@ManyToOne
	@JoinColumn(name = "dishes_id", nullable = true)
	@JsonIgnore
	private Dishes dishes;
	
}
