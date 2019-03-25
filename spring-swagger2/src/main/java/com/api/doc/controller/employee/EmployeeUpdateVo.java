package com.api.doc.controller.employee;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value="EmployeeUpdateVo",description="封装添加与修改传递参数")
@Data
public class EmployeeUpdateVo {

	@ApiModelProperty(value="员工名称",required=true)
	private String name;
	
	@ApiModelProperty(value="员工角色",required=true)
	private String role;
}
