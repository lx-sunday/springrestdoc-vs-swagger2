package com.api.doc.controller.department;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="部门管理")
@RestController
@RequestMapping("/departments")
public class DepartmentController {

	@ApiOperation(value="查询")
	@GetMapping
	public int getList() {
		
		return 0;
	}

	@ApiOperation(value="添加")
	@PostMapping
	public int addOne() {
		
		return 0;
	}
}
