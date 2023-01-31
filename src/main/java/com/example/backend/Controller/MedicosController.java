package com.example.backend.Controller;

import com.example.backend.Service.InsuranceServiceImplnation;
import com.example.backend.Service.MedicosServiceImplnation;
import com.example.backend.dto.InsuranceDto;
import com.example.backend.dto.MedicosDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class MedicosController {
    @Autowired
    private MedicosServiceImplnation medicosServiceImplnation;

    @PostMapping(value = "/medicos", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MedicosDto> AddingInsurance(@RequestBody MedicosDto medicosDto){
        MedicosDto medicosDto1 = medicosServiceImplnation.save(medicosDto);
        return ResponseEntity.ok().body(medicosDto);
    }
    @PutMapping(value = "/medicos/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MedicosDto> update(@RequestBody MedicosDto medicosDto , @PathVariable Long id) throws Exception{
        MedicosDto medicosDto1 = medicosServiceImplnation.update(medicosDto,id);
        return ResponseEntity.ok().body(medicosDto1);
    }

    @GetMapping(value = "/medicos", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE,MediaType.APPLICATION_JSON_VALUE} ,consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<MedicosDto>> getAll(){
        List<MedicosDto> medicosDto1 = medicosServiceImplnation.getAll();
        return ResponseEntity.ok().body(medicosDto1);
    }
    @GetMapping(value="/medicos/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<MedicosDto> getById(@PathVariable  Long id) throws Exception{
        MedicosDto medicosDto1= medicosServiceImplnation.getById(id);
        return ResponseEntity.ok().body(medicosDto1);
    }
    @DeleteMapping(value = "/medicos/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String, Boolean> deletedById(@PathVariable Long id) throws Exception{

        return medicosServiceImplnation.deleted(id);
    }
}
