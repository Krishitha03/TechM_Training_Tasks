

public class CarUser {
    public static void main(String[] args) {
        //array for storing objects of the cars is declared and initialised
        Car objArr[]={new ElectricCar("Mahindra","BE 6",2024,"79 kWh"),new Car("Mahindra","BE 6",2024)};
        for(int i=0;i<objArr.length;i++){
            objArr[i].startEngine();
        }
    }
}