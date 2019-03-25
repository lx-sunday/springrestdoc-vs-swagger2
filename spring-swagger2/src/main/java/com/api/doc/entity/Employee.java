package com.api.doc.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value="Employee",description="员工信息")
@Data
@Entity
public class Employee {

	@ApiModelProperty(value="员工id")
	@Id
	@GeneratedValue 
	private Long id;
	
	@ApiModelProperty(value="员工名称")
	private String name;
	
	@ApiModelProperty("员工角色")
	private String role;
	
	

	public Employee(String name, String role) {
		this.name = name;
		this.role = role;
	}



     Employee() {
		super();
	}
}
