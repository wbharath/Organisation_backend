package com.ems.backend.service;

import com.ems.backend.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

//    return type EmployeeDto and passing the employeeDto object
    EmployeeDto createEmployee(EmployeeDto employeeDto);

    EmployeeDto getEmployeeById(Long EmployeeId);

    List<EmployeeDto> getAllEmployees();
}
