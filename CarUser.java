package Task1;

public class CarUser {
    public static void main(String[] args) {
        Car objArr[]={new ElectricCar(),new Car()};
        for(int i=0;i<objArr.length;i++){
            objArr[i].StartEngine();
        }
    }
}
