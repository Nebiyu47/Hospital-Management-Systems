package com.example.backend.Controller;

import com.example.backend.Service.EmployeeServiceImplnation;
import com.example.backend.dto.DoctorDto;
import com.example.backend.dto.EmployeeDto;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class EmployeeController {

    @Autowired
    private EmployeeServiceImplnation employeeServiceImplnation;

    @PostMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeDto> addEmployess(@RequestBody  EmployeeDto employeeDto){
        EmployeeDto employeeDto1 = employeeServiceImplnation.save(employeeDto);
        return ResponseEntity.ok().body(employeeDto1);
    }

    @PutMapping(value = "/employee/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeDto> updateDoctor(@RequestBody EmployeeDto dto, @PathVariable Long id) throws Exception {
        EmployeeDto employeeDto1 = employeeServiceImplnation.update(dto, id);
        return ResponseEntity.ok().body(employeeDto1);
    }

    @GetMapping(value = "/employee", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<java.util.List<EmployeeDto>> getAll() {
        List<EmployeeDto> dto = employeeServiceImplnation.getAll();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/employee/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<EmployeeDto> getById(@PathVariable  Long id) throws Exception{
        EmployeeDto dto = employeeServiceImplnation.getById(id);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/employee/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{
        return employeeServiceImplnation.delete(id);
    }
}
