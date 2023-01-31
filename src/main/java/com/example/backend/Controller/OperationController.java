package com.example.backend.Controller;

import com.example.backend.Service.OperationServiceImpnation;
import com.example.backend.dto.MedicosDto;
import com.example.backend.dto.OperationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class OperationController {

    @Autowired
    private OperationServiceImpnation operationServiceImpnation;

    @PostMapping(value = "/operation", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<OperationDto> AddingInsurance(@RequestBody OperationDto operationDto){
       OperationDto operationDto1 = operationServiceImpnation.save(operationDto);
        return ResponseEntity.ok().body(operationDto1);
    }
    @PutMapping(value = "/operation/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<OperationDto> update(@RequestBody OperationDto operationDto,@PathVariable Long Id) throws Exception{
        OperationDto operationDto1= operationServiceImpnation.update(operationDto,Id);
        return ResponseEntity.ok().body(operationDto1);
    }
    @GetMapping(value = "/operation", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<OperationDto>> getAll(){
        List<OperationDto> operationDto1 = operationServiceImpnation.getAll();
        return ResponseEntity.ok().body(operationDto1);
    }
    @GetMapping(value="/operation/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<OperationDto> getById(@PathVariable  Long id) throws Exception{
        OperationDto operationDto1= operationServiceImpnation.getById(id);
        return ResponseEntity.ok().body(operationDto1);
    }
    @DeleteMapping(value = "/operation/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String, Boolean> deletedById(@PathVariable Long id) throws Exception{
        return operationServiceImpnation.deleted(id);
    }
}
