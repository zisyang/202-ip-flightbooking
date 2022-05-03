package test;

import java.util.LinkedList;

import model.Booking;

public class QueryBookingResults implements QueryResults {

    private LinkedList<Booking> list = new LinkedList<>();

    @Override
    public QueryResultsIterator createIterator() {
        return new QueryBookingResultsIterator(list);
    }

    @Override
    public void fetchData() {
        for (Booking e : DataSet.getInstance().getBookings()) {
            list.add(e);
        }
    }
}
