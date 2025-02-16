package task2;

public class Employee {
    int empId;
    String empName;
    double sal;
    int workedYears;

    public String getEmployeeDetails(){
        return "EmpId:"+empId+",EmpName:"+empName+",Sal:"+sal;
    }

    public void setEmployeeDetails(int empId,String empName,double sal,int workedYears){
        this.empId=empId;
        this.empName=empName;
        this.sal=sal;
        this.workedYears=workedYears;
    }

    public String getLoanEligibility(){
        String details=getEmployeeDetails();
        if(workedYears>5){
            if(sal>600000)
                System.out.println("\n2 lakhs of loan can be granted for the employee: ");
            else if(sal>=1000000)
                System.out.println("\n5 lakhs of loan can be granted for the employee: ");
            else if(sal>=1500000)
                System.out.println("\n7 lakhs of loan can be granted for the employee: ");
            else
                System.out.println("\nNot Eligible for the employee: ");
        }
        else{
            System.out.println("\nNot Eligible for the employee: ");
        }
        return details;
    }

    public Employee(int empId, String empName, double sal, int workedYears) {
        setEmployeeDetails(empId, empName, sal, workedYears);
    }
}
