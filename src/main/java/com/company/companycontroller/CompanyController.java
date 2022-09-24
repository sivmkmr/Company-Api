package com.company.companycontroller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.company.apiresponse.ApiResponse;
import com.company.companyrepository.CompanyRepository;
import com.company.companyserviceimpl.CompanyServiceImpl;
import com.company.employeeinfo.EmployeeInfo;
import com.company.employeeinfomodel.EmployeeInfoModel;

@RestController
public class CompanyController {

	@Autowired
	CompanyRepository companyRepository;

	@Autowired
	CompanyServiceImpl companyServiceImpl;

//	EmployeeInfoModel employeeInfoModel = new EmployeeInfoModel();

//	Dummy API for Testing

	@GetMapping("/dummy-api")
	public ApiResponse showData() {
		return companyServiceImpl.showData();
	}

//	Insertion Employee Data

	@PostMapping("/insert-data")
	public ApiResponse saveData(@RequestBody EmployeeInfoModel employeeInfoModel) {
//		return companyServiceImpl.saveData(employeeInfoModel);
		return companyServiceImpl.saveData(employeeInfoModel);
	}

//	Get All Data from Employee

	@GetMapping("/get-all-employee-info")
	public ApiResponse getAllEmployeeInfo() {
		return companyServiceImpl.getAllEmployeeInfo();

	}

//	Get Employee Data By Id

	@GetMapping("/get-employee-data-by-id/{id}")
	public ApiResponse getEmployeeDataById(@PathVariable("id") Integer id) {
		return companyServiceImpl.getEmployeeDataById(id);
	}

//	Updating Employee Data details by Id

	@PutMapping("/update-employee-data-by-id/{id}")
	public ApiResponse updateEmployeeDataById(@PathVariable("id") Integer id, @RequestBody EmployeeInfo employeeInfo) {

		return companyServiceImpl.updateEmployeeDataById(id, employeeInfo);

//		boolean status = companyServiceImpl.updateEmployeeDataById(id, employeeInfo);
//		if (status) {
//			return "Data Updated Successfully";
//		}else {
//			return "Data updatation fail...";
//		}
//		return null;
	}

//	Delete Employee data By Id

	@DeleteMapping("/delete-data-by-id/{id}")
	public ApiResponse deleteDataById(@PathVariable("id") Integer id) {

		return companyServiceImpl.deleteDataById(id);

//		boolean status = companyServiceImpl.deleteDataById(id);
//		if (status) {
//			return "Data deleted SuccessFully";
//		}else {
//			return "Data Not Found with this id : "+id;
//		}

	}

}
