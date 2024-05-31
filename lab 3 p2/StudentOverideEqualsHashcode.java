package Hashmap;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

class Student {
    private String studentName;
    private int studentID;

    public Student(String studentName, int studentID) 
    {
        this.studentName = studentName;
        this.studentID = studentID;
    }

    @Override
    public boolean equals(Object o) 
    {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return studentID == student.studentID;
    }

    @Override
    public int hashCode()
    {
        return Objects.hash(studentID);
    }
}

public class Main 
{
    public static void main(String[] args)
    {
        Set<Student> studentSet = new HashSet<>();

        Student student1 = new Student("Alice", 1);
        Student student2 = new Student("Bob", 2);
        Student student3 = new Student("Charlie", 3);
        // adding Students to student set
        studentSet.add(student1);
        studentSet.add(student2);
        studentSet.add(student3);
        System.out.println(studentSet);
        Student student4 = new Student("David", 1);
       
        // Same studentID as student1
        boolean isAdded = studentSet.add(student4);
   // checking new student is added or not
        System.out.println("Is the new student added to the set? " + isAdded);
        System.out.println(studentSet);
    }
}
