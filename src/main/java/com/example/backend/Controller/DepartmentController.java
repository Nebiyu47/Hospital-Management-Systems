package com.example.backend.Controller;

import com.example.backend.Service.DepartmentServiceImplnation;
import com.example.backend.dto.DepartmentDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api")
public class DepartmentController {

    @Autowired
    private DepartmentServiceImplnation departmentService;


    @PostMapping(value = "/department",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DepartmentDto> created(@RequestBody  DepartmentDto departmentDto){
        DepartmentDto dto = departmentService.save(departmentDto);
        return ResponseEntity.ok().body(dto);

    }
    @PutMapping(value = "/department/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<DepartmentDto> update(@RequestBody DepartmentDto departmentDto , @PathVariable Long id) throws Exception{
        DepartmentDto dto = departmentService.update(departmentDto,id);
        return ResponseEntity.ok().body(dto);
    }

    @GetMapping(value = "/department",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public ResponseEntity<List<DepartmentDto>> getAll(){
        List<DepartmentDto> departmentDto = departmentService.getAll();
        return ResponseEntity.ok().body(departmentDto);
    }

    @GetMapping(value = "/department/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
   public ResponseEntity<DepartmentDto> getByIdDepatment(@PathVariable Long id) throws Exception{
        DepartmentDto departmentDto = departmentService.getById(id);
        return ResponseEntity.ok().body(departmentDto);
    }
    @DeleteMapping(value = "/department/{id}",produces = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE},consumes = {MediaType.APPLICATION_JSON_VALUE,MediaType.APPLICATION_XML_VALUE})
    public Map<String,Boolean> deleted(@PathVariable Long id) throws Exception{
        return departmentService.delete(id);
    }
}
