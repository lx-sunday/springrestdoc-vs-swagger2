package com.api.doc.controller.employee;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.doc.entity.Employee;
import com.api.doc.exception.EmployeeNotFoundException;
import com.api.doc.repository.EmployeeRepository;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import springfox.documentation.annotations.ApiIgnore;

@Api(value="员工管理")
@RestController
@RequestMapping("/employees")
class EmployeeController {

	private final EmployeeRepository repository;

	EmployeeController(EmployeeRepository repository) {
		this.repository = repository;
	}

    @ApiOperation(value="查询")
    @ApiImplicitParam(name="name",value="部门名称",required=false,dataType="String",paramType="query")
    @GetMapping
	List<Employee> all(String name) {
    	List<Employee> list = repository.findAll();
		return list;
	}
    
    @ApiOperation(value="保存")
    @ApiImplicitParam(name="employeeUpdateVo",value="employeeUpdateVo",required=true,dataType="EmployeeUpdateVo")
    @PostMapping
	Employee newEmployee(@RequestBody EmployeeUpdateVo employeeUpdateVo) {
    	Employee employee=new Employee(employeeUpdateVo.getName(), employeeUpdateVo.getRole());
		return this.repository.save(employee);
		
	}

    @ApiOperation(value="单个查询")
    @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "path")
	@GetMapping("/{id}")
	Employee one(@PathVariable Long id) {
		return repository.findById(id)
			.orElseThrow(() -> new EmployeeNotFoundException(id));
	}
    

    @ApiOperation(value="更新", notes="根据url的id来指定更新信息")
	@ApiImplicitParams({
			@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long",paramType = "path"),
			@ApiImplicitParam(name = "employeeUpdateVo", value = "EmployeeUpdateVo", required = true, dataType = "EmployeeUpdateVo")
	})
    
	@PutMapping("/{id}")
	Employee replaceEmployee(@RequestBody EmployeeUpdateVo employeeUpdateVo, @PathVariable Long id) {
    	
		return repository.findById(id)
			.map(employee -> {
				employee.setName(employeeUpdateVo.getName());
				employee.setRole(employeeUpdateVo.getRole());
				return repository.save(employee);
			})
			.orElseGet(() -> {
				Employee employee=new Employee(employeeUpdateVo.getName(), employeeUpdateVo.getRole());
				employee.setId(id);
				return repository.save(employee);
			});
	}

	@ApiOperation(value="删除")
	@ApiImplicitParam(name = "id", value = "id", required = true, dataType = "Long", paramType = "path")
	@DeleteMapping("/{id}")
	void deleteEmployee(@PathVariable Long id) {
		repository.deleteById(id);
	}
}
