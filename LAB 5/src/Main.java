public class Main {
    public static void main(String[] args) {

        Vehicle car = new Car("Автомобиль");
        Vehicle bicycle = new Bicycle("Велосипед");
        Vehicle boat = new Boat("Катамаран");


        ElectricVehicle tesla = new ElectricCar("Tesla Model S");
        ElectricVehicle electricBicycle = new ElectricBicycle("Электрический велосипед");

        System.out.println("Движется ли транспорт?");
        Vehicle[] vehicles = { car, bicycle, boat, tesla, electricBicycle };
        for (Vehicle v : vehicles) {
            v.move();
        }

        System.out.println("\nЗАРЯДКА");
        ElectricVehicle[] electricVehicles = { tesla, electricBicycle };
        for (ElectricVehicle ev : electricVehicles) {
            ev.chargeBattery();
        }
    }
}


abstract class Vehicle {
    protected String name;

    public Vehicle(String name) {
        this.name = name;
    }

    public abstract void move();
}



class Car extends Vehicle {
    public Car(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " едет.");
    }
}

class Bicycle extends Vehicle {
    public Bicycle(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " крутит педали.");
    }
}

class Boat extends Vehicle {
    public Boat(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " плывёт.");
    }
}



abstract class ElectricVehicle extends Vehicle {
    protected int batteryLevel;

    public ElectricVehicle(String name) {
        super(name);
        this.batteryLevel = 50;
    }


    public abstract void chargeBattery();


    protected void printBatteryLevel() {
        System.out.println(name + ": текущий уровень заряда = " + batteryLevel + "%");
    }
}


class ElectricCar extends ElectricVehicle {

    public ElectricCar(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " едет.");
    }

    @Override
    public void chargeBattery() {
        System.out.println(name + " заряжается.");
        batteryLevel = 100;
        printBatteryLevel();
    }
}

class ElectricBicycle extends ElectricVehicle {

    public ElectricBicycle(String name) {
        super(name);
    }

    @Override
    public void move() {
        System.out.println(name + " крутит педали с электромотором.");
    }

    @Override
    public void chargeBattery() {
        System.out.println(name + " заряжается.");
        batteryLevel = 80;
        printBatteryLevel();
    }
}
