package com.jnlh.apirest.mapper;

import com.jnlh.apirest.dto.EmployeeDto;
import com.jnlh.apirest.entity.Empleado;

public class EmployeeMapper {

    public static EmployeeDto mapToEmployeeDto(Empleado empleado){
        return new EmployeeDto(
                empleado.getId(),
                empleado.getFirstName(),
                empleado.getLastName(),
                empleado.getEmail()
        );
    }

    public static Empleado mapToEmployee(EmployeeDto employeeDto){
        return new Empleado(
                employeeDto.getId(),
                employeeDto.getFirstName(),
                employeeDto.getLastName(),
                employeeDto.getEmail()
        );
    }




}
