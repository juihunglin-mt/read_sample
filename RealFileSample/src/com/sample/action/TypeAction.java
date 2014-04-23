package com.sample.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sample.dao.TypeDAO;
import com.sample.dbo.Type;

@SuppressWarnings("serial")
public class TypeAction extends ActionSupport {
	private TypeDAO typeDAO;

	private Integer typeId;
	private String name;
	private Integer active;
	
	public String allRecords() {
		List<Type> types = typeDAO.findAll();
		
		getRequest().setAttribute("types", types);
		
		return SUCCESS;
	}
	
	public String activeRecords() {
		List<Type> types = typeDAO.findByActive(1);
		
		getRequest().setAttribute("types", types);
		
		return SUCCESS;
	}
	
	public String getRecord() {
		Type type = typeDAO.findById(typeId);
		
		getRequest().setAttribute("type", type);
		
		return SUCCESS;
	}
	
	private HttpServletRequest getRequest() {
		return  ServletActionContext.getRequest();
	}

	public TypeDAO getTypeDAO() {
		return typeDAO;
	}

	public void setTypeDAO(TypeDAO typeDAO) {
		this.typeDAO = typeDAO;
	}

	public Integer getTypeId() {
		return typeId;
	}

	public void setTypeId(Integer typeId) {
		this.typeId = typeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getActive() {
		return active;
	}

	public void setActive(Integer active) {
		this.active = active;
	}

}
