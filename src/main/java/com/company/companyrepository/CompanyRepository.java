package com.company.companyrepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.company.employeeinfo.EmployeeInfo;

public interface CompanyRepository extends JpaRepository<EmployeeInfo, Integer>{

}
