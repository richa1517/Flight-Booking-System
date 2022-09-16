package com.capg.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IBookingDAO;
import com.capg.entities.*;
import com.capg.exceptions.BookingAlreadyExistsException;
import com.capg.exceptions.BookingNotFoundException;
import com.capg.exceptions.FlightNotFoundException;
import com.capg.exceptions.UserNotFoundException;



@Service
public class BookingServiceImpl implements IBookingService{
	
	@Autowired
	private IBookingDAO bookingdao;

	@Override
	public List<Booking> getBooking() {
		
		return bookingdao.findAll();
	}

	@Override
	public Booking addBooking(Booking booking) {
		if(bookingdao.existsById(booking.getBookingId())) {
			throw new BookingAlreadyExistsException();
		}
		bookingdao.save(booking);
		return booking;
	}

	@Override
	public Booking updateBooking(Booking booking) {
		if(bookingdao.findById(booking.getBookingId()).isEmpty()) {
			throw new BookingNotFoundException();
		}
		bookingdao.save(booking);
		return booking;
	}

	@Override
	public Booking getBookingById(int bookingId){
		if(bookingdao.findById(bookingId).isEmpty()) {
			throw new BookingNotFoundException();
		}
		return bookingdao.findById(bookingId).get();
	}

	@Override
	public void deleteBooking(int bookingId) {
		if(bookingdao.findById(bookingId).isEmpty()) {
			throw new BookingNotFoundException();
		}
		Booking b = bookingdao.findById(bookingId).get();
		bookingdao.delete(b);
	}

	@Override
	public List<Booking> getBookingsByFlightId(int flightId) {
		List<Booking> bookings = new ArrayList<>();
		for(Booking b : bookingdao.findAll())
		{
			if(b.getFlightId()==flightId)
			{	
				bookings.add(b);
			}
		}
		if(bookings.isEmpty()) throw new FlightNotFoundException();
		return bookings;
		
	}

	@Override
	public List<Booking> getBookingsByUserId(int userId) {
		List<Booking> bookings = new ArrayList<>();
		for(Booking b : bookingdao.findAll())
		{
			if(b.getUserId()==userId)
			{	
				bookings.add(b);
			}
		}
		if(bookings.isEmpty()) throw new UserNotFoundException();
		return bookings;
	}

}
