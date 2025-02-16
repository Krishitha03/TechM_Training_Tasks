package task1.Task2;

import java.util.*;
import java.util.stream.Collectors;

public class Task2 {
    public static void main(String[] args) {
        ArrayList<Student> studentScore=new ArrayList<Student>(Arrays.asList(new Student("Student1", new int[]{80,89}),new Student("Student2",new int[]{92,34})));
        System.out.println("Before sorting the list:");
        studentScore.stream().map(r->"Name:"+r.name+",Total:"+r.total+",Average:"+r.average).forEach(System.out::println);
        List<Student>sortedList=studentScore.stream().sorted((student1,student2)->Integer.compare(student2.total, student1.total)).collect(Collectors.toList());
        System.out.println("\nAfter sorting the list:");
        sortedList.forEach(System.out::println);
    }
}