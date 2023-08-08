package com.simplilearn.dao;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.query.Query;

import com.simplilearn.persistant.Airline;
import com.simplilearn.persistant.FlightClass;
import com.simplilearn.persistant.Itinerary;
import com.simplilearn.persistant.Route;

public class AirlinesDao {

	public static void main(String[] args) {
	
		
		DatabaseMappingHelper mappingHelper = new DatabaseMappingHelper();
		Session session = mappingHelper.getDBCurrentSession();
		
		Transaction t = session.beginTransaction();
		
		List<FlightClass> flightClasses = new ArrayList<FlightClass>();
		List<Itinerary> itineraries = new ArrayList<Itinerary>();
		List<Route> routes = new ArrayList<Route>();

        Query query = session.getNamedQuery("findAirlinebyName");    
        query.setParameter("name","Air India Express");   
                
        List<Airline> airlines=query.getResultList();   
        Airline airline = null;
        
        if (airlines.isEmpty()) {
			airline = new Airline("Air India Express", "Economical Flight");
		}
        else {
            Iterator<Airline> itr = airlines.iterator();    
            while(itr.hasNext()){    
            	System.out.println("Airline from DB ==" +itr.next());    

            	airline=itr.next();    
            	System.out.println("Airline from DB ==" +airline);    
            }    
        	
		}
       
//		
//		airline = new 
//		
//		FlightClass flightcalssClass = new FlightClass("Economy");
//		flightClasses.add(flightcalssClass);
//		
//		Itinerary itineryItinerary = new Itinerary("10:00 am", "14:00 am");
//		mappingHelper.createItinerary(itineryItinerary, flightClasses);
//		
//		itineraries.add(itineryItinerary);
//		
//		Route route = new Route("Dubai", "Kannur");
//		mappingHelper.createItinerary(itineryItinerary, flightClasses);
		
        session.save(airline);
        t.commit();
        session.close();

		
	}
	
	
	
	
}
