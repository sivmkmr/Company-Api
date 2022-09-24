package com.company.companyserviceimpl;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.company.apiresponse.ApiResponse;
import com.company.companyrepository.CompanyRepository;
import com.company.companyservice.CompanyService;
import com.company.employeeinfo.EmployeeInfo;
import com.company.employeeinfomodel.EmployeeInfoModel;
import com.company.globalconstant.GlobalConstant;

@Service
public class CompanyServiceImpl implements CompanyService {

	@Autowired
	CompanyRepository companyRepository;

//	Dummy API for Testing

	@Override
	public ApiResponse showData() {
		ApiResponse apiResponse = new ApiResponse();
		apiResponse.setMessage(GlobalConstant.dummyApi);
		return apiResponse;

	}

//	Insertion Employee Data

	public ApiResponse saveData(EmployeeInfoModel employeeInfoModel) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();

		EmployeeInfo employeeInfo = new EmployeeInfo();
		try {

			employeeInfo.setEmployeeName(employeeInfoModel.getEmployeeName());
			employeeInfo.setEmployeeDesignation(employeeInfoModel.getEmployeeDesignation());
			employeeInfo.setEmployeeGrade(employeeInfoModel.getEmployeeGrade());
			employeeInfo.setEmployeeSalary(employeeInfoModel.getEmployeeSalary());

			companyRepository.save(employeeInfo);
			apiResponse.setMessage(GlobalConstant.dataInsertionSuccess);

//			return apiResponse;
		} catch (Exception e) {
			apiResponse.setMessage(GlobalConstant.dataInsertionFail);
		}
		return apiResponse;
	}

//	Get All Data from Employee

	@Override
	public ApiResponse getAllEmployeeInfo() {

		ApiResponse apiResponse = new ApiResponse();

		apiResponse.setAllEmployeeInfos(companyRepository.findAll());

		return apiResponse;

	}

//	Get Employee Data By Id

	@Override
	public ApiResponse getEmployeeDataById(Integer id) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();

		Optional<EmployeeInfo> employeeDataFromDb = companyRepository.findById(id);

		if (employeeDataFromDb.isEmpty()) {
			apiResponse.setMessage(GlobalConstant.getDataByIdFail);

		} else {
//			EmployeeInfo empData = employeeDataFromDb.get();
			apiResponse.setEmployeeInfo(employeeDataFromDb.get());
			apiResponse.setMessage(GlobalConstant.getDataByIdSuccess);
//			apiResponse.setEmployeeInfo(empData);
		}
		return apiResponse;

	}

//	Updating Employee Data details by Id

	@Override
	public ApiResponse updateEmployeeDataById(Integer id, EmployeeInfo employeeInfo) {
		// TODO Auto-generated method stub
		ApiResponse apiResponse = new ApiResponse();
		Optional<EmployeeInfo> empDatadb = companyRepository.findById(id);

		if (empDatadb.isEmpty()) {
			apiResponse.setStatus(false);
			apiResponse.setMessage(GlobalConstant.dataUpdationFail);

		} else {
			EmployeeInfo dbData = empDatadb.get();
			dbData.setEmployeeName(employeeInfo.getEmployeeName());
			dbData.setEmployeeDesignation(employeeInfo.getEmployeeDesignation());
			dbData.setEmployeeGrade(employeeInfo.getEmployeeGrade());
			dbData.setEmployeeSalary(employeeInfo.getEmployeeSalary());

			companyRepository.save(dbData);
			apiResponse.setStatus(true);
			apiResponse.setMessage(GlobalConstant.dataupdationSuccess);
		}
		return apiResponse;
	}

//	Delete Employee data By Id

	@Override
	public ApiResponse deleteDataById(Integer id) {

		ApiResponse apiResponse = new ApiResponse();
		Optional<EmployeeInfo> empDatafromdb = companyRepository.findById(id);
		if (empDatafromdb.isEmpty()) {
			apiResponse.setStatus(false);
			apiResponse.setMessage(GlobalConstant.dataDeletionFail);
//			status = false;
		} else {
			companyRepository.deleteById(id);
			apiResponse.setStatus(true);
			apiResponse.setMessage(GlobalConstant.dataDeletionSuccess);
//			status = true;
		}
		return apiResponse;

	}

}
