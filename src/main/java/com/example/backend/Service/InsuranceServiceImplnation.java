package com.example.backend.Service;

import com.example.backend.Entity.Insurance;
import com.example.backend.Repository.insuranceRepository;
import com.example.backend.dto.InsuranceDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class InsuranceServiceImplnation implements InsuranceService{

    @Autowired
    private insuranceRepository insuranceRepository;

    private Insurance convertDtoTOModel(InsuranceDto insuranceDto){
        Insurance insurance = new Insurance();
        insurance.setId(insuranceDto.getId());
        insurance.setBillAmount(insuranceDto.getBillAmount());
        insurance.setExpiryDate(insuranceDto.getExpiryDate());
        insurance.setPatient(insuranceDto.getPatient());

        return insurance;
    }
    private InsuranceDto convertModelToDto(Insurance insurance){
        return new InsuranceDto(insurance);
    }


    @Override
    public InsuranceDto save(InsuranceDto insuranceDto) {
     Insurance insurance= insuranceRepository.save(convertDtoTOModel(insuranceDto));
     return convertModelToDto(insurance);
    }

    @Override
    public InsuranceDto getId(Long id) throws Exception {
        Insurance insurance= insuranceRepository.findById(id).orElseThrow(()->new Exception("ID is Not FOund"+id));
        return convertModelToDto(insurance);
    }

    @Override
    public List<InsuranceDto> getAll() {
        List<Insurance>insuranceList= insuranceRepository.findAll();
        List<InsuranceDto>insuranceDtoList1=new ArrayList<>();
        for(Insurance insurance : insuranceList){
            insuranceDtoList1.add(convertModelToDto(insurance));
        }
        return insuranceDtoList1;
    }

    @Override
    public InsuranceDto update(InsuranceDto insuranceDto, Long id) throws Exception {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(()->new Exception("Id Is not Found"+id));
        insurance.setId(insuranceDto.getId());
        insurance.setBillAmount(insuranceDto.getBillAmount());
        insurance.setExpiryDate(insuranceDto.getExpiryDate());
        insurance.setPatient(insuranceDto.getPatient());
       InsuranceDto insuranceDto1= convertModelToDto(insuranceRepository.save(insurance));
       return insuranceDto1;

    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Insurance insurance = insuranceRepository.findById(id).orElseThrow(()-> new Exception("ID is Not Found"+id));
        insuranceRepository.delete(insurance);
        Map<String, Boolean>map= new HashMap<>();
        map.put("delted",Boolean.TRUE);
        return map;
    }



}
