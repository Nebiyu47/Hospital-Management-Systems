package com.example.backend.Service;

import com.example.backend.Entity.Specialization;
import com.example.backend.Repository.SpecializationRepository;
import com.example.backend.dto.SpecializationDto;
import jakarta.transaction.Transactional;
import org.aspectj.apache.bcel.generic.RET;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class SpecializationServiceImplnation implements SpecializationService {

  @Autowired
   private SpecializationRepository specializationRepository;

   private Specialization convertDtoToModel(SpecializationDto specializationDto){
       Specialization specialization = new Specialization();
       specialization.setId(specializationDto.getId());
       specialization.setSpeciality(specializationDto.getSpeciality());
       return specialization;
   }
   private SpecializationDto convertModelToDto(Specialization specialization){
       return new SpecializationDto(specialization);
   }


    @Override
    public SpecializationDto save(SpecializationDto specializationDto) {
        Specialization specialization = specializationRepository.save(convertDtoToModel(specializationDto));
        return convertModelToDto(specialization);
    }

    @Override
    public SpecializationDto update(SpecializationDto specializationDto, Long id) throws Exception {
        Specialization specialization = new Specialization();
        specialization.setId(specializationDto.getId());
        specialization.setSpeciality(specializationDto.getSpeciality());
        SpecializationDto specializationDto1 = convertModelToDto(specializationRepository.save(specialization));
        return specializationDto1;
    }

    @Override
    public SpecializationDto getById(Long id) throws Exception {
        Specialization specialization= specializationRepository.findById(id).orElseThrow(()-> new Exception("Id is not Found"+id));
        return convertModelToDto(specialization);
    }

    @Override
    public List<SpecializationDto> getAll() {
        List<Specialization> specializations = specializationRepository.findAll();
        List<SpecializationDto>specializationDtos = new ArrayList<>();
        for (Specialization specialization: specializations){
            specializationDtos.add(convertModelToDto(specialization));
        }
        return specializationDtos;
    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Specialization specialization = specializationRepository.findById(id).orElseThrow(() -> new Exception("Id Is Not Found"+id));
        specializationRepository.delete(specialization);
        Map<String,Boolean> map = new HashMap<>();
        map.put("Deleted",Boolean.TRUE);
        return map;
   }
}
