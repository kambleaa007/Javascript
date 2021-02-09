package com.accenture.lkm.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.accenture.lkm.entity.EmployeeEntity;

public interface EmployeeDAO  extends JpaRepository<EmployeeEntity, Integer>{

}
