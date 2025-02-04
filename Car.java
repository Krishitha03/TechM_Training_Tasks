package Task1;
class Car{
    private String carMake;
    private String carModel;
    private int carYear;
    public static void StartEngine(){
        System.out.println(CarDisplays.engineStarted);
    }
    public void SetCarMake(String CarMake){
        this.carMake=carMake;
    }
    public void SetCarModel(String CarModel){
        this.carModel=carModel;
    }
    public void SetCarYear(String CarYear){
        this.carYear=carYear;
    }
    public String GetCarMake(){
        return carMake;
    }
    public String GetCarModel(){
        return carModel;
    }
    public int GetCarYear(){
        return carYear;
    }
}