package com.jnlh.apirest.service.impl;

import com.jnlh.apirest.dto.EmployeeDto;
import com.jnlh.apirest.entity.Empleado;
import com.jnlh.apirest.exceptions.ResourceNotFoundException;
import com.jnlh.apirest.mapper.EmployeeMapper;
import com.jnlh.apirest.repository.EmployeeRepository;
import com.jnlh.apirest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeDto createEmpleado(EmployeeDto employeeDto) {

        Empleado empleado = EmployeeMapper.mapToEmployee(employeeDto);
        Empleado savedEmpleado = employeeRepository.save(empleado);
        return EmployeeMapper.mapToEmployeeDto(savedEmpleado);
    }

    @Override
    public EmployeeDto getbyIdEmpleado(Long empleadoid) {

        Empleado empleado = employeeRepository.findById(empleadoid)
                .orElseThrow(() -> new ResourceNotFoundException("Empleado no existe con este id : " + empleadoid));
        return EmployeeMapper.mapToEmployeeDto(empleado);
    }

    @Override
    public List<EmployeeDto> getAllEmployees() {
        List<Empleado> empleados = employeeRepository.findAll();
        return empleados.stream().map((empleado) -> EmployeeMapper.mapToEmployeeDto(empleado))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDto updateEmployee(Long empleadoid, EmployeeDto updatedEmpleado) {

        Empleado employee = employeeRepository.findById(empleadoid).orElseThrow(
                () -> new ResourceNotFoundException("Empleado no existe  con este id : " + empleadoid)
        );
        employee.setFirstName(updatedEmpleado.getFirstName());
        employee.setLastName(updatedEmpleado.getLastName());
        employee.setEmail(updatedEmpleado.getEmail());

        Empleado upt_employee = employeeRepository.save(employee);

        return EmployeeMapper.mapToEmployeeDto(upt_employee);
    }

    @Override
    public void deleteEmployee(Long empleadoid) {

        Empleado empleado = employeeRepository.findById(empleadoid).orElseThrow(
                () -> new ResourceNotFoundException("Empleado no existe conesta id : " + empleadoid)
        );

        employeeRepository.deleteById(empleadoid);
    }


}
