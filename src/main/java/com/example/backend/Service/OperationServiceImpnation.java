package com.example.backend.Service;

import com.example.backend.Entity.Operation;
import com.example.backend.Repository.OperationRepository;
import com.example.backend.dto.OperationDto;
import jakarta.transaction.Transactional;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class OperationServiceImpnation implements OperationService{
     @Autowired
    private OperationRepository operationRepository;

     private Operation convertDtoToModel(OperationDto operationDto){
         Operation operation = new Operation();
         operation.setId(operationDto.getId());
         operation.setOperationName(operationDto.getOperationName());
         operation.setPatient(operationDto.getPatient());
         operation.setDoctor(operationDto.getDoctor());
         return operation;


     }
  private OperationDto convertModelToDto(Operation operation){
         return new OperationDto(operation);
  }


    @Override
    public OperationDto save(OperationDto operationDto) {
        Operation operation = operationRepository.save(convertDtoToModel(operationDto));
        return convertModelToDto(operation);
    }

    @Override
    public OperationDto update(OperationDto operationDto, Long id) throws Exception{
        Operation operation = new Operation();
        operation.setId(operationDto.getId());
        operation.setOperationName(operationDto.getOperationName());
        operation.setPatient(operationDto.getPatient());
        operation.setDoctor(operationDto.getDoctor());
        OperationDto operationDto1= convertModelToDto(operationRepository.save(operation));
        return operationDto1;
    }

    @Override
    public OperationDto getById(Long id) throws Exception {
        Operation operation= operationRepository.findById(id).orElseThrow(()-> new Exception("Id is Not Found"+id));
        return convertModelToDto(operation);
    }

    @Override
    public List<OperationDto> getAll() {
        List<Operation> operationList = operationRepository.findAll();
        ArrayList<OperationDto> operationDtos = new ArrayList<>();
        for(Operation operation : operationList){
            operationDtos.add(convertModelToDto(operation));
        }
        return operationDtos;
    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Map<String,Boolean> map = new HashMap<>();
        Operation operationDto=operationRepository.getById(id);
        map.put("deleted",Boolean.TRUE);
        return map;
     }
}
