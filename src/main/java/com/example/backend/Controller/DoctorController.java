package com.example.backend.Controller;

import com.example.backend.Service.DoctorServiceImplnation;
import com.example.backend.dto.DoctorDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DoctorController {

    @Autowired
    private DoctorServiceImplnation doctorServiceImplnation;

    @PostMapping(value = "/doctor", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DoctorDto> SaveDeoctor(@RequestBody DoctorDto dto) {
        DoctorDto doctorDto = doctorServiceImplnation.save(dto);
        return ResponseEntity.ok().body(doctorDto);
    }

    @PutMapping(value = "/doctor/{id}", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DoctorDto> updateDoctor(@RequestBody DoctorDto dto, @PathVariable Long id) throws Exception {
        DoctorDto doctorDto = doctorServiceImplnation.update(dto, id);
        return ResponseEntity.ok().body(doctorDto);
    }

    @GetMapping(value = "/doctor", produces = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE}, consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DoctorDto>> getAll() {
        List<DoctorDto> dto = doctorServiceImplnation.getAll();
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/doctor/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DoctorDto> getById(@PathVariable Long id) throws Exception{
        DoctorDto dto = doctorServiceImplnation.getById(id);
        return ResponseEntity.ok().body(dto);
    }
    @DeleteMapping(value = "/doctor/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{
        return doctorServiceImplnation.deleted(id);
    }
}
