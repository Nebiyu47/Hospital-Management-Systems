package com.example.backend.Service;

import com.example.backend.Entity.Department;
import com.example.backend.Entity.Doctor;
import com.example.backend.Repository.DoctorRepository;
import com.example.backend.dto.DepartmentDto;
import com.example.backend.dto.DoctorDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class DoctorServiceImplnation implements DoctorService{


    @Autowired
    private DoctorRepository doctorRepository;

    private Doctor convertDoctorDtoToModel(DoctorDto doctorDto){
        Doctor doctor = new Doctor();
        doctor.setId(doctorDto.getId());
        doctor.setDoctorName(doctorDto.getDoctorName());
        doctor.setDoctorAddress(doctorDto.getDoctorAddress());
        doctor.setDoctorPhoneNumber(doctor.getDoctorPhoneNumber());
        doctor.setDepartment(doctor.getDepartment());
        doctor.setSpecialization(doctor.getSpecialization());
        return doctor;
    }
    private DoctorDto convertModelToDto(Doctor doctor){
        return new DoctorDto(doctor);
    }

    @Override
    public DoctorDto save(DoctorDto doctorDto) {
         Doctor doctor =  convertDoctorDtoToModel(doctorDto);
         doctorRepository.save(doctor);
         return convertModelToDto(doctor);
    }

    @Override
    public DoctorDto update(DoctorDto doctorDto, Long id) throws Exception {
       DoctorDto dto = getById(id);
       dto.setId(doctorDto.getId());
       dto.setDoctorName(doctorDto.getDoctorName());
       dto.setDoctorAddress(doctorDto.getDoctorAddress());
       dto.setDoctorPhoneNumber(doctorDto.getDoctorPhoneNumber());
       dto.setDepartment(doctorDto.getDepartment());
       dto.setSpecialization(doctorDto.getSpecialization());

       Doctor doctor= convertDoctorDtoToModel(dto);
       doctorRepository.save(doctor);
       return convertModelToDto(doctor);

    }

    @Override
    public DoctorDto getById(Long iD) throws Exception{
        Doctor doctor = doctorRepository.findById(iD).orElseThrow(()->new Exception("ID is Not Found"+ iD));

        return  convertModelToDto(doctor);
    }

    @Override
    public List<DoctorDto> getAll() {
        List<Doctor>doctorList = doctorRepository.findAll();
        List<DoctorDto>doctorDtos=new ArrayList<>();
        for(Doctor doctor: doctorList){
            doctorDtos.add(convertModelToDto(doctor));
        }
        return doctorDtos;

    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Doctor doctor = convertDoctorDtoToModel(getById(id));
        doctorRepository.delete(doctor);
        Map<String,Boolean> response = new HashMap<>();
        response.put("Deleted",Boolean.TRUE);
        return response;
    }

    @Override
    public boolean existsByNumber(DoctorDto doctorDto) {
       Doctor doctor = doctorRepository.existsByDoctorPhoneNumber(doctorDto.getDoctorPhoneNumber());
       if(doctor!=null){
           return true;
       }else {
           return false;
       }
    }
}
