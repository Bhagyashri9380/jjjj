package com.computer.Service;

import com.computer.Dto.ComputerDto;
import com.computer.Repository.ComputerEntityRepository;
import com.computer.entity.ComputerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.List;
import java.util.Optional;

@Service
public class ComputerIMPL implements Computer {

    private ComputerEntityRepository computerEntityRepository;

    public ComputerIMPL(ComputerEntityRepository computerEntityRepository) {
        this.computerEntityRepository = computerEntityRepository;
    }


    @Override
    public ComputerDto addComputer(ComputerDto dto) {
        ComputerEntity entity = new ComputerEntity();
        entity.setName(dto.getName());
        entity.setMobile(dto.getMobile());
        entity.setEmailId(dto.getEmailId());

        ComputerEntity saved = computerEntityRepository.save(entity);
        ComputerDto cd = new ComputerDto();
        cd.setId(saved.getId());
        cd.setName(saved.getName());
        cd.setMobile(saved.getMobile());
        cd.setEmailId(saved.getEmailId());
        return cd;
    }

    @Override
    public ResponseEntity<String>deleteComputer(long ComputerId) {
        computerEntityRepository.deleteById(ComputerId);
        return new ResponseEntity<>("Record delete", HttpStatus.OK);
    }

    @Override
    public ComputerEntity updateComputer(long computerId, ComputerDto dto) {
        Optional<ComputerEntity> byId = computerEntityRepository.findById(computerId);
        ComputerEntity computer1 = byId.get();
        computer1.setName(dto.getName());
        computer1.setMobile(dto.getMobile());
        computer1.setEmailId(dto.getEmailId());
        return computerEntityRepository.save(computer1);
    }

    @Override
    public List<ComputerEntity> getall() {
        return computerEntityRepository.findAll();

    }

    @Override
    public ComputerEntity getById(long computerId) {
        return null;
    }
}

















