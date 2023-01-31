package com.example.backend.Controller;

import com.example.backend.Service.InsuranceService;
import com.example.backend.dto.BillDto;
import com.example.backend.dto.InsuranceDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api")
public class InsuranceController {

    @Autowired
    private InsuranceService insuranceService;

     @PostMapping(value = "/insurance", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
     public ResponseEntity<InsuranceDto> AddingInsurance(@RequestBody InsuranceDto insuranceDto){
         InsuranceDto insuranceDto1 = insuranceService.save(insuranceDto);
         return ResponseEntity.ok().body(insuranceDto1);
     }

    @PutMapping(value = "/insurance/{id}",produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<InsuranceDto> update(@RequestBody InsuranceDto insuranceDto, @PathVariable Long id) throws Exception {
        InsuranceDto insuranceDto1= insuranceService.update(insuranceDto,id);
        return  ResponseEntity.ok().body(insuranceDto1);
    }

     @GetMapping(value = "/insurance", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<InsuranceDto>> getAll(){
         List<InsuranceDto> insuranceDto = insuranceService.getAll();
         return ResponseEntity.ok().body(insuranceDto);
     }
     @GetMapping(value="/insurance/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
       public ResponseEntity<InsuranceDto> getById(@PathVariable  Long id) throws Exception{
         InsuranceDto insuranceDto= insuranceService.getId(id);
         return ResponseEntity.ok().body(insuranceDto);
     }
     @DeleteMapping(value = "/insurance/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String, Boolean> deletedById(@PathVariable Long id) throws Exception{

         return insuranceService.deleted(id);
     }


}
