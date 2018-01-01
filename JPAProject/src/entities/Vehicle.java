package entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicle {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	private String make;
	
	private String model;
	
	private int year;
	
	@Column(name="current_miles")
	private int currentMiles;
	
	@Column(name="miles_due")
	private int milesDue;

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public int getCurrentMiles() {
		return currentMiles;
	}

	public void setCurrentMiles(int currentMiles) {
		this.currentMiles = currentMiles;
	}

	public int getMilesDue() {
		return milesDue;
	}

	public void setMilesDue(int milesDue) {
		this.milesDue = milesDue;
	}

	public int getId() {
		return id;
	}

	@Override
	public String toString() {
		return "Vehicle [id=" + id + ", make=" + make + ", model=" + model + ", year=" + year + ", currentMiles="
				+ currentMiles + ", milesDue=" + milesDue + "]";
	}

	
}
