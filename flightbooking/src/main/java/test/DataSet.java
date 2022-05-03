package test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;

import model.Booked;
import model.Booking;
import model.Category;
import model.Flight;

public class DataSet {

    private static DataSet datasetInstance;

    private HashMap<String, Flight> flightsMap = new HashMap<>();

    private HashSet<Booked> bookedSet = new HashSet<>();

    private LinkedList<Booking> bookingsList = new LinkedList<>();

    private ArrayList<String> invalids = new ArrayList<>();

    private DataSet() {
    }

    public static DataSet getInstance() {
        if (datasetInstance == null) {
            System.out.println("Create new DataSet Instance");
            datasetInstance = new DataSet();
        }
        return datasetInstance;
    }

    public static String createKeyString(String flightNumber, String category) {
        // Premium Economy -> PremiumEconomy
        return String.format("%s_%s", flightNumber, Category.getNameFromText(category));
    }

    public HashMap<String, Flight> getFlightsMap() {
        return this.flightsMap;
    }

    public void printFlights() {
        for (Flight f : this.flightsMap.values()) {
            System.out.println(f);
        }
    }

    public HashSet<Booked> getBookeds() {
        return this.bookedSet;
    }

    public LinkedList<Booking> getBookings() {
        return this.bookingsList;
    }

    public ArrayList<String> getInvalids() {
        return this.invalids;
    }

    public static Booked processBooking(Booking booking, boolean validated) {
        if (!validated) {
            return null;
        }
        String BookingName = booking.getBookingName();
        String FlightNumber = booking.getFlightNumber();
        String Category = booking.getSeatCategory();
        int numberOfSeatsBooked = booking.getNumberOfSeats();
        double totalPrice = 0.0;

        Flight flight = getInstance().getFlightsMap().get(createKeyString(FlightNumber, Category));

        totalPrice = flight.getPrice() * numberOfSeatsBooked;

        flight.setAvailableSeats(flight.getAvailableSeats() - numberOfSeatsBooked);

        Booked booked = new Booked(BookingName, FlightNumber, Category, numberOfSeatsBooked, totalPrice);

        getInstance().getBookeds().add(booked);

        return booked;
    }

}
