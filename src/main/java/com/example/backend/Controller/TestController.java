package com.example.backend.Controller;

import com.example.backend.Entity.Test;
import com.example.backend.Service.TestService;
import com.example.backend.dto.TestDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class TestController {

    @Autowired
    private TestService testService;

    @PostMapping(value = "/test",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<TestDto> AddingTest(@RequestBody TestDto testDto){
        TestDto testDto1 = testService.save(testDto);
        return ResponseEntity.ok().body(testDto1);
    }
    @GetMapping(value = "/test",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<TestDto>> getAll(){
        List<TestDto> testDto = testService.getAll();
        return ResponseEntity.ok().body(testDto);
    }
    @GetMapping(value = "/test/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<TestDto> getById(@PathVariable Long id) throws Exception{
        TestDto testDto = testService.getById(id);
        return ResponseEntity.ok().body(testDto);

    }
    @PutMapping(value ="/test/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<TestDto> updatedTest(@RequestBody TestDto testDto , @PathVariable Long id)throws Exception{

        TestDto testDto1 = testService.update(testDto,id);
        return ResponseEntity.ok().body(testDto1);
    }
    @DeleteMapping(value = "/test/{id}" ,produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{
        return testService.deleted(id);
    }
}
