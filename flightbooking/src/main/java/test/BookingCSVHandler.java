package test;

import java.util.LinkedList;
import java.util.zip.DataFormatException;

import model.Booking;

public class BookingCSVHandler {
    private DataSet dataset = DataSet.getInstance();
    private LinkedList<Booking> BookingList;
    private CSVHandler datafile;

    public BookingCSVHandler(String pathToFile) {
        this.BookingList = dataset.getBookings();
        this.datafile = new CSVHandler(pathToFile);
    }

    public LinkedList<Booking> getBookingList() {
        return this.BookingList;
    }

    public void createBookingList() throws Exception {
        datafile.Load(1);
        LinkedList<String> content = datafile.getContent();

        for (String row : content) {
            String[] col = row.split(",");
            if (col.length < 5) {
                String message = String.format("Insufficient data fields, please check line '%s' in file '%s'", row,
                        datafile.getFilePath());
                throw new DataFormatException(message);
            }
            String bookingName = col[0];
            String flightNumber = col[1];
            String seatCategory = col[2];
            int numberOfSeats = Integer.parseInt(col[3]);
            String paymentCardNumber = col[4];
            BookingList.add(new Booking(bookingName, flightNumber, seatCategory, numberOfSeats, paymentCardNumber));
        }
    }

}
