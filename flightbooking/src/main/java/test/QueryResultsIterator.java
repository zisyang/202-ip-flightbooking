package test;

public interface QueryResultsIterator {

    public Object first();

    public Object next();

    public Object currentItem();

    public boolean isDone();

}
