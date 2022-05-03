package model;

public class Booked {
    private String BookingName;
    private String FlightNumber;
    private String Category;
    private int numberOfSeatsBooked;
    private double totalPrice;

    public Booked(String BookingName, String FlightNumber, String Category, int numberOfSeatsBooked,
            double totalPrice) {
        this.BookingName = BookingName;
        this.FlightNumber = FlightNumber;
        this.Category = Category;
        this.numberOfSeatsBooked = numberOfSeatsBooked;
        this.totalPrice = totalPrice;
    }

    public String headerString() {
        return "Booking Name" + "," +
                "flight number" + "," +
                "Category" + "," +
                "number of seats booked" + "," +
                "total price" + "";
    }

    @Override
    public String toString() {
        return "" +
                BookingName + "," +
                FlightNumber + "," +
                Category + "," +
                numberOfSeatsBooked + "," +
                totalPrice + "" +
                "";
    }

}
