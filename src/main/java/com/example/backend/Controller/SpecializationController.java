package com.example.backend.Controller;

import com.example.backend.Service.SpecializationService;
import com.example.backend.Service.SpecializationServiceImplnation;
import com.example.backend.dto.BillDto;
import com.example.backend.dto.SpecializationDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class SpecializationController {

    @Autowired
    private SpecializationServiceImplnation specializationService;

    @PostMapping(value = "/specialization",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SpecializationDto> createSpecial(@RequestBody SpecializationDto specializationDto){
        SpecializationDto specializationDto1 = specializationService.save(specializationDto);
        return ResponseEntity.ok().body(specializationDto1);
    }
    @PutMapping(value = "/specialization/{id}",produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SpecializationDto> update(@RequestBody SpecializationDto specializationDto, @PathVariable Long id) throws Exception {
        SpecializationDto SpecializationDto= specializationService.update(specializationDto,id);
        return  ResponseEntity.ok().body(SpecializationDto);
    }
    @DeleteMapping(value = "/specialization/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{

        return specializationService.deleted(id);

    }
    @GetMapping(value = "/specialization",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<SpecializationDto>> getAll(){
        List<SpecializationDto> specializationDtos= specializationService.getAll();
        return ResponseEntity.ok().body(specializationDtos);
    }

    @GetMapping(value = "/specialization/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<SpecializationDto> getById(@PathVariable Long id) throws Exception{
        SpecializationDto SpecializationDto= specializationService.getById(id);
        return ResponseEntity.ok().body(SpecializationDto);
    }


}
