package com.spring.datajpa.model;
import javax.persistence.*;

import org.hibernate.validator.constraints.Length;

@Entity
@Table(name = "contacts")
public class Contact {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;

	@Column(name = "surname")
	private String surname;

	@Column(name = "name")
	private String name;

	@Column(name = "phone_number")
	@Length(max = 10)
	private String phone_number;

	@Column(name = "address")
	private String address;
	
	@Column(name = "geo_data")
	private String geo_data;
	
	@Column(name = "other_info")
	private String other_info;
	
	public Contact() {}
	
	public Contact(String surname, String name,String phone_number, String address, String geo_data, String other_info) {
		this.surname = surname;
		this.name = name;
		this.phone_number = phone_number;
		this.address = address;
		this.geo_data = geo_data;
		this.other_info = other_info;
	}
	
	public String getGeo_data() {
		return geo_data;
	}

	public void setGeo_data(String geo_data) {
		this.geo_data = geo_data;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone_number() {
		return phone_number;
	}

	public void setPhone_number(String phone_number) {
		this.phone_number = phone_number;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getOther_info() {
		return other_info;
	}

	public void setOther_info(String other_info) {
		this.other_info = other_info;
	}

	public long getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Contact [id=" + id + ", surname=" + surname + ", name=" + name + ", phone number=" + phone_number + "]";
	}
}


