package com.example.backend.Service;

import com.example.backend.Entity.Test;
import com.example.backend.Repository.TestRepository;
import com.example.backend.dto.TestDto;
import jakarta.transaction.Transactional;
import lombok.experimental.Accessors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@Transactional
public class TestServiceImplnation implements TestService {
    @Autowired
    private TestRepository testRepository;


    private Test convertDtoToModel(TestDto testDto){
        Test test= new Test();
        test.setId(testDto.getId());
        test.setTestDate(testDto.getTestDate());
        test.setTestName(testDto.getTestName());
        test.setDoctor(testDto.getDoctor());
        return test;
    }

    private TestDto convertTestModelToDto(Test test){
        return new TestDto(test);
    }
    @Override
    public TestDto save(TestDto testDto) {
        Test test = testRepository.save(convertDtoToModel(testDto));
        return convertTestModelToDto(test);
    }

    @Override
    public List<TestDto> getAll() {
        List<Test> tests = testRepository.findAll();
        List<TestDto> testDtos = new ArrayList<>();
        for(Test test: tests){
            testDtos.add(convertTestModelToDto(test));
        }
        return testDtos;
    }

    @Override
    public TestDto getById(Long id) throws Exception {
        Test test = testRepository.findById(id).orElseThrow(()->new Exception("Id Is not Found"+id));
        return convertTestModelToDto(test);
    }

    @Override
    public TestDto update(TestDto testDto, Long id) throws Exception {
        Test test =testRepository.findById(id).orElseThrow(()->new Exception("Id is Not Found"+id));
        test.setId(testDto.getId());
        test.setTestDate(testDto.getTestDate());
        test.setTestName(testDto.getTestName());
        test.setDoctor(testDto.getDoctor());
        return convertTestModelToDto(test);
    }

    @Override
    public Map<String, Boolean> deleted(Long id) throws Exception {
        Test test = convertDtoToModel(getById(id));
        testRepository.delete(test);
        Map<String,Boolean>res= new HashMap<>();
        res.put("Deleted",Boolean.TRUE);
        return res;
    }
}
