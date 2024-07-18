package com.computer.Repository;

import com.computer.entity.ComputerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComputerEntityRepository extends JpaRepository<ComputerEntity, Long> {

    }
