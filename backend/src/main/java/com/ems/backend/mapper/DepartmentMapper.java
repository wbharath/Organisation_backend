package com.ems.backend.mapper;

import com.ems.backend.dto.DepartmentDto;
import com.ems.backend.entity.Department;

public class DepartmentMapper {
    public static DepartmentDto maptoDepartmentDto(Department department) {
       return new DepartmentDto(
               department.getId(),
               department.getDepartmentName(),
               department.getDepartmentDescription()
       );
    }

    public static Department maptoDepartment(DepartmentDto departmentDto) {
        return new Department(
                departmentDto.getId(),
                departmentDto.getDepartmentName(),
                departmentDto.getDepartmentDescription()
        );
    }
}
