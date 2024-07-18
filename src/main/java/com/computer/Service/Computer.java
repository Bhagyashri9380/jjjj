package com.computer.Service;

import com.computer.Dto.ComputerDto;
import com.computer.entity.ComputerEntity;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface Computer {
    public ComputerDto addComputer(ComputerDto dto);

    ResponseEntity<String> deleteComputer(long computerId);

    ComputerEntity updateComputer(long computerId, ComputerDto dto);

    public List<ComputerEntity> getall();

    ComputerEntity getById(long computerId);
}






