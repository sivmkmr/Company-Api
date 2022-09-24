package com.company.apiresponse;

import java.util.List;

import com.company.employeeinfo.EmployeeInfo;
import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ApiResponse {

	private EmployeeInfo employeeInfo;

	private String message;

	private List<EmployeeInfo> allEmployeeInfos;

	private boolean status;

//	Getter And Setters

	public EmployeeInfo getEmployeeInfo() {
		return employeeInfo;
	}

	public void setEmployeeInfo(EmployeeInfo employeeInfo) {
		this.employeeInfo = employeeInfo;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<EmployeeInfo> getAllEmployeeInfos() {
		return allEmployeeInfos;
	}

	public void setAllEmployeeInfos(List<EmployeeInfo> allEmployeeInfos) {
		this.allEmployeeInfos = allEmployeeInfos;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

}
