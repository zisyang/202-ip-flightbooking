package model;

public class Flight {
    private String Category;
    private String FlightNumber;
    private int AvailableSeats;
    private double Price;
    private String Arrival;
    private String Departure;

    public Flight() {
    }

    public Flight(String category, String flightNumber, int availableSeats, double price, String arrival,
            String departure) {
        this.Category = category;
        this.FlightNumber = flightNumber;
        this.AvailableSeats = availableSeats;
        this.Price = price;
        this.Arrival = arrival;
        this.Departure = departure;
    }

    public String getCategory() {
        return this.Category;
    }

    public void setCategory(String c) {
        this.Category = c;
    }

    public String getFlightNumber() {
        return this.FlightNumber;
    }

    public void setFlightNumber(String n) {
        this.FlightNumber = n;
    }

    public int getAvailableSeats() {
        return this.AvailableSeats;
    }

    public void setAvailableSeats(int s) {
        this.AvailableSeats = s;
    }

    public double getPrice() {
        return this.Price;
    }

    public void setPrice(double p) {
        this.Price = p;
    }

    public String getArrival() {
        return this.Arrival;
    }

    public void setArrival(String a) {
        this.Arrival = a;
    }

    public String getDeparture() {
        return this.Departure;
    }

    public void setDeparture(String d) {
        this.Departure = d;
    }

    @Override
    public String toString() {
        return "{" +
                " 'Category':'" + getCategory() + "'," +
                " 'FlightNumber':'" + getFlightNumber() + "'," +
                " 'AvailableSeats':'" + getAvailableSeats() + "'," +
                " 'Price':'" + getPrice() + "'," +
                " 'Arrival':'" + getArrival() + "'," +
                " 'Departure':'" + getDeparture() + "'" +
                "}";
    }

}