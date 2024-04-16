package com.tadigital.bytebrain.student.entity;

public class Quiz {
	private int categoryId;
	private int subCategoryId;
	private String categoryName;//category
	private String subCategoryName;//subCategory
	
	public int getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(int categoryId) {
		this.categoryId = categoryId;
	}

	public int getSubCategoryId() {
		return subCategoryId;
	}

	public void setSubCategoryId(int subCategoryId) {
		this.subCategoryId = subCategoryId;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	public String getSubCategoryName() {
		return subCategoryName;
	}

	public void setSubCategoryName(String subCategoryName) {
		this.subCategoryName = subCategoryName;
	}

	@Override
	public String toString() {
		return "Quiz [categoryId=" + categoryId + ", subCategoryId=" + subCategoryId + ", categoryName=" + categoryName
				+ ", subCategoryName=" + subCategoryName + "]";
	}
}
