package com.example.backend.Controller;

import com.example.backend.Entity.Patient;
import com.example.backend.Service.PatientService;
import com.example.backend.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private PatientService patientService;

    @PostMapping(value = "/patient", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PatientDto> AddingPatient(@RequestBody PatientDto patientDto ){
        PatientDto patientDto1 = patientService.save(patientDto);
        return ResponseEntity.ok().body(patientDto1);
    }
    @PutMapping(value = "/patient/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PatientDto> update(@RequestBody PatientDto patientDto , @PathVariable Long id) throws Exception {
        PatientDto patientDto1= patientService.update(patientDto,id);
        return ResponseEntity.ok().body(patientDto1);
    }
    @GetMapping(value = "/patient",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<PatientDto>> getAll(){
       List<PatientDto> patientDto = patientService.getAll();
        return ResponseEntity.ok().body(patientDto);
    }
     @GetMapping(value = "/patient/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<PatientDto> getById (@PathVariable Long id) throws Exception {
        PatientDto patientDto= patientService.getById(id);
        return ResponseEntity.ok().body(patientDto);
     }
     @DeleteMapping(value = "/patient/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
     public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{
        return patientService.deleted(id);
     }
     @PostMapping(value = "/patient/phoneNumber")
     public ResponseEntity<Map<String,Boolean>> existByPhoneNumber(@RequestBody PatientDto patientDto){
        Map<String ,Boolean> res = new HashMap<>();
        if(patientService.isExistPatient(patientDto)){
            res.put("Avaliable",Boolean.TRUE);
        }else {
            res.put("Avaliable",Boolean.FALSE);
        }
        return ResponseEntity.ok().body(res);
     }
}
