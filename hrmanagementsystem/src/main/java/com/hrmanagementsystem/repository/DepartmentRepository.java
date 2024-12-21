package com.hrmanagementsystem.repository;

import com.hrmanagementsystem.projectiondto.DeparmentProjection;
import org.springframework.data.repository.CrudRepository;
import com.hrmanagementsystem.entity.Department;

import java.util.List;

public interface DepartmentRepository extends CrudRepository<Department, Integer> {
	
	Integer deleteByDepartmentId(Integer departmentId);
	List<DeparmentProjection> findBy();
	DeparmentProjection findByDepartmentId(Integer departmentId);
	List<DeparmentProjection> findByDepartmentName(String departmentName);

}


