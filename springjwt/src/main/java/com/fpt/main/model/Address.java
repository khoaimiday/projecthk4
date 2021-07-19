package com.fpt.main.model;

import java.util.Collection;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "address")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
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

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) 
	@EqualsAndHashCode.Exclude 
	@ToString.Exclude
	@JoinTable(name = "address_user",
			   joinColumns = @JoinColumn(name = "address_id"), 
			   inverseJoinColumns = @JoinColumn(name = "user_id"))
	private Collection<User> users;

	@ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY) // Quan hệ n-n với đối tượng ở dưới (Person) (1 địa điểm có nhiều người ở)																	
	@EqualsAndHashCode.Exclude //==>							   không sử dụng trường này trong equals và hashcode
	@ToString.Exclude //==>										   Không sử dụng trong toString()
	@JoinTable(name = "address_restaurant", //==>				   Tạo ra một join Table tên là "address_person"
			joinColumns = @JoinColumn(name = "address_id"), // ==> Trong đó, khóa ngoại chính là address_id trỏ tới class hiện tại(Address)
			inverseJoinColumns = @JoinColumn(name = "restaurant_id")) // Khóa ngoại thứ 2 trỏ tới thuộc tính ở dưới(Person)																		
	private Collection<Restaurant> restaurants;
}
