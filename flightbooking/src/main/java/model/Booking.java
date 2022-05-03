package model;

public class Booking {
    private String BookingName;
    private String flightNumber;
    private String seatCategory;
    private int numberOfSeats;
    private String paymentCardNumber;

    public Booking(String bookingName, String flightNumber, String seatCategory, int numberOfSeats,
            String paymentCardNumber) {
        this.BookingName = bookingName;
        this.flightNumber = flightNumber;
        this.seatCategory = seatCategory;
        this.numberOfSeats = numberOfSeats;
        this.paymentCardNumber = paymentCardNumber;
    }

    public String getBookingName() {
        return this.BookingName;
    }

    public void setBookingName(String BookingName) {
        this.BookingName = BookingName;
    }

    public String getFlightNumber() {
        return this.flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getSeatCategory() {
        return this.seatCategory;
    }

    public void setSeatCategory(String seatCategory) {
        this.seatCategory = seatCategory;
    }

    public int getNumberOfSeats() {
        return this.numberOfSeats;
    }

    public void setNumberOfSeats(int numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getPaymentCardNumber() {
        return this.paymentCardNumber;
    }

    public void setPaymentCardNumber(String paymentCardNumber) {
        this.paymentCardNumber = paymentCardNumber;
    }

    @Override
    public String toString() {
        return "{" +
                " 'BookingName':'" + getBookingName() + "'," +
                " 'flightNumber':'" + getFlightNumber() + "'," +
                " 'seatCategory':'" + getSeatCategory() + "'," +
                " 'numberOfSeats':'" + getNumberOfSeats() + "'," +
                " 'paymentCardNumber':'" + getPaymentCardNumber() + "'" +
                "}";
    }

}
