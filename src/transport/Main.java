package transport;

public class Main {
    public static void main(String[] args) {
        Transport lada = new Car("Lada", "Granta", 2015, "Russia",
                "yellow", 120, 1.7, "Mechanical",
                "Station wagon", "a482ac126", 5,
                new Car.Key(true, true));
        Transport audi = new Car("Audi", "A8 50 L TDI quattro", 2020, "Germany",
                "black", 180, 3.0, "Electromechanical",
                "Sedan", "y336ax156", 4,
                new Car.Key(true, true));
        Transport bmv = new Car("BMW", "Z8", 2021, "Germany",
                "black", 220,3.0, "Mechanical",
                "Sedan", "o227ay411", 5,
                new Car.Key(true, true));
        Transport kia = new Car("Kia", "Sportage 4th generation", 2018, "South Korea",
                "red", 180,
                2.4, "Mechanical",
                "Hatchback", "a698ay111", 5,
                new Car.Key(true, true));
        Transport hyundai = new Car("Hyundai", "Avante", 2016, "South Korea",
                "orange", 180,1.6, "Mechanical",
                "Station wagon", "x259ay647", 4,
                new Car.Key(false, true));
        System.out.println(lada);
        System.out.println(audi);
        System.out.println(bmv);
        System.out.println(kia);
        System.out.println(hyundai);
        Transport scania = new Bus("Scania", "G-Series", 2018,
                "Sweden", "white", 90);
        Transport volvo = new Bus("Volvo", "9500", 2020,
                "Sweden", "gold", 110);
        Transport PAZ = new Bus("PAZ", "3206", 2015,
                "Russia", "white", 100);
        System.out.println(scania);
        System.out.println(volvo);
        System.out.println(PAZ);


    }
}
