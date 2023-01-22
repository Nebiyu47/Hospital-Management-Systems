package com.example.backend.Service;

import com.example.backend.dto.BillDto;

import java.util.List;
import java.util.Map;

public interface BillService {
    public BillDto save(BillDto billDto);
    public BillDto getById(long id) throws Exception;
    public List<BillDto> getAll();
    public Map<String , Boolean> delete(long id) throws Exception;
}
