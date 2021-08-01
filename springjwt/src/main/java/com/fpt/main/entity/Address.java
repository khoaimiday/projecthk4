package com.fpt.main.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="address")
@Getter
@Setter
public class Address extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
	private Long id;

	@Column(name = "type")
	private String type;
	
	@Column(name = "note")
	private String note;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "cities")
	private String cities;
	
	@Column(name = "district")
	private String district;
	
	@Column(name = "ward")
	private String ward;
	
	@Column(name = "street")
	private String street;
	
	@Column(name = "lane")
	private String lane;

	@ManyToOne
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToOne
    @PrimaryKeyJoinColumn
	private Restaurant restaurant;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private Order order;
	
}





