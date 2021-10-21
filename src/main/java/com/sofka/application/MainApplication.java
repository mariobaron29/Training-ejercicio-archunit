package com.sofka.application;

import com.sofka.domain.Employee;
import com.sofka.usecase.CreateEmployeeUseCase;

import java.util.HashMap;
import java.util.Map;

public class MainApplication {
    public static void main(String[] args) {
        Map<Integer, Employee> employees = new HashMap<>();
        CreateEmployeeUseCase employeeUseCase = new CreateEmployeeUseCase(employees);

        Employee emp1 = employeeUseCase.createEmployee("Mario Barón", 33);
        System.out.println("Employee created " + emp1);

        Employee emp2 = employeeUseCase.createEmployee("Johanna Rueda", 33);
        System.out.println("Employee created " + emp2);

        employeeUseCase.listEmployees();

    }
}
