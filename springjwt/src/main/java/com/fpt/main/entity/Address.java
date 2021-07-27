package com.fpt.main.entity;

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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Address extends BaseEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
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
	@JoinColumn(name = "user_id", nullable = true)
	private User users;

//	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Quan hệ n-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)																	
//	@EqualsAndHashCode.Exclude //==>							   không sử dụng trường này trong equals và hashcode
//	@ToString.Exclude //==>										   Không sử dụng trong toString()
//	@JsonIgnore
//	@JoinTable(name = "address_restaurant", //==>				   Tạo ra một join Table tên là "address_person"
//			joinColumns = @JoinColumn(name = "address_id"), // ==> Trong đó, khóa ngoại chính là address_id trỏ tới class hiện tại(Address)
//			inverseJoinColumns = @JoinColumn(name = "restaurant_id")) // Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới(Person)																		
//	private Collection<Restaurant> restaurants;
	
	@OneToOne
	@JoinColumn(name = "restaurant_id",  nullable = true)
	private Restaurant restaurants;
	
}





