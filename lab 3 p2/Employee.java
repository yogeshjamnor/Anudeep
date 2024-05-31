package Hashmap;

import java.util.HashSet;

class Employee {
    private int employeeID;
    private String employeeName;

    public Employee(int employeeID, String employeeName) {
        this.employeeID = employeeID;
        this.employeeName = employeeName;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        Employee employee = (Employee) obj;
        return employeeID == employee.employeeID;
    }

    public static void main(String[] args) {
        Employee emp1 = new Employee(1, "Alice");
        Employee emp2 = new Employee(2, "Bob");
        Employee emp3 = new Employee(3, "Charlie");

        HashSet<Employee> employeeSet = new HashSet<>();
        employeeSet.add(emp1);
        employeeSet.add(emp2);
        employeeSet.add(emp3);

        Employee emp4 = new Employee(1, "David");
        employeeSet.add(emp4);

        for (Employee emp : employeeSet) {
            System.out.println("Employee ID: " + emp.employeeID + ", Employee Name: " + emp.employeeName);
        }
    }
}
