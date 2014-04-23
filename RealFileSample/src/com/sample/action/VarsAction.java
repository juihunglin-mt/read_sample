package com.sample.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sample.dao.ContentDAO;
import com.sample.dao.VarsDAO;
import com.sample.dbo.Content;
import com.sample.dbo.Vars;

@SuppressWarnings("serial")
public class VarsAction extends ActionSupport {
	private VarsDAO varsDAO;
	private ContentDAO contentDAO;
	
	private Integer contentId;
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
	
	public String allRecords() {
		List<Vars> varses = varsDAO.findAll();
		
		getRequest().setAttribute("varses", varses);
		
		return SUCCESS;
	}
	
	public String cIdRecords() {
		List<Vars> varses = varsDAO.findByContentId(contentId);
		
		getRequest().setAttribute("varses", varses);
		
		return SUCCESS;
	}
	
	public String activeRecords() {
		List<Vars> varses = varsDAO.findByActive(1);
		
		getRequest().setAttribute("varses", varses);
		
		return SUCCESS;
	}
	
	public String getRecord() {
		Vars vars = varsDAO.findById(varsId);
		
		getRequest().setAttribute("vars", vars);
		
		return SUCCESS;
	}
	
	public String saveRecord() {
		Vars vars = new Vars();
		
		Content content = contentDAO.findById(contentId);
		
		vars.setSort(sort);
		vars.setRowIndex(rowIndex);
		vars.setRowFilter(rowFilter);
		vars.setRowReplace(rowReplace);
		vars.setCellIndex(cellIndex);
		vars.setCellFilter(cellFilter);
		vars.setCellReplace(cellReplace);
		vars.setActive(active);
		vars.setContent(content);
		
		varsDAO.save(vars);
		
		getRequest().setAttribute("contentId", contentId);
		
		return SUCCESS;
	}
	
	public String updateRecord() {
		Vars vars = varsDAO.findById(varsId);
		
		Content content = contentDAO.findById(contentId);
		
		vars.setSort(sort);
		vars.setRowIndex(rowIndex);
		vars.setRowFilter(rowFilter);
		vars.setRowReplace(rowReplace);
		vars.setCellIndex(cellIndex);
		vars.setCellFilter(cellFilter);
		vars.setCellReplace(cellReplace);
		vars.setActive(active);
		vars.setContent(content);
		
		varsDAO.attachDirty(vars);
		
		getRequest().setAttribute("contentId", contentId);
		
		return SUCCESS;
	}
	
	public String deleteRecord() {
		Vars vars = varsDAO.findById(varsId);
		
		varsDAO.delete(vars);
		
		getRequest().setAttribute("contentId", contentId);
		
		return SUCCESS;
	}

	private HttpServletRequest getRequest() {
		return  ServletActionContext.getRequest();
	}
	
	public VarsDAO getVarsDAO() {
		return varsDAO;
	}

	public void setVarsDAO(VarsDAO varsDAO) {
		this.varsDAO = varsDAO;
	}

	public Integer getVarsId() {
		return varsId;
	}

	public void setVarsId(Integer varsId) {
		this.varsId = varsId;
	}

	public Content getContent() {
		return content;
	}

	public void setContent(Content content) {
		this.content = content;
	}

	public String getRowReplace() {
		return rowReplace;
	}

	public void setRowReplace(String rowReplace) {
		this.rowReplace = rowReplace;
	}

	public String getCellReplace() {
		return cellReplace;
	}

	public void setCellReplace(String cellReplace) {
		this.cellReplace = cellReplace;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

	public ContentDAO getContentDAO() {
		return contentDAO;
	}

	public void setContentDAO(ContentDAO contentDAO) {
		this.contentDAO = contentDAO;
	}

	public Integer getContentId() {
		return contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Integer getSort() {
		return sort;
	}

	public void setSort(Integer sort) {
		this.sort = sort;
	}

	public Integer getRowIndex() {
		return rowIndex;
	}

	public void setRowIndex(Integer rowIndex) {
		this.rowIndex = rowIndex;
	}

	public String getRowFilter() {
		return rowFilter;
	}

	public void setRowFilter(String rowFilter) {
		this.rowFilter = rowFilter;
	}

	public Integer getCellIndex() {
		return cellIndex;
	}

	public void setCellIndex(Integer cellIndex) {
		this.cellIndex = cellIndex;
	}

	public String getCellFilter() {
		return cellFilter;
	}

	public void setCellFilter(String cellFilter) {
		this.cellFilter = cellFilter;
	}
}
