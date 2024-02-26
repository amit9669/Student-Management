package com.qsp.springbootstudentpractice.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	private String name;
	@Column(unique = true)
	private long phone;
	private String address;
	private int age;
	@Column(unique = true)
	private String email;
	private int securedmarks;
	private int totalmarks;
	private double percentage;
	private String grade;

}
