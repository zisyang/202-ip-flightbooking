package test;

import model.Booking;

public class ValidateCardHandler implements ValidateHandler {

    private ValidateHandler successor = null;

    @Override
    public int validateRequest(Object request) {
        String card = ((Booking) request).getPaymentCardNumber();
        if (card.length() > 19 || card.length() < 13) {
            return 5;
        }
        if (checkVisa(card)) {
            return 0;
        }
        if (checkMaster(card)) {
            return 0;
        }
        if (checkDiscover(card)) {
            return 0;
        }
        if (checkAmex(card)) {
            return 0;
        }

        if (successor != null) {
            successor.validateRequest(request);
        }

        return 5;
    }

    @Override
    public void setSucessor(ValidateHandler next) {
        this.successor = next;
    }

    // Visa card: has length either 13 or 16. It begins with a 4
    public boolean checkVisa(String card) {
        if (card.length() != 13 && card.length() != 16) {
            return false;
        }
        return card.startsWith("4");
    }

    // Mastercard: has length 16. Begins with 5 and the 2nd digit begins from 1 to 5
    // inclusive
    public boolean checkMaster(String card) {
        if (card.length() != 16) {
            return false;
        }
        if (!card.startsWith("5")) {
            return false;
        }
        char secDigit = card.charAt(1);
        if (secDigit >= '1' && secDigit <= '5') {
            return true;
        }
        return false;
    }

    // Discover: length 16, and the first 4 digits begins from 6011
    public boolean checkDiscover(String card) {
        if (card.length() != 16) {
            return false;
        }
        return card.startsWith("6011");
    }

    // Amex: has length 15 and starts with 3. 2nd digit must be 4 or 7
    public boolean checkAmex(String card) {
        if (card.length() != 15) {
            return false;
        }
        if (!card.startsWith("3")) {
            return false;
        }
        char secDigit = card.charAt(1);
        if (secDigit == '4' || secDigit == '7') {
            return true;
        }
        return false;
    }

}
