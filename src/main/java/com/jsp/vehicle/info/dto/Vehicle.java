package com.jsp.vehicle.info.dto;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)

	private int id;
	private String brand;
	private String name;

	@OneToOne(mappedBy = "vehicle")
	private Chasis chasis;

	@OneToOne(mappedBy = "vehicle")
	private EngineNumber engineNumber;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Chasis getChasisDemo() {
		return chasis;
	}

	public void setChasisDemo(Chasis chasis) {
		this.chasis = chasis;
	}

	public EngineNumber getEngineNumber() {
		return engineNumber;
	}

	public Chasis getChasis() {
		return chasis;
	}

	public void setChasis(Chasis chasis) {
		this.chasis = chasis;
	}

	public void setEngineNumber(EngineNumber engineNumber) {
		this.engineNumber = engineNumber;
	}

}
