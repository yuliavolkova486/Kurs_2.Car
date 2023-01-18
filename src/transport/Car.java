package transport;

import java.util.Objects;
import java.util.regex.Pattern;
import static java.util.Calendar.MONTH;

public class Car {
    private final String brand;
    private final String model;
    private double engineVolume;
    private String color;
    private final Integer productionYear;
    private final String productionCountry;
    private String transmission;
    private final String bodyType;
    private String registrationNumber;
    private final int countOfSeats;
    private String isSummerTires;
    private Key key;


    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               Integer productionYear,
               String productionCountry,
               String transmission,
               String bodyType,
               String registrationNumber,
               int countOfSeats,
               Key key) {
        this.brand = validateCarParameters(brand);
        this.model = validateCarParameters(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateCarColor(color);
        this.productionYear = validateProductionYear(productionYear);
        this.productionCountry = validateProductionCountry(productionCountry);
        this.transmission = validateTransmission(transmission);
        this.bodyType = validateBodyType(bodyType);
        this.registrationNumber = validateRegistrationNumber(registrationNumber);
        this.countOfSeats = validateCountOfSeats(countOfSeats);
        this.isSummerTires = changeTiresForSeasonalOnes();
        this.key = key;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public double getEngineVolume() {
        return engineVolume;
    }

    public void setEngineVolume(double engineVolume) {
        this.engineVolume = engineVolume;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
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

    public String getIsisSummerTires() {
        return isSummerTires;
    }

    public void setIsisSummerTires(String isWinterTires) {
        this.isSummerTires = isWinterTires;
    }

    @Override
    public String toString() {
        return "Car: { " +
                "brand:'" + brand + '\'' +
                ", model:'" + model + '\'' +
                ", engineVolume:" + engineVolume +
                ", color:'" + color + '\'' +
                ", productionYear:" + productionYear +
                ", productionCountry:'" + productionCountry + '\'' +
                ", transmission:'" + transmission + '\'' +
                ", bodyType:'" + bodyType + '\'' +
                ", registrationNumber:" + registrationNumber +
                ", countOfSeats:" + countOfSeats +
                ", '" + isSummerTires + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return Double.compare(car.engineVolume, engineVolume) == 0 && countOfSeats == car.countOfSeats
                && Objects.equals(brand, car.brand) && Objects.equals(model, car.model)
                && Objects.equals(color, car.color) && Objects.equals(productionYear, car.productionYear)
                && Objects.equals(productionCountry, car.productionCountry)
                && Objects.equals(transmission, car.transmission) && Objects.equals(bodyType, car.bodyType)
                && Objects.equals(registrationNumber, car.registrationNumber)
                && Objects.equals(isSummerTires, car.isSummerTires) && Objects.equals(key, car.key);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, engineVolume, color, productionYear, productionCountry,
                transmission, bodyType, registrationNumber, countOfSeats, isSummerTires, key);
    }

    public static String validateCarParameters(String value) {
        return UtilityValidate.validateString(value, "Not specified");

    }

    public static double validateEngineVolume(double engineVolume) {
        return engineVolume <= 0 ? 1.5 : engineVolume;
    }

    public static String validateCarColor(String color) {
        return UtilityValidate.validateString(color, "white");
    }

    public static Integer validateProductionYear(Integer productionYear) {
        return productionYear == null || productionYear <= 1884 ? 2000 : productionYear;
    }

    public static String validateTransmission(String transmission) {
        return UtilityValidate.validateString(transmission, "Not specified");
    }

    public static String validateBodyType(String bodyType) {
        return UtilityValidate.validateString(bodyType, "Not specified");
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

    public static String validateProductionCountry(String value) {
        return UtilityValidate.validateString(value, "Not specified");
    }

    public static class Key {
        private final boolean remoteEngineStart;
        private final boolean launchingWithoutKey;

        public Key(boolean remoteEngineStart, boolean launchingWithoutKey) {
            this.remoteEngineStart = UtilityValidate.validateBoolean(remoteEngineStart);
            this.launchingWithoutKey = UtilityValidate.validateBoolean(launchingWithoutKey);
        }

        @Override
        public String toString() {
            return "Key{" +
                    "remoteEngineStart=" + remoteEngineStart +
                    ", LaunchingWithoutKey=" + launchingWithoutKey +
                    '}';
        }
    }
}
