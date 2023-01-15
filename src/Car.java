public class Car {
    private final String brand;
    private final String model;
    private final double engineVolume;
    private final String color;
    private final Integer productionYear;
    private final String productionCountry;


    public Car(String brand,
               String model,
               double engineVolume,
               String color,
               Integer productionYear,
               String productionCountry) {
        this.brand = validateCarParameters(brand);
        this.model = validateCarParameters(model);
        this.engineVolume = validateEngineVolume(engineVolume);
        this.color = validateCarColor(color);
        this.productionYear = validateProductionYear(productionYear);
        this.productionCountry = validateCarParameters(productionCountry);
    }


    @Override
    public String toString() {
        return "Car{" +
                "brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                ", engineVolume='" + engineVolume + '\'' +
                ", color='" + color + '\'' +
                ", year='" + productionYear + '\'' +
                ", country='" + productionCountry + '\'' +
                '}';
    }

    public static String validateCarParameters(String value) {
        return UtilityValidate.validateString(value, "default");

    }

    public static double validateEngineVolume(double value) {
        return value <= 0 ? 1.5 : value;
    }

    public static String validateCarColor(String color) {
        return UtilityValidate.validateString(color, "white");
    }

    public static Integer validateProductionYear(Integer value) {
        return value <= 0 ? 2000 : value;
    }
}
