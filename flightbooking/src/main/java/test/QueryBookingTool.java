package test;

import java.util.logging.Logger;

import model.Booked;
import model.Booking;
import model.Reason;

public class QueryBookingTool {

    public QueryResults executeQuery() {
        QueryResults resultSet = new QueryBookingResults();
        resultSet.fetchData();
        return resultSet;
    }

    public void run() {
        Logger logger = Logger.getAnonymousLogger();
        
        QueryResultsIterator iter = executeQuery().createIterator();
        
        while (!iter.isDone()) {

            Booking requestBooking = (Booking) iter.currentItem();

            ValidateHandler vf = new ValidateFlightHandler();
            ValidateHandler vs = new ValidateSeatsHandler();
            ValidateHandler vc = new ValidateCardHandler();

            vf.setSucessor(vs);
            vs.setSucessor(vc);

            int result = vf.validateRequest(requestBooking);
            String output_txt = "";
            if (result > 0) {
                output_txt = String.format("Please enter correct booking details for %s: %s",
                        requestBooking.getBookingName(), Reason.getDescriptionFromCode(result));
                DataSet.getInstance().getInvalids().add(output_txt);
                logger.info(output_txt);
            } else {

                Booked booked = DataSet.processBooking(requestBooking, true);

                output_txt = String.format("Booking {%s} : %s", booked, Reason.getDescriptionFromCode(result));
                logger.warning(output_txt);
            }

            iter.next();
        }
    }
}
