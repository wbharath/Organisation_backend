package com.ems.backend.service.impl;

import com.ems.backend.dto.DepartmentDto;
import com.ems.backend.entity.Department;
import com.ems.backend.exception.ResourceNotFoundException;
import com.ems.backend.mapper.DepartmentMapper;
import com.ems.backend.repository.DepartmentRepository;
import com.ems.backend.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class DepartmentServiceImpl implements DepartmentService {

    private DepartmentRepository departmentRepository;

    @Override
    public DepartmentDto createDepartment(DepartmentDto departmentDto) {

        Department department = DepartmentMapper.maptoDepartment(departmentDto);
        Department savedDepartment = departmentRepository.save(department);
        return DepartmentMapper.maptoDepartmentDto(savedDepartment);
    }

    @Override
    public DepartmentDto getDepartmentByID(Long departmentID) {
        Department department = departmentRepository.findById(departmentID).orElseThrow(()-> new ResourceNotFoundException("Department does not exist with the given ID :" + departmentID));
        return DepartmentMapper.maptoDepartmentDto(department);
    }

    @Override
    public List<DepartmentDto> getAllDepartments() {
        List<Department> departments = departmentRepository.findAll();
        return departments.stream().map((department -> DepartmentMapper.maptoDepartmentDto(department)))
                .collect(Collectors.toList());

 }

    @Override
    public DepartmentDto updateDepartment(Long departmentId, DepartmentDto updatedDepartment) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department does not exist with the given ID :" + departmentId));

        department.setDepartmentName(updatedDepartment.getDepartmentName());
        department.setDepartmentDescription(updatedDepartment.getDepartmentDescription());
        Department updatedDepartmentObj = departmentRepository.save(department);
        return  DepartmentMapper.maptoDepartmentDto(updatedDepartmentObj);
    }

    @Override
    public void deleteDepartment(Long departmentId) {
        Department department = departmentRepository.findById(departmentId)
                .orElseThrow(()-> new ResourceNotFoundException("Department does not exist with the given ID :" + departmentId));

        departmentRepository.deleteById(departmentId);
    }
}
