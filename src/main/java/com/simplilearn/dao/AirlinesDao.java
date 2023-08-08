package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.persistant.Airline;
import com.simplilearn.persistant.FlightClass;
import com.simplilearn.persistant.Itinerary;
import com.simplilearn.persistant.Route;

public class AirlinesDao {

	public static void main(String[] args) {
	
		
		DatabaseMappingHelper mappingHelper = new DatabaseMappingHelper();
		Session session = mappingHelper.getDBCurrentSession();
		
		Transaction t = session.beginTransaction();
		
		
		Airline airIndiaExpressAirline = new Airline();
		airIndiaExpressAirline.setName("Air India Express");
		airIndiaExpressAirline.setDescription("Economical Flights");
		
		List<Route> routes = new ArrayList<Route>();
		
//		Route route = new Route();
//		route.setSource("Dubai");
//		route.setDestination("Kannur");
//		
//		
//		List<Itinerary> itineraries = new ArrayList<Itinerary>();
//
//		Itinerary itinerary = new Itinerary();
//		itinerary.setArrivaltime("10:00 am");
//		itinerary.setDepartureTime("06:00 am");
//
//		
//		List<FlightClass> flightClasses = new ArrayList<FlightClass>();
//
//		FlightClass flightClass = new FlightClass();
//		flightClass.setClassName("Economy");
//		
//		flightClasses.add(flightClass);
//		
//		itinerary.setFlightClassess(flightClasses);
//		
//		itineraries.add(itinerary);
//		
//		route.setItineraries(itineraries);
//		
//		routes.add(route);
//		
		airIndiaExpressAirline.setRoutes(routes);
				
		session.persist(airIndiaExpressAirline);
		
		t.commit();
		System.out.println("Successfully saved...");

		sf.close();
		session.close();
		
		AirlinesDao dao = new AirlinesDao();
		
		Airline retrievedAirline = dao.getAirlineForId(1);
		
		System.out.println("The airline name is "+retrievedAirline.getName());

		
	}
	
	
	
	
}
