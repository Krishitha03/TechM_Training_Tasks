
public class DaysOfWeek {
    public static void main(String[] args) {
        for (Enum_DaysOfWeek day : Enum_DaysOfWeek.values()) {
            //check condition equal to saturday or sunday for holiday else not
            if (day == Enum_DaysOfWeek.SATURDAY || day == Enum_DaysOfWeek.SUNDAY)
                System.out.println(day + " is Holiday");
            else
                System.out.println(day + " is not Holiday");
        }
    }
}
