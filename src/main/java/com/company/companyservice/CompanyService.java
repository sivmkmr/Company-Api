package com.company.companyservice;

import com.company.apiresponse.ApiResponse;
import com.company.employeeinfo.EmployeeInfo;
import com.company.employeeinfomodel.EmployeeInfoModel;

public interface CompanyService {
	
	public ApiResponse showData();
	
	public ApiResponse getAllEmployeeInfo();

	public ApiResponse saveData( EmployeeInfoModel employeeInfoModel);
	
	public ApiResponse getEmployeeDataById( Integer id);
	
	public ApiResponse updateEmployeeDataById(Integer id, EmployeeInfo employeeInfo);
	
	public ApiResponse deleteDataById( Integer id);
}
