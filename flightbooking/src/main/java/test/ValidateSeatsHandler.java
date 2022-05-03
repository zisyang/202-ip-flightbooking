package test;

import model.Booking;

public class ValidateSeatsHandler implements ValidateHandler {

    private ValidateHandler successor = null;

    @Override
    public int validateRequest(Object request) {
        Booking b = (Booking) request;
        String keyRequest = DataSet.createKeyString(b.getFlightNumber(), b.getSeatCategory());
        int seatRequest = b.getNumberOfSeats();

        DataSet ds = DataSet.getInstance();

        if (ds.getFlightsMap().containsKey(keyRequest)) {

            if (ds.getFlightsMap().get(keyRequest).getAvailableSeats() < seatRequest) {
                return 4;
            }

            // DO SOMTHING for Seats, then

            if (successor != null) {
                return successor.validateRequest(request);
            }

            return 0;
        }

        return 0;
    }

    @Override
    public void setSucessor(ValidateHandler next) {
        this.successor = next;
    }

}
