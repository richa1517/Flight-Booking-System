package com.capg.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "booking")
public class Booking {
	
	private int bookingId;

	private int userId;
	private int flightId;
	
	private String bookingDate;
	
	private double totalCost;
	
	private int seatsBooked;
	
	private User user;
	
	private Flight flight;

	public Booking() {
		super();
	}
	
	public Booking(int bookingId, int userId, int flightId,String bookingDate, /*String travelDate, */double totalCost,
			int seatsBooked) {
		super();
		this.bookingId = bookingId;
		this.userId = userId;
		this.flightId = flightId;
		this.bookingDate = bookingDate;
		this.totalCost = totalCost;
		this.seatsBooked = seatsBooked;
	}

	
	@Id
	@Column(name="bookingid")
	public int getBookingId() {
		return bookingId;
	}

	public void setBookingId(int bookingId) {
		this.bookingId = bookingId;
	}

	@Column(name="bookingdate")
	public String getBookingDate() {
		return bookingDate;
	}

	public void setBookingDate(String bookingDate) {
		this.bookingDate = bookingDate;
	}

	@Column(name="totalcost")
	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	@Column(name="seatsbooked")
	public int getSeatsBooked() {
		return seatsBooked;
	}

	public void setSeatsBooked(int seatsBooked) {
		this.seatsBooked = seatsBooked;
	}
	

	@Column(name="userid")
	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	@Column(name="flightid")
	public int getFlightId() {
		return flightId;
	}

	public void setFlightId(int flightId) {
		this.flightId = flightId;
	}

	@OneToOne
	@JoinColumn(name = "userid", insertable = false, updatable = false)
	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
	@OneToOne
	@JoinColumn(name = "flightid", insertable = false, updatable = false)
	public Flight getFlight() {
		return flight;
	}

	public void setFlight(Flight flight) {
		this.flight = flight;
	}


	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", bookingDate=" + bookingDate +/* ", travelDate=" + travelDate 
				+ */", totalCost=" + totalCost + ", seatsBooked=" + seatsBooked + ", user=" + user + ", flight=" 
				+ flight + "]";
	};
}
