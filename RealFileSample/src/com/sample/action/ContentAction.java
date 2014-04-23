package com.sample.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;

import com.opensymphony.xwork2.ActionSupport;
import com.sample.dao.ContentDAO;
import com.sample.dao.TypeDAO;
import com.sample.dbo.Content;
import com.sample.dbo.Type;

@SuppressWarnings("serial")
public class ContentAction extends ActionSupport {
	private ContentDAO contentDAO;
	private TypeDAO typeDAO;

	private Integer typeId;
	private Integer id;
	private String name;
	private Integer active;
	
	public String allRecords() {
		List<Content> contents = contentDAO.findAll();
		
		getRequest().setAttribute("contents", contents);
		
		return SUCCESS;
	}
	
	public String getRecord() {
		Content content = contentDAO.findById(id);
		
		getRequest().setAttribute("content", content);
		
		return SUCCESS;
	}
	
	public String saveRecord() {
		Content content = new Content();
		Type type = typeDAO.findById(typeId);
		content.setName(name);
		content.setType(type);
		
		contentDAO.save(content);
		
		return SUCCESS;
	}
	
	public String updateRecord() {
		Content content = contentDAO.findById(id);
		Type type = typeDAO.findById(typeId);
		content.setName(name);
		content.setType(type);
		
		contentDAO.attachDirty(content);
		
		return SUCCESS;
	}
	
	public String deleteRecord() {
		Content content = contentDAO.findById(id);
		
		contentDAO.delete(content);
		
		return SUCCESS;
	}
	
	private HttpServletRequest getRequest() {
		return  ServletActionContext.getRequest();
	}

	public ContentDAO getContentDAO() {
		return contentDAO;
	}

	public void setContentDAO(ContentDAO contentDAO) {
		this.contentDAO = contentDAO;
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

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
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
