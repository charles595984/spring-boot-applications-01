package com.skcoder.interviewpoints.emps;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class GroupEmployeesByDepartment {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee(1, "jack", "hr", 20000),
                new Employee(2, "siddu", "hr", 10000),
                new Employee(3, "rahul", "it", 30000),
                new Employee(4, "divya", "finance", 50000),
                new Employee(5, "harini", "finance", 60000),
                new Employee(8, "aditya", "it", 80000),
                new Employee(7, "joe", "it", 90000)
        );

        IO.println("*****CustomSortingByEmployeeIdAndName*****");
        List<Employee> sortedById = employees.stream()
                .sorted(Comparator.comparingInt(Employee::id))
                .toList();
        IO.println("SortByEmployeeId: " + sortedById);

        List<Employee> sortedByName = employees.stream()
                .sorted(Comparator.comparing(Employee::name))
                .toList();
        IO.println("SortByEmployeeName: " + sortedByName);

        List<Employee> sortedByIdThenName = employees.stream()
                .sorted(Comparator.comparingInt(Employee::id)
                        .thenComparing(Employee::name))
                .toList();
        IO.println("SortByEmployeeIdAndName: " + sortedByIdThenName);


        IO.println("*****GroupEmployeesByDepartment*****");
        Map<String, List<Employee>> employeesByDepartment = employees
                .stream()
                .collect(Collectors.groupingBy(Employee::department));
        IO.println("GroupEmployeesByDepartment: " + employeesByDepartment);


        IO.println("*****EmployeesByDepartmentAndReturnNameOnly*****");
        Map<String, List<String>> employeesByDepartmentAndReturnNameOnly = employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.mapping(Employee::name, Collectors.toList())
                ));
        IO.println("EmployeesByDepartmentAndReturnNameOnly: " + employeesByDepartmentAndReturnNameOnly);


        IO.println("*****AverageSalaryByDepartment*****");
        Map<String, Double> avgSalaryByDepartment = employees
                .stream()
                .collect(Collectors.groupingBy(
                        Employee::department,
                        Collectors.averagingDouble(Employee::salary)));
        IO.println("*****AverageSalaryByDepartment*****: " + avgSalaryByDepartment);


        IO.println("*****GreaterThanSalaryAndReturnId*****");
        List<Integer> result = employees
                .stream()
                .filter(emp -> emp.salary() > 50000)
                .map(Employee::id)
                .toList();
        IO.println("GreaterThanSalaryAndReturnId: " + result);


        IO.println("*****FilterEmployeebyDepartment*****");
        List<Employee> itEmployees = employees
                .stream()
                .filter(emp -> "IT".equals(emp.department()))
                .toList();
        IO.println("FilterEmployeebyDepartment: " + result);


        IO.println("*****HighestSalary*****");
        Employee highestSalary = employees
                .stream()
                .max(Comparator.comparingDouble(Employee::salary))
                .orElse(null);
        IO.println("HighestSalary: " + highestSalary);

        IO.println("*****GetEmployeeNamesWithCommaSeparators*****");
        String employeeNames = employees
                .stream()
                .map(Employee::name)
                .collect(Collectors.joining(", "));
        IO.println("GetEmployeeNamesWithCommaSeparators: " + employeeNames);


        IO.println("*****SortEmployeesBySalary*****");
        List<Employee> sortedEmployeeBySalary = employees.stream()
                .sorted(Comparator.comparingDouble(Employee::salary))
                .toList();
        IO.println("SortEmployeesBySalary: " + sortedEmployeeBySalary);


        IO.println("*****ConvertEmployeeListToMapAsIdAndname*****");
        Map<Integer, String> employeemap = employees.stream()
                .collect(Collectors.toMap(Employee::id, Employee::name));
        IO.println("SortEmployeesBySalary: " + employeemap);

    }
}
