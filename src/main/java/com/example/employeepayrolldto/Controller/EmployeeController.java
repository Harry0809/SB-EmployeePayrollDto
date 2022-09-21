package com.example.employeepayrolldto.Controller;

import com.example.employeepayrolldto.Dto.EmployeeDto;
import com.example.employeepayrolldto.Dto.ResponseDto;
import com.example.employeepayrolldto.Model.EmployeeData;
import com.example.employeepayrolldto.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class EmployeeController {

    @Autowired
    EmployeeService employeeService;

    List<EmployeeData> list = new ArrayList<>();

    //Save Data
        @PostMapping("/save")
        public ResponseEntity<ResponseDto> save(@RequestBody EmployeeDto employeeDto){
            ResponseDto responseDto = new ResponseDto("data saved" , employeeService.saveAll(employeeDto));

            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }

        @GetMapping("/data")
    public ResponseEntity<ResponseDto> displayAll(){
            ResponseDto responseDto= new ResponseDto("Data displayed" , employeeService.display());
            return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
        }

        @GetMapping("/find/{id}")
    public ResponseEntity<ResponseDto> findById(@PathVariable int id){
            Optional<EmployeeData> empData = employeeService.findById(id);
            String message = empData.isPresent() ? "Employee id founded" : "employee id is not founded";
            ResponseDto responseDto= new ResponseDto(message,employeeService.findById(id));
            return new ResponseEntity<ResponseDto>(responseDto,HttpStatus.OK);
        }

        @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> delete(@PathVariable int id) {
            Boolean isEmpId = employeeService.deleteById(id);
            String message = isEmpId ? "ID deleted succesfully" : "ID not founded";
            ResponseDto responseDto = new ResponseDto(message);
            return new ResponseEntity<ResponseDto>(responseDto, HttpStatus.OK);
        }
}

