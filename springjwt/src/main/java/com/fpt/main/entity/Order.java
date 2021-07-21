package com.fpt.main.entity;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "orders")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
@Builder
public class Order extends BaseEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "total_price")
	private BigDecimal totalPrice;
	
	@Column(name = "amount")
	private int amount; 
	
	@Column(name = "status", columnDefinition = "Bit(1) default false")
	private boolean status;
	
	@Column(name = "deliver_phone")
	private String deliverPhone;
	
	@Column(name = "deliver_address")
	private String deliverAddress;
	
	@Column(name = "deliver_time")
	private String deliverTime;
	
	@Column(name = "deliver_note")
	private String deliverNote;
	
	@Column(name = "offer_code")
	private String offerCode;
	
	@OneToOne
	@JoinColumn(name = "restaurant_id")
	private Restaurant restaurant; 
	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private User users;
	
}
