package com.capg;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.capg.dao.IBookingDAO;
import com.capg.dao.IFlightDAO;
import com.capg.dao.IPassengerDAO;
import com.capg.dao.IUserDao;
import com.capg.entities.Booking;
import com.capg.entities.Flight;
import com.capg.entities.Passenger;
import com.capg.entities.User;

@SpringBootTest
class PassengerTest {
	@Autowired
	IBookingDAO bookingDao;
	
	@Autowired
	IUserDao userDao;
	
	@Autowired
	IFlightDAO flightDao;
	
	@Autowired
	IPassengerDAO passengerDao;
	
	@Test
	void testInjection() {
		assertThat(passengerDao).isNotNull();
	}
	
	@Test
	void testAddPassenger() {
		User u=new User(111, "personA", "lastA", "A@gmail.com", "##44", "9156666666");
		userDao.save(u);
		Flight f=new Flight(222, "Bengaluru", "Goa", "05:00", "8:00", "01-02-22", 1550, 90);
		flightDao.save(f);
		Booking b=new Booking(333, 111,222,"10-01-2022",6000.5, 3);
		bookingDao.save(b);
		Passenger p=new Passenger(444,333,"Rachanaa", "Raghuthama",22,"F","123gh45678",25);
		passengerDao.save(p);
		b.setFlight(f);
		b.setUser(u);
		p.setBooking(b);
		
		Passenger pass=passengerDao.findById(444).get();
		assertEquals(pass.getPassengerId(),p.getPassengerId());
		assertEquals(pass.getFirstName(),p.getFirstName());
		assertEquals(pass.getLastName(),p.getLastName());
		assertEquals(pass.getAge(),p.getAge());
		assertEquals(pass.getGender(),p.getGender());
		assertEquals(pass.getPassportNumber(),p.getPassportNumber());
		assertEquals(pass.getSeatNumber(),p.getSeatNumber());
		assertEquals(pass.getBooking().toString(),b.toString());
		
		
	}
}
