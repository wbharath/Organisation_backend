package com.ems.backend.repository;

import com.ems.backend.entity.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
//Here JpaRepository class takes two parameters, on is Jpa Enitity and another is primry key of that entity
//below interface would implement CRUD operations on the passed JPA Entity
public interface EmployeeRepository extends JpaRepository<Employee,Long> {

}
