package transport;

public class Main {
    public static void main(String[] args) {
        Car lada = new Car("Lada", "Granta", 1.7, "yellow",
                2015, "Russia", "", "",
                "a482ac126", 0,
                new Car.Key(true, true));
        Car audi = new Car("Audi", "A8 50 L TDI quattro", 3.0, "black",
                2020, "Germany", "", "",
                "y336ax156", 4,
                new Car.Key(true, true));
        Car bmv = new Car("BMW", "Z8", 3.0, "black",
                2021, "Germany","", "",
                "", 4,
                new Car.Key(true, true));
        Car kia = new Car("Kia", "Sportage 4th generation", 2.4, "red",
                2018, "South Korea",
                "", "",
                "", 4,
                new Car.Key(true, true));
        Car hyundai = new Car("Hyundai", "Avante", 1.6, "orange",
                2016, "South Korea","", "",
                "", 4,
                new Car.Key(false, true));
        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmv);
        System.out.println(kia);
        System.out.println(hyundai);
    }
}
