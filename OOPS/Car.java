
class Car{
    //private variables are declared
    private String carMake;
    private String carModel;
    private int carYear;

    //startengine method
    public void startEngine(){
        System.out.println(CarDisplays.engineStarted);
    }

    //getters and setters for the private variables
    public void setCarMake(String CarMake){
        this.carMake=carMake;
    }
    public void setCarModel(String CarModel){
        this.carModel=carModel;
    }
    public void setCarYear(String CarYear){
        this.carYear=carYear;
    }
    public String getCarMake(){
        return carMake;
    }
    public String getCarModel(){
        return carModel;
    }
    public int getCarYear(){
        return carYear;
    }

    //parameterised constructor
    public Car(String carMake, String carModel, int carYear) {
        this.carMake = carMake;
        this.carModel = carModel;
        this.carYear = carYear;
    }
}
