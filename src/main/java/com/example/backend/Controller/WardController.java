package com.example.backend.Controller;

import com.example.backend.Service.WardServiceImplnation;
import com.example.backend.dto.TestDto;
import com.example.backend.dto.WardDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api")
public class WardController {
    @Autowired
    private WardServiceImplnation wardServiceImplnationc;

    @PostMapping(value = "/ward",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WardDto> AddingTest(@RequestBody WardDto wardDto){
        WardDto wardDto1 = wardServiceImplnationc.save(wardDto);
        return ResponseEntity.ok().body(wardDto1);
    }
    @GetMapping(value = "/ward",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<WardDto>> getAll(){
        List<WardDto> wardDto = wardServiceImplnationc.getAll();
        return ResponseEntity.ok().body(wardDto);
    }
    @GetMapping(value = "/ward/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WardDto> getById(@PathVariable Long id) throws Exception{
        WardDto wardDto = wardServiceImplnationc.getById(id);
        return ResponseEntity.ok().body(wardDto);

    }
    @PutMapping(value ="/ward/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<WardDto> updatedTest(@RequestBody WardDto wardDto ,@PathVariable Long id)throws Exception{
        WardDto wardDto1 = wardServiceImplnationc.update(wardDto,id);
        return ResponseEntity.ok().body(wardDto1);
    }
}
