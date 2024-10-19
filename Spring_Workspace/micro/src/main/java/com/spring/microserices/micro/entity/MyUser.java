package com.spring.microserices.micro.entity;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "MYUSER")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class MyUser {

	@Id
	@Column(name = "ID")
	protected String id;
	@Column(name = "NAME", length = 20)
	protected String name;
	@Column(name = "ADDRESS", length = 30)
	protected String address;
	@Column(name = "COMPANY", length = 40)
	protected String company;
	
	@Transient
	public List<HotelRating> rating = new ArrayList<>();
	
}
