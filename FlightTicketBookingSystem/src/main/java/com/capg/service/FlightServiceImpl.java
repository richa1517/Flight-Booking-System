package com.capg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capg.dao.IFlightDAO;
import com.capg.entities.Flight;
import com.capg.exceptions.FlightAlreadyExistsException;
import com.capg.exceptions.FlightNotFoundException;

@Service
public class FlightServiceImpl implements IFlightService {

	@Autowired
	IFlightDAO flightDao;
	
	@Override
	public List<Flight> getFlightDetails() {
		return flightDao.findAll();
	}

	@Override
	public Flight getFlightDetailsById(int flightId) {
		if(flightDao.findById(flightId).isEmpty()) {
			throw new FlightNotFoundException();
		}
		return flightDao.findById(flightId).get();
	}

	@Override
	public Flight addFlight(Flight flight) {
		if(flightDao.existsById(flight.getFlightId())) {
			throw new FlightAlreadyExistsException();
		}
		flightDao.save(flight);
		return flight;
	}

	@Override
	public Flight updateFlight(Flight flight) {
		if(flightDao.findById(flight.getFlightId()).isEmpty()) {
			throw new FlightNotFoundException();
		}
		flightDao.save(flight);
		return flight;
	}

	@Override
	public void deleteFlight(int flightId) {
		if(flightDao.findById(flightId).isEmpty()) {
			throw new FlightNotFoundException();
		}
		Flight f = flightDao.findById(flightId).get();
		flightDao.delete(f);
		
	}
	
}
