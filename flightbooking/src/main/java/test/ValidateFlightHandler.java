package test;

import model.Booking;
import model.Category;

public class ValidateFlightHandler implements ValidateHandler {

    private ValidateHandler successor = null;

    @Override
    public int validateRequest(Object request) {
        Booking b = (Booking) request;

        boolean foundFlightNumber = false;
        for (String s : DataSet.getInstance().getFlightsMap().keySet()) {
            if (s.contains(b.getFlightNumber())) {
                foundFlightNumber = true;
                break;
            }
        }
        if (!foundFlightNumber) {
            return 1;
        }

        if (Category.getNameFromText(b.getSeatCategory()).isEmpty()) {
            return 2;
        }

        String keyRequest = DataSet.createKeyString(b.getFlightNumber(), b.getSeatCategory());
        if (!DataSet.getInstance().getFlightsMap().containsKey(keyRequest)) {
            return 3;
        }

        if (successor != null) {
            return successor.validateRequest(request);
        }

        return 0;
    }

    @Override
    public void setSucessor(ValidateHandler next) {
        this.successor = next;
    }

}
