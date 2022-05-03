package test;

public interface ValidateHandler {

    public int validateRequest(Object request);

    public void setSucessor(ValidateHandler next);

}
