package task1.Task2;

import java.util.Arrays;

public class Student {
    String name;
    int marks[];
    int total;
    double average;

    //constructor of student class
    public Student(String name,int marks[]) {
        this.name = name;
        this.marks = marks;
        this.total=Arrays.stream(marks).sum();
        this.average=total/marks.length;
    }
    
    @Override
    public String toString() {
        return "Name:"+name+",Marks:"+Arrays.toString(marks)+",Total:"+total+",Average:"+average;
    }
}
