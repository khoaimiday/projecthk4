package com.fpt.main.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "order_details")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class OrderDetails extends BaseEntity{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "description")
	private String description;
	
	@Column(name = "unit_name")
	private String unitName;
	
	@Column(name = "original_price")
	private BigDecimal originalPrice;
	
	@Column(name = "selling_price")
	private BigDecimal sellingPrice;
	
	@Column(name = "amount")
	private int amount;
	
	@OneToOne
	@JoinColumn(name = "order_id", nullable = false)
	private Order order;
	
	@OneToOne
	@JoinColumn(name = "dishes_id", nullable = false)
	private Dishes dishes;
	
}
