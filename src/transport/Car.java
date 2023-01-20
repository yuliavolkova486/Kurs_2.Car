package transport;

import java.util.Objects;
import java.util.regex.Pattern;
import static java.util.Calendar.MONTH;
import static transport.UtilityValidate.validateBoolean;
import static transport.UtilityValidate.validateString;

public class Car extends Transport {
    private double engineVolume;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int countOfSeats;
    private String isSummerTires;
    private Key key;

    public Car(String brand, String model, Integer productionYear, String productionCountry,
               String color, int maxMovementSpeed, double engineVolume, String transmission,
               String bodyType, String registrationNumber, int countOfSeats, Key key) {
        super(brand, model, productionYear, productionCountry, color, maxMovementSpeed);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.transmission = validateTransmission(transmission);
        this.bodyType = validateBodyType(bodyType);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.countOfSeats = validateCountOfSeats(countOfSeats);
        this.isSummerTires = changeTiresForSeasonalOnes();
        this.key = key;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getBodyType() {
        return bodyType;
    }

    public String getRegistrationNumber() {
        return registrationNumber;
    }

    public void setRegistrationNumber(String registrationNumber) {
        this.registrationNumber = registrationNumber;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }

    public String getIsSummerTires() {
        return isSummerTires;
    }

    public void setIsSummerTires(String isSummerTires) {
        this.isSummerTires = isSummerTires;
    }

    public Key getKey() {
        return key;
    }

    public void setKey(Key key) {
        this.key = key;
    }

    public static double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    public static String validateTransmission(String transmission) {
        return validateString(transmission, "Not specified");
    }

    public static String validateBodyType(String bodyType) {
        return validateString(bodyType, "Not specified");
    }

    public static int validateCountOfSeats(int countOfSeats) {
        return countOfSeats <= 0 ? 5 : countOfSeats;
    }

    public String changeTiresForSeasonalOnes() {
        if (MONTH >= 10 && MONTH <= 11
                || MONTH >= 0 && MONTH <= 3) {
            return "Winter tires";
        }
        if (MONTH >= 4 && MONTH <= 9) {
            return "Summer tires";
        }
        return "Change tires for seasonal ones!";
    }

    public String validateRegistrationNumber(String registrationNumber) {
        if (Pattern.matches("[a-z][0-9]{3}[a-z]{2}[0-9]{3}", registrationNumber)) {
            return registrationNumber;
        } else {
            return "Invalid number";
        }
    }



    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean launchingWithoutKey;

        public Key(boolean remoteEngineStart, boolean launchingWithoutKey) {
            this.remoteEngineStart = validateBoolean(remoteEngineStart);
            this.launchingWithoutKey = validateBoolean(launchingWithoutKey);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "remoteEngineStart=" + remoteEngineStart +
                    ", LaunchingWithoutKey=" + launchingWithoutKey +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "Car{" +"brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", productionYear=" + getProductionYear() +
                ", productionCountry='" + getProductionCountry() + '\'' +
                ", color='" + getColor() + '\'' +
                ", maxMovementSpeed='" + getMaxMovementSpeed() + '\'' +
                ", engineVolume='" + engineVolume +
                ", transmission='" + transmission + '\'' +
                ", bodyType='" + bodyType + '\'' +
                ", registrationNumber='" + registrationNumber + '\'' +
                ", countOfSeats=" + countOfSeats +
                ", '" + isSummerTires + '\'' +
                ", key=" + key +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && countOfSeats == car.countOfSeats
                && Objects.equals(transmission, car.transmission) && Objects.equals(bodyType, car.bodyType)
                && Objects.equals(registrationNumber, car.registrationNumber)
                && Objects.equals(isSummerTires, car.isSummerTires) && Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(engineVolume, transmission, bodyType,
                registrationNumber, countOfSeats, isSummerTires, key);
    }
}
