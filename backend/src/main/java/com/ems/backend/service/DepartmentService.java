package com.ems.backend.service;

import com.ems.backend.dto.DepartmentDto;

import java.util.List;

public interface DepartmentService {

    DepartmentDto createDepartment(DepartmentDto departmentDto);

    DepartmentDto getDepartmentByID(Long departmentID);

    List<DepartmentDto> getAllDepartments();

     DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment);

     void deleteDepartment(Long departmentId);
}
