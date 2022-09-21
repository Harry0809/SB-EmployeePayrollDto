package com.example.employeepayrolldto.Service;

import com.example.employeepayrolldto.Dto.EmployeeDto;

public interface IEmployeeService {

    Object saveAll(EmployeeDto employeeDto);

    Object display();

    Object findById();

    Object deleteById();

}
