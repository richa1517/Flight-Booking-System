
package com.capg.entities;

import javax.persistence.Column;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name="passenger")
public class Passenger {
	
	private int passengerId;
	private Integer bookingId;
	private String firstName;
	private String lastName;
	private int age;
	private String gender;
	private String passportNumber;
	private int seatNumber;
	
	private Booking booking;
	
	public Passenger(int passengerId, Integer bookingId, String firstName, String lastName, int age, String gender,
			String passportNumber, int seatNumber) {
		super();
		this.passengerId = passengerId;
		this.bookingId = bookingId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.gender = gender;
		this.passportNumber = passportNumber;
		this.seatNumber = seatNumber;
	}
	public Passenger() {
		super();
	}
	
	@Column(name = "bookingid")
	public Integer getBookingId() {
		return bookingId;
	}
	public void setBookingId(Integer bookingId) {
		this.bookingId = bookingId;
	}
	
	@Id
	@Column(name="passengerid")
	public int getPassengerId() {
		return passengerId;
	}
	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}
	
	@Column(name="firstname")
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	@Column(name="lastname")
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	@Column(name="age")
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
	@Column(name="gender")
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	
	@Column(name="passport")
	public String getPassportNumber() {
		return passportNumber;
	}
	public void setPassportNumber(String passportNumber) {
		this.passportNumber = passportNumber;
	}
	
	@Column(name="seatnumber")
	public int getSeatNumber() {
		return seatNumber;
	}
	public void setSeatNumber(int seatNumber) {
		this.seatNumber = seatNumber;
	}
	
	@OneToOne
	@JoinColumn(name = "bookingid" , insertable = false, updatable = false)
	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}
	
	@Override
	public String toString() {
		return "Passenger [passengerId=" + passengerId + ", bookingId=" + bookingId + ", firstName=" + firstName
				+ ", lastName=" + lastName + ", age=" + age + ", gender=" + gender + ", passportNumber="
				+ passportNumber + ", seatNumber=" + seatNumber +",booking=" + booking +"]";
	}
	
	

}

