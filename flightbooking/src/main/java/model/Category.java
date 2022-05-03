package model;

public enum Category {
    Economy,
    PremiumEconomy,
    Business;

    public static String getNameFromText(String text) {
        String test = text.replaceAll(" ", "");
        for (Category c : Category.values()) {
            if (test.equalsIgnoreCase(c.name())) {
                return c.name();
            }
        }
        return "";
    }
}
