package task2;

import java.util.ArrayList;
import java.util.Arrays;

public class EligibilityChecker {
    public static void main(String[] args) {
        ArrayList<Employee> employee=new ArrayList<Employee>(Arrays.asList(new Employee(11, "employee1", 2000000, 6),new Employee(12, "employee2", 500000, 8)));
        employee.stream().map(r->r.getLoanEligibility()).forEach(System.out::println);
    }
}
