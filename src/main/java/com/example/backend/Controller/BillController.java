package com.example.backend.Controller;

import com.example.backend.Service.BillService;
import com.example.backend.dto.BillDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class BillController {
    @Autowired
    private BillService billService;

    @PostMapping(value = "/bill",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE}, consumes ={MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BillDto> save(@RequestBody BillDto billDto){
        BillDto billDto1= billService.save(billDto);
        return ResponseEntity.ok().body(billDto1);
    }
    @PutMapping(value = "/bill/{id}",produces = {MediaType.APPLICATION_JSON_VALUE ,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BillDto> update(@RequestBody BillDto billDto, @PathVariable Long id) throws Exception {
        BillDto billDto1= billService.update(billDto,id);
        return  ResponseEntity.ok().body(billDto1);
    }
    @DeleteMapping(value = "/bill/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{

        return billService.delete(id);

    }
    @GetMapping(value = "/bill",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<BillDto>> getAll(){
        List billDto= billService.getAll();
        return ResponseEntity.ok().body(billDto);
    }

    @GetMapping(value = "/bill/{id}", produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<BillDto> getById(@PathVariable Long id) throws Exception{
        BillDto billDto= billService.getById(id);
        return ResponseEntity.ok().body(billDto);
    }
}
