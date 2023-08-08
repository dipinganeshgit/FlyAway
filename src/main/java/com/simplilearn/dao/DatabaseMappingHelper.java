package com.simplilearn.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import com.simplilearn.persistant.Airline;
import com.simplilearn.persistant.FlightClass;
import com.simplilearn.persistant.Itinerary;
import com.simplilearn.persistant.Route;

public class DatabaseMappingHelper {

	
	public Session getDBCurrentSession() {
		// TODO Auto-generated method stub
		StandardServiceRegistry ssr = new StandardServiceRegistryBuilder().configure("hibernate.cfg.xml").build();

		Metadata meta = new MetadataSources(ssr).getMetadataBuilder().build();

		SessionFactory sf = meta.getSessionFactoryBuilder().build();

		Session session = sf.openSession();
		
		return session;
	}
	
	public Airline getAirlineForId(int id, String name)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        Airline airline = session.get(Airline.class, id);
        session.getTransaction().commit();

        return airline;
	}
	
	public Itinerary getItineraryForId(int id, Route route)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        Itinerary itinerary = session.get(Itinerary.class, id);
        session.getTransaction().commit();

        return itinerary;
	}
	
	public Route getRouteForId(int id, Airline airline)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        Route route = session.get(Route.class, id);
        session.getTransaction().commit();

        return route;
	}
	
	
	public FlightClass getFlightClassForId(int id)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        FlightClass flightClass = session.get(FlightClass.class, id);
        session.getTransaction().commit();

        return flightClass;
	}
	
	void createAirline(Airline airline, List<Route> routes)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        airline.setRoutes(routes);
        session.persist(airline);
        session.getTransaction().commit();
        session.close();
	}
	
	void createRoute(Route route, List<Itinerary> itineraries)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        route.setItineraries(itineraries);
        session.persist(route);
        session.getTransaction().commit();
        session.close();
	}
	
	void createItinerary(Itinerary itinerary, List<FlightClass> flightClasses)
	{
		Session session =
                getDBCurrentSession();
        session.beginTransaction();

        itinerary.setFlightClassess(flightClasses);
        session.persist(itinerary);
        session.getTransaction().commit();
        session.close();
	}
	
	
}
