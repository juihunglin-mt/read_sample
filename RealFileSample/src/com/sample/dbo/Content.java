package com.sample.dbo;

import java.util.HashSet;
import java.util.Set;

/**
 * Content entity. @author MyEclipse Persistence Tools
 */

public class Content implements java.io.Serializable {

	// Fields

	private Integer contentId;
	private Type type;
	private String name;
	private Set varses = new HashSet(0);

	// Constructors

	/** default constructor */
	public Content() {
	}

	/** minimal constructor */
	public Content(Type type) {
		this.type = type;
	}

	/** full constructor */
	public Content(Type type, String name, Set varses) {
		this.type = type;
		this.name = name;
		this.varses = varses;
	}

	// Property accessors

	public Integer getContentId() {
		return this.contentId;
	}

	public void setContentId(Integer contentId) {
		this.contentId = contentId;
	}

	public Type getType() {
		return this.type;
	}

	public void setType(Type type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set getVarses() {
		return this.varses;
	}

	public void setVarses(Set varses) {
		this.varses = varses;
	}

}