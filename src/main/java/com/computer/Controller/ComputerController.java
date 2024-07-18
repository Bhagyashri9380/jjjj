package com.computer.Controller;

import com.computer.Dto.ComputerDto;
import com.computer.Service.Computer;
import com.computer.entity.ComputerEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/Computer")
public class ComputerController {
    private Computer computer;

    public ComputerController(Computer computer) {
        this.computer = computer;
    }

    //http://localhost:8080/api/v1/Computer/addComputer

    @PostMapping("/addComputer")
    public ResponseEntity<ComputerDto> addComputer(@RequestBody ComputerDto dto){
        ComputerDto computerDto = computer.addComputer(dto);
        return new ResponseEntity<>(computerDto, HttpStatus.CREATED);
    }
@DeleteMapping
public ResponseEntity<String> deleteComputer(
      @RequestParam  long ComputerId
){
   computer.deleteComputer(ComputerId);
   return new ResponseEntity<>("deleted",HttpStatus.OK);
}

@PutMapping
public ResponseEntity<ComputerEntity> updateComputer(
   @PathVariable     long ComputerId,
      @RequestBody  ComputerDto dto
){
    ComputerEntity computer1 = computer.updateComputer(ComputerId, dto);
    return new ResponseEntity<>(computer1,HttpStatus.OK);
}
@GetMapping
public ResponseEntity <List<ComputerEntity>>getall(){
    List<ComputerEntity> getall = computer.getall();
    return new ResponseEntity<>(getall,HttpStatus.OK);
}
}
