package model;

public enum Reason {
    SUCCESSFUL(0, "successful"),
    FLIGHTNUMBER(1, "invalid flight number"),
    CATEGORY(2, "invalid category"),
    FLIGHTCATEGORY(3, "invalid flight number & category combination"),
    SEATS(4, "not enough seats to book"),
    CARD(5, "invalid card number");

    private final int code;
    private final String description;

    private Reason(int code, String description) {
        this.code = code;
        this.description = description;
    }

    public int getCode() {
        return code;
    }

    public static String getDescriptionFromCode(int code) {
        for (Reason r : Reason.values()) {
            if (r.getCode() == code) {
                return r.description;
            }
        }
        return null;
    }

    @Override
    public String toString() {
        return code + ": " + description;
    }
}
