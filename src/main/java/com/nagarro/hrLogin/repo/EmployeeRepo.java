package com.nagarro.hrLogin.repo;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.nagarro.hrLogin.entity.Employee;

@Repository
public interface EmployeeRepo extends CrudRepository<Employee, Integer> {

}
