package com.sofka.usecase;

import com.sofka.domain.Employee;

import java.util.Map;

public class CreateEmployeeUseCase {
    private Map<Integer,Employee> employees;

    public CreateEmployeeUseCase(Map<Integer,Employee> employees){
        this.employees = employees;
    }

    public Employee createEmployee(String name, Integer age){
        Employee emp = new Employee(name, age);

        employees.put(employees.size() + 1, emp );

        return emp;

    }

    public void listEmployees(){
        for (Employee emp: this.employees.values()) {
            System.out.println(String.format("%n Employee: %s, %s", emp.getName(), emp.getAge().toString()));
        }

    }
}
