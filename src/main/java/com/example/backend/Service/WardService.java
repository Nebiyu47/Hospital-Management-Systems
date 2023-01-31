package com.example.backend.Service;

import com.example.backend.dto.WardDto;

import java.util.List;
import java.util.Map;

public interface WardService {
    public WardDto save(WardDto wardDto);
    public WardDto update(WardDto wardDto,Long id) throws Exception;
    public WardDto getById(Long id) throws Exception;
    public List<WardDto> getAll();
    public Map<String,Boolean> deleted(Long id) throws Exception;
}
