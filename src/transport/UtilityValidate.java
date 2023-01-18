package transport;

public class UtilityValidate {
    public static String validateString(String value, String defaultValue) {
        return (value == null || value.isBlank() || value.isEmpty()) ? defaultValue : value;
    }

    public static Boolean validateBoolean(Boolean value) {
        return value != null && value;
    }
}
