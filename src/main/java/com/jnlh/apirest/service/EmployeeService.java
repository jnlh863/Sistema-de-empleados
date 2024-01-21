package com.jnlh.apirest.service;

import com.jnlh.apirest.dto.EmployeeDto;

import java.util.List;

public interface EmployeeService {

    EmployeeDto createEmpleado(EmployeeDto employeeDto);

    EmployeeDto getbyIdEmpleado(Long empleadoid);

    List<EmployeeDto> getAllEmployees();

    EmployeeDto updateEmployee(Long empleadoid, EmployeeDto updatedEmpleado);

    void deleteEmployee(Long empleadoid);

}
