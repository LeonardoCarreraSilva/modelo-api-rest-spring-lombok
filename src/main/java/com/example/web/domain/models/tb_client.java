package com.example.web.domain.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@Table(name = "tb_client")
public class tb_client implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "name")
	private String name;
	@Column(name = "ssh")
	private String ssh;
	@Column(name = "email")
	private String email;
	@Column(name = "phone")
	private String phone;
	@Column(name = "celphone")
	private String celphone;
	@Column(name = "zipcode")
	private String zipcode;
	@Column(name = "address")
	private String address;
	@Column(name = "number")
	private int number;
	@Column(name = "complement")
	private String complement;
	@Column(name = "neighborhood")
	private String neighborhood;
	@Column(name = "city")
	private String city;
	@Column(name = "state")
	private String state;
	
	public tb_client(String name, String ssh, String email, String phone, String celphone, String zipcode,
					 String address, int number, String complement, String neighborhood, String city, String state) {
		this.name = name;
		this.ssh = ssh;
		this.email = email;
		this.phone = phone;
		this.zipcode = zipcode;
		this.address = address;
		this.number = number;
		this.complement = complement;
		this.neighborhood = neighborhood;
		this.city = city;
		this.state = state;
	}
}
