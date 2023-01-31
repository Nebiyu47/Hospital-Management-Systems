package com.example.backend.Service;

import com.example.backend.dto.TestDto;

import java.util.List;
import java.util.Map;

public interface TestService {
    public TestDto save(TestDto testDto);
    public List<TestDto> getAll();
    public TestDto getById(Long id)throws Exception;
    public TestDto update(TestDto testDto,Long id) throws Exception;
    public Map<String,Boolean> deleted(Long id) throws Exception;
}
