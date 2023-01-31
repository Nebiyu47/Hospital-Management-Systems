package com.example.backend.Service;

import com.example.backend.Entity.Medicos;
import com.example.backend.Repository.MedicosRepository;
import com.example.backend.dto.MedicosDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class MedicosServiceImplnation implements MedicosService{
    @Autowired
    private MedicosRepository medicosRepository;

    private Medicos  convertDtoToModel(MedicosDto medicosDto){
        Medicos medicos= new Medicos();
        medicos.setMed_Id(medicosDto.getId());
        medicos.setMedRecorded(medicosDto.getMedRecorded());
        medicos.setPrice(medicosDto.getPrice());
        medicos.setQuantity(medicosDto.getQuantity());
        medicos.setTotal(medicosDto.getTotal());
        medicos.setPatient(medicosDto.getPatient());
        medicos.setDoctor(medicosDto.getDoctor());
        return medicos;
    }
    private MedicosDto convertModelToDto(Medicos medicos){
        return new MedicosDto(medicos);
    }

    @Override
    public MedicosDto save(MedicosDto medicosDto) {
        Medicos medicos = medicosRepository.save(convertDtoToModel(medicosDto));
        return convertModelToDto(medicos);
    }

    @Override
    public MedicosDto update(MedicosDto medicosDto, Long id)  throws Exception {
        Medicos medicos= medicosRepository.findById(id).orElseThrow(()-> new Exception("Id Is Not Found"+ id));
        medicos.setMed_Id(medicosDto.getId());
        medicos.setMedRecorded(medicosDto.getMedRecorded());
        medicos.setPrice(medicosDto.getPrice());
        medicos.setQuantity(medicosDto.getQuantity());
        medicos.setTotal(medicosDto.getTotal());
        medicos.setDate(medicosDto.getDate());
        medicos.setDoctor(medicosDto.getDoctor());
        medicos.setPatient(medicosDto.getPatient());
        return convertModelToDto(medicosRepository.save(medicos));
    }

    @Override
    public MedicosDto getById(Long id) throws Exception {
        Medicos medicos= medicosRepository.findById(id).orElseThrow(()->new Exception("ID is Not Found"+id));
        return convertModelToDto(medicos);
    }

    @Override
    public List<MedicosDto> getAll() {
        List<Medicos> medicosList = medicosRepository.findAll();
        List<MedicosDto>medicosDtos= new ArrayList<>();
        for (Medicos medicos :medicosList ){
            medicosDtos.add(convertModelToDto(medicos));
        }
        return medicosDtos;
    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Medicos medicos = medicosRepository.findById(id).orElseThrow(()->new Exception("Id IS not Found"+id));
        medicosRepository.delete(medicos);
        Map<String,Boolean>map = new HashMap<>();
        map.put("Delete",Boolean.TRUE);
        return map;
    }

    @Override
    public List<MedicosDto> getByPatientId(Long id) {
        List<Medicos> medicos = medicosRepository.findByPatientId(id);
        List<MedicosDto> medicosDtos= new ArrayList<>();
        for(Medicos medicos1: medicos){
            medicosDtos.add(convertModelToDto(medicos1));
        }
        return medicosDtos;
    }

    @Override
    public Long getTotal(Long id) {
        List<MedicosDto> medicosDtos = getByPatientId(id);
        long total = 0;
        for(MedicosDto medicos: medicosDtos){
            total+=medicos.getTotal();
        }
        return total;
    }
}
