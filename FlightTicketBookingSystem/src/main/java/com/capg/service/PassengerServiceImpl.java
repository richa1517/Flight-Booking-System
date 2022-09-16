package com.capg.service;

import java.util.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IPassengerDAO;
import com.capg.entities.Passenger;
import com.capg.exceptions.BookingNotFoundException;
import com.capg.exceptions.PassengerAlreadyExistsException;
import com.capg.exceptions.PassengerNotFoundException;

@Service
public class PassengerServiceImpl implements IPassengerService{

	
	@Autowired
	IPassengerDAO passengerDao;
	
	
	@Override
	public List<Passenger> getPassengers() {
		return passengerDao.findAll();
	}

	@Override
	public Passenger getPassengerById(int passengerId) {
		if(passengerDao.findById(passengerId).isEmpty()) {
			throw new PassengerNotFoundException();
		}
		return passengerDao.findById(passengerId).get();
	}

	@Override
	public Passenger addPassenger(Passenger passenger) {
		if(passengerDao.existsById(passenger.getPassengerId())) {
			throw new PassengerAlreadyExistsException();
		}
		passengerDao.save(passenger);
		return passenger;
	}

	@Override
	public Passenger updatePassenger(Passenger passenger) {
		passengerDao.save(passenger);
		return passenger;
	}

	@Override
	public void deletePassenger(int passengerId) {
		if(passengerDao.findById(passengerId).isEmpty()) {
			throw new PassengerNotFoundException();
		}
		Passenger p = passengerDao.findById(passengerId).get();
		passengerDao.delete(p);
		
	}

	@Override
	public List<Passenger> getPassengersByBookingId(int bookingId) {
		List<Passenger> passengers = new ArrayList<>();
		for(Passenger p : passengerDao.findAll())
		{
			if(p.getBookingId()==bookingId)
			{	
				passengers.add(p);
			}
		}
		if(passengers.isEmpty()) throw new BookingNotFoundException();
		return passengers;
	}

	
}
