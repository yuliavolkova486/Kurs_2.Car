package transport;

import java.util.Objects;

import static transport.UtilityValidate.validateString;

public abstract class Transport {
    private final String brand;
    private final String model;
    private final int productionYear;
    private final String productionCountry;
    private String color;
    private int maxMovementSpeed;

    public Transport(String brand, String model, int productionYear, String productionCountry,
                     String color, int maxMovementSpeed) {
        this.brand = validateTransportParameters(brand);
        this.model = validateTransportParameters(model);
        this.productionYear = validateProductionYear(productionYear);
        this.productionCountry = validateTransportParameters(productionCountry);
        this.color = validateTransportParameters(color);
        this.maxMovementSpeed = validateMaxMovementSpeed(maxMovementSpeed);
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public Integer getProductionYear() {
        return productionYear;
    }

    public String getProductionCountry() {
        return productionCountry;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public Integer getMaxMovementSpeed() {
        return maxMovementSpeed;
    }

    public void setMaxMovementSpeed(int maxMovementSpeed) {
        this.maxMovementSpeed = maxMovementSpeed;
    }

    public static String validateTransportParameters(String value) {
        return validateString(value, "Incorrect input");
    }

    public int validateMaxMovementSpeed(int maxMovementSpeed) {
        if (maxMovementSpeed <= 0) {
            throw new IllegalArgumentException("Incorrect input");
        } else {
            return maxMovementSpeed;
        }
    }

    public int validateProductionYear(int productionYear) {
        if (productionYear <= 1000) {
            throw new IllegalArgumentException("Incorrect input");
        } else {
            return productionYear;
        }
    }

    @Override
    public String toString() {
        return "Transport{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", productionYear=" + productionYear +
                ", productionCountry='" + productionCountry + '\'' +
                ", color='" + color + '\'' +
                ", maxMovementSpeed=" + maxMovementSpeed +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transport transport = (Transport) o;
        return Objects.equals(brand, transport.brand) && Objects.equals(model, transport.model)
                && Objects.equals(productionYear, transport.productionYear)
                && Objects.equals(productionCountry, transport.productionCountry)
                && Objects.equals(color, transport.color)
                && Objects.equals(maxMovementSpeed, transport.maxMovementSpeed);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, model, productionYear, productionCountry, color, maxMovementSpeed);
    }
}
