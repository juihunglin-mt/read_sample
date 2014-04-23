package com.sample.dbo;

/**
 * Vars entity. @author MyEclipse Persistence Tools
 */

public class Vars implements java.io.Serializable {

	// Fields

	private Integer varsId;
	private Content content;
	private Integer sort;
	private Integer rowIndex;
	private String rowFilter;
	private String rowReplace;
	private Integer cellIndex;
	private String cellFilter;
	private String cellReplace;
	private Integer active;

	// Constructors

	/** default constructor */
	public Vars() {
	}

	/** minimal constructor */
	public Vars(Content content, Integer sort, Integer active) {
		this.content = content;
		this.sort = sort;
		this.active = active;
	}

	/** full constructor */
	public Vars(Content content, Integer sort, Integer rowIndex,
			String rowFilter, String rowReplace, Integer cellIndex,
			String cellFilter, String cellReplace, Integer active) {
		this.content = content;
		this.sort = sort;
		this.rowIndex = rowIndex;
		this.rowFilter = rowFilter;
		this.rowReplace = rowReplace;
		this.cellIndex = cellIndex;
		this.cellFilter = cellFilter;
		this.cellReplace = cellReplace;
		this.active = active;
	}

	// Property accessors

	public Integer getVarsId() {
		return this.varsId;
	}

	public void setVarsId(Integer varsId) {
		this.varsId = varsId;
	}

	public Content getContent() {
		return this.content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public Integer getSort() {
		return this.sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getRowIndex() {
		return this.rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getRowFilter() {
		return this.rowFilter;
	}

	public void setRowFilter(String rowFilter) {
		this.rowFilter = rowFilter;
	}

	public String getRowReplace() {
		return this.rowReplace;
	}

	public void setRowReplace(String rowReplace) {
		this.rowReplace = rowReplace;
	}

	public Integer getCellIndex() {
		return this.cellIndex;
	}

	public void setCellIndex(Integer cellIndex) {
		this.cellIndex = cellIndex;
	}

	public String getCellFilter() {
		return this.cellFilter;
	}

	public void setCellFilter(String cellFilter) {
		this.cellFilter = cellFilter;
	}

	public String getCellReplace() {
		return this.cellReplace;
	}

	public void setCellReplace(String cellReplace) {
		this.cellReplace = cellReplace;
	}

	public Integer getActive() {
		return this.active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}