package com.example.backend.Service;

import com.example.backend.Entity.Bill;
import com.example.backend.Repository.BillRepository;
import com.example.backend.dto.BillDto;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

@Service

public class BillServiceImplnation implements BillService {

    @Autowired
    private BillRepository billRepository;

    public BillServiceImplnation(BillRepository billRepository){
        this.billRepository=billRepository;
    }
    private Bill convertBillDtoToModel(BillDto billDto){
        Bill bill = new Bill();
        bill.setId(billDto.getId());
        bill.setBillDate(billDto.getBillDate());
        bill.setBillAmount(billDto.getBillAmount());
        bill.setinsuared(billDto.isInsuared());
        bill.setInsurance(billDto.getInsurance());
        bill.setPatient(billDto.getPatient());

          return bill;
    }
    private BillDto convertModelToDto(Bill bill){
        return new BillDto(bill);
    }

    @Override
    public BillDto save(BillDto billDto){
        Bill bill = convertBillDtoToModel(billDto);
        bill.setBillDate(new Date());
        return convertModelToDto(billRepository.save(bill));
    }

    @Override
    public BillDto update(BillDto billDto ,Long id) throws Exception{
        Bill bill= billRepository.findById(id).orElseThrow(()-> new Exception("Id is not Found"+id));
        bill.setId(billDto.getId());
        bill.setBillDate(billDto.getBillDate());
        bill.setBillAmount(billDto.getBillAmount());
        bill.setinsuared(billDto.isInsuared());
        return convertModelToDto(bill);
    }


    @Override
    public BillDto getById(long id) throws Exception {
        Bill bill = billRepository.findById(id).orElseThrow(()->  new Exception("Id is not found"+ id));
        return convertModelToDto(bill);

    }

    @Override
    public List<BillDto> getAll(){
       List<Bill> billList= billRepository.findAll();
       List<BillDto> billDtos=new ArrayList<>();
       for(Bill bill : billList){
           billDtos.add(convertModelToDto(bill));
       }
       return billDtos;
    }

    @Override
    public Map<String , Boolean> delete(long id) throws Exception{
        Bill bill = convertBillDtoToModel(getById(id));
        billRepository.delete(bill);
        HashMap<String,Boolean> response= new HashMap<>();
        response.put("Delete",Boolean.TRUE);
        return response;
    }



}
