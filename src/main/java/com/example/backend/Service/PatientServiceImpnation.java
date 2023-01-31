package com.example.backend.Service;

import com.example.backend.Entity.Patient;
import com.example.backend.Repository.PatientRepository;
import com.example.backend.dto.PatientDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class PatientServiceImpnation implements PatientService{


    @Autowired
    private PatientRepository patientRepository;

    private Patient convertDtoToModel(PatientDto patientDto){
        Patient patient= new Patient();
        patient.setId(patientDto.getId());
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setPatientAdded(patientDto.getPatientAdded());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setTest(patientDto.getTest());
        return patient;

    }
    private PatientDto convertModelToDto(Patient patient){
        return new PatientDto(patient);
    }

    @Override
    public PatientDto save(PatientDto patientDto) {
        Patient patient = patientRepository.save(convertDtoToModel(patientDto));
        return convertModelToDto(patient);
    }

    @Override
    public PatientDto update(PatientDto patientDto, Long id) throws Exception {
        Patient patient= patientRepository.findById(id).orElseThrow(()-> new Exception("Id is Not Found"+ id));
        patient.setId(patientDto.getId());
        patient.setFirstName(patientDto.getFirstName());
        patient.setLastName(patientDto.getLastName());
        patient.setDateOfBirth(patientDto.getDateOfBirth());
        patient.setPatientAdded(patientDto.getPatientAdded());
        patient.setMobileNumber(patientDto.getMobileNumber());
        patient.setTest(patientDto.getTest());

      PatientDto patientDto1= convertModelToDto(patientRepository.save(patient));
      return patientDto1;
    }

    @Override
    public PatientDto getById(Long id) throws Exception {
        Patient patient = patientRepository.findById(id).orElseThrow(()->new Exception("Id is Not Found"+id));
        return convertModelToDto(patient);
    }

    @Override
    public List<PatientDto> getAll() {
        List<Patient> patients = patientRepository.findAll();
        ArrayList<PatientDto> patientDtos= new ArrayList<>();
        for (Patient patient : patients){
            patientDtos.add(convertModelToDto(patient));
        }
        return patientDtos;
    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Patient patient =patientRepository.findById(id).orElseThrow(()->new Exception("Id Is not Found"+id));
        patientRepository.delete(patient);
        Map<String,Boolean>map = new HashMap<>();
        map.put("delted",Boolean.TRUE);
        return map;
    }

    @Override
    public boolean isExistPatient(PatientDto patientDto) {
        Patient patient = patientRepository.existsByPhoneNumber(patientDto.getMobileNumber());
        if(patient!=null){
            return true;
        }else {
            return false;
        }
     }
}
