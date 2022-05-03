package test;

import java.util.LinkedList;

import model.Booking;

public class QueryBookingResultsIterator implements QueryResultsIterator {

    private LinkedList<Booking> results;
    private int cursor;
    private int max;

    public QueryBookingResultsIterator(LinkedList<Booking> list) {
        results = list;
        cursor = 0;
        max = list.size();
    }

    @Override
    public Booking first() {
        return results.getFirst();
    }

    @Override
    public Booking next() {
        cursor++;
        if (isDone()) {
            return null;
        }
        return results.get(cursor);
    }

    @Override
    public Booking currentItem() {
        return results.get(cursor);
    }

    @Override
    public boolean isDone() {
        return (cursor == max);
    }
}
