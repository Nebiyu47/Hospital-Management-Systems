package com.example.backend.Service;

import com.example.backend.Entity.Department;
import com.example.backend.Repository.DepartmentRepository;
import com.example.backend.dto.DepartmentDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DepartmentServiceImplnation implements DepartmentService{

  @Autowired
    public DepartmentRepository departmentRepository;

  private Department convertDepartmentDtoToModel(DepartmentDto departmentDto){
      Department department = new Department();
      department.setId(departmentDto.getId());
      department.setDepartmentName(departmentDto.getDepartmentName());
      return department;
  }
  private DepartmentDto convertDepartmentModelTODto(Department department){
      return new DepartmentDto(department);
  }

    @Override
    public DepartmentDto save(DepartmentDto departmentdto) {
      Department department1 = convertDepartmentDtoToModel(departmentdto);
         return convertDepartmentModelTODto(departmentRepository.save(department1));
    }

    @Override
    public DepartmentDto update(DepartmentDto department,Long id) throws Exception{
       DepartmentDto departmentDto=convertDepartmentModelTODto(departmentRepository.findById(id).orElseThrow(() -> new Exception ("Id is Not Found"+id)));
       departmentDto.setId(department.getId());
       departmentDto.setDepartmentName(department.getDepartmentName());
       Department department1 = convertDepartmentDtoToModel(departmentDto);
       departmentRepository.save(department1);
        return departmentDto;
    }

    @Override
    public DepartmentDto getById( long id) throws Exception {
        Department department1 = departmentRepository.findById(id).orElseThrow(()->new Exception("No id Found"+id));
        return convertDepartmentModelTODto(department1);
    }

    @Override
    public List<DepartmentDto> getAll() {
        List<Department>departmentList= departmentRepository.findAll();
        List<DepartmentDto> departmentDtos = new ArrayList<>();
        for(Department department: departmentList){
            departmentDtos.add(convertDepartmentModelTODto(department));
        }
        return departmentDtos;
    }

    @Override
    public Map<String, Boolean> delete(Long id) throws Exception {
       Department department1 = convertDepartmentDtoToModel(getById(id));
       departmentRepository.delete(department1);
       Map<String,Boolean> response = new HashMap<>();
       response.put("Deleted",Boolean.TRUE);
       return response;
    }
}
