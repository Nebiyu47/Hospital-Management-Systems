package com.example.backend.Service;

import com.example.backend.Entity.Ward;
import com.example.backend.Repository.WardRepository;
import com.example.backend.dto.WardDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class WardServiceImplnation implements WardService{

    @Autowired
    private WardRepository wardRepository;

    private Ward  convertDtoToModel(WardDto wardDto){

        Ward ward= new Ward();
        ward.setId(wardDto.getId());
        ward.setWardName(wardDto.getWardName());
        ward.setPatient(wardDto.getPatient());
        ward.setDoctor(wardDto.getDoctor());
        return ward;

    }
    private WardDto convertModelToDto(Ward ward){
        return new WardDto(ward);
    }


    @Override
    public WardDto save(WardDto wardDto) {
        Ward ward= wardRepository.save(convertDtoToModel(wardDto));
        return convertModelToDto(ward);
    }

    @Override
    public WardDto update(WardDto wardDto, Long id) throws Exception {
       Ward ward = wardRepository.findById(id).orElseThrow(()-> new Exception("Id IS not Found"+id));
        ward.setId(ward.getId());
        ward.setWardName(ward.getWardName());
        ward.setPatient(wardDto.getPatient());
        ward.setDoctor(ward.getDoctor());
        WardDto wardDto1 = convertModelToDto(wardRepository.save(ward));
       return wardDto1;
    }

    @Override
    public WardDto getById(Long id) throws Exception {
        Ward ward = wardRepository.findById(id).orElseThrow(()-> new Exception("ID iS NOT foUND"+id));
        return convertModelToDto(ward);
    }

    @Override
    public List<WardDto> getAll() {
        List<Ward> wardList = wardRepository.findAll();
        ArrayList<WardDto>wardDtos = new ArrayList<>();
        for (Ward ward : wardList){
            wardDtos.add(convertModelToDto(ward));
        }
        return wardDtos;
    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Ward ward = convertDtoToModel(getById(id));
        wardRepository.delete(ward);
        Map<String,Boolean>map = new HashMap<>();
        map.put("Deleted",Boolean.TRUE);
        return map;
    }
}
