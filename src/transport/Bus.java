package transport;

public class Bus extends Transport{

    public Bus(String brand, String model, Integer productionYear,
               String productionCountry, String color, Integer maxMovementSpeed) {
        super(brand, model, productionYear, productionCountry, color, maxMovementSpeed);
    }

    @Override
    public String toString() {
        return "Bus{" +
                "brand='" + getBrand() + '\'' +
                ", model='" + getModel() + '\'' +
                ", productionYear=" + getProductionYear() +
                ", productionCountry='" + getProductionCountry() + '\'' +
                ", color='" + getColor() + '\'' +
                ", maxMovementSpeed=" + getMaxMovementSpeed() +
                '}';
    }
}
