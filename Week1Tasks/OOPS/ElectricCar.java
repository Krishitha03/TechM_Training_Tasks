

public class ElectricCar extends Car{
    String carBatteryRange;

    //chargeBattery method
    public static void chargeBattery(){
        System.out.println(CarDisplays.chargeBattery);
    }

    //parameterised constructor
    public ElectricCar(String carMake, String carModel, int carYear, String carBatteryRange) {
        super(carMake, carModel, carYear);
        this.carBatteryRange = carBatteryRange;
    }
     
}