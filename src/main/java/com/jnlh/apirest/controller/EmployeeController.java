package com.jnlh.apirest.controller;

import com.jnlh.apirest.dto.EmployeeDto;
import com.jnlh.apirest.service.EmployeeService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private EmployeeService employeeService;

    @PostMapping
    public ResponseEntity<EmployeeDto> createEmployee(@RequestBody EmployeeDto employeeDto){
        EmployeeDto savedEmpleado = employeeService.createEmpleado(employeeDto);
        return new ResponseEntity<>(savedEmpleado, HttpStatus.CREATED);
    }

    @GetMapping("/{id}")
    public ResponseEntity<EmployeeDto> getbyidEmployee(@PathVariable("id") Long id){
        EmployeeDto getEmpleado = employeeService.getbyIdEmpleado(id);
        return ResponseEntity.ok(getEmpleado);
    }

    @GetMapping
    public ResponseEntity<List<EmployeeDto>> getAllEmpleados(){
        List<EmployeeDto> empleados = employeeService.getAllEmployees();
        return ResponseEntity.ok(empleados);
    }

    @PutMapping("/{id}")
    public ResponseEntity<EmployeeDto> updateEmployee(@PathVariable("id") Long empleadoid,
                                                      @RequestBody EmployeeDto updatedEmployee){
        EmployeeDto employeeDto = employeeService.updateEmployee(empleadoid, updatedEmployee);
        return ResponseEntity.ok(employeeDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable("id") Long empleadoid){
        employeeService.deleteEmployee(empleadoid);
        return ResponseEntity.ok("Empleado eliminado corectamente");
    }


}
