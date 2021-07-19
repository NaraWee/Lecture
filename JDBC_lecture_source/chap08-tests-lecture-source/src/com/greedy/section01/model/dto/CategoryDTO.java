package com.greedy.section01.model.dto;

public class CategoryDTO {

	private int code;
	private String name;
	private Integer refCateGoryCode;
	
	public CategoryDTO() {}

	public CategoryDTO(int code, String name, Integer refCateGoryCode) {
		super();
		this.code = code;
		this.name = name;
		this.refCateGoryCode = refCateGoryCode;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getrefCateGoryCode() {
		return refCateGoryCode;
	}

	public void setRefCategoryCode(Integer refCateGoryCode) {
		this.refCateGoryCode = refCateGoryCode;
	}

	@Override
	public String toString() {
		return "CategoryDTO [code=" + code + ", name=" + name + ", refCateGoryCode=" + refCateGoryCode + "]";
	}
	
}
